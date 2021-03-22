#!/usr/bin/python3.8

import argparse
from dataclasses import dataclass, asdict, field
from enum import Enum, auto
from functools import wraps
import glob
from multiprocessing import Pool
import os
from pathlib import Path
from typing import Any, List, Optional

from dacite import from_dict
from benchmarks import Bug
import xml.etree.ElementTree as ET
import utils
import shutil
from config import *


ROOT_DIR = Path(__file__).resolve().parent.parent
BENCHMARKS_DIRECTORY = "/media/4tb/npex/vfix/original"
VFIX_DIRECTORY = "/media/4tb/npex/vfix/vfix"
JUNIT_JAR_PATH = "/media/4tb/npex/vfix/vfix/jar/junit-4.13.1.jar"
HAM_JAR_PATH = "/media/4tb/npex/vfix/vfix/jar/hamcrest-core-1.3.jar"

@dataclass
class Flag:
    INIT: str = "INIT"
    NPE_FOUND: str = "NPE_FOUND"
    BUILDABLE: str = "BUILDABLE"
    MAIN_COMPILED: str = "MAIN_COMPILED"
    NPE_TRIGGERABLE: str = "NPE_TRIGGERABLE"
    GZOLTAR_SUCCEEDS: str = "GZOLTAR_SUCCEEDS"


@dataclass
class VFixConfiguration:
    nullpointer: str
    deps: List[str]
    main: str = "Main"
    test: str = "TestMain"

    def write(self, outpath):
        with open(outpath, "w") as f:
            f.write(f"main={self.main}\n")
            f.write(f"test={self.test}\n")
            f.write(f"nullpointer={self.nullpointer}\n")
            deps = ":".join([f"/../{jar}" for jar in self.deps])
            f.write(f"deps={deps}\n")


@dataclass
class JavaSource:
    CLASSPATH = f"target/*:target/dependency/*:{JUNIT_JAR_PATH}:{HAM_JAR_PATH}:."

    root: str
    name: str
    contents: str
    compile_cmd: Optional[str] = None
    run_cmd: Optional[str] = None

    def get_source_path(self):
        return f"{self.root}/{self.name}.java"

    def get_class_path(self):
        return f"{self.root}/{self.name}.class"

    def write(self):
        with open(self.get_source_path(), "w") as f:
            f.write(self.contents)
        return True

    def compile(self):
        self.compile_cmd = f"javac -cp \"{self.CLASSPATH}\" {self.get_source_path()}"
        if utils.execute(self.compile_cmd, dir=self.root, verbosity=1).return_code != 0:
            return False
        return True

    def run_java(self, cwd, fp):
        self.run_cmd = f"java -cp \"{self.CLASSPATH}\" {self.name}"
        ret = utils.execute(self.run_cmd, dir=cwd)
        write = False
        for line in ret.stderr.splitlines():
            "java.lang.NullPointerException" in line and (write := True)
            write and fp.write(line + "\n")
        return write == True


class MainSource(JavaSource):
    @classmethod
    def generate(cls, root, klass, method):
        contents = (
            f"public class Main {{\n"
            f"   public static void main(String[] args) throws Exception {{\n"
            f"       {klass} testClass = new {klass}();\n"
            f"       testClass.{method}();\n"
            f"  }}\n"
            f"}}"
        )
        return cls(root, "Main", contents)


class TestMainSource(JavaSource):
    @classmethod
    def generate(cls, root):
        contents = (
            f"import org.junit.Test;\n\n"
            f"public class TestMain {{\n"
            f"  @Test\n"
            f"  public void test() throws Exception {{\n"
            f"      Main.main(null);\n"
            f"  }}\n"
            f"}}"
        )
        return cls(root, "TestMain", contents)


@dataclass
class Proj:
    Cache = "vfix.json"

    bug_id: str
    bug: Bug
    benchmark_dir: str
    root_dir: str
    config_dir: str
    source_dir: str
    target_dir: str
    flags: List[str]

    nullpointer: Optional[str] = None
    vfixConfig: Optional[VFixConfiguration] = None
    main: Optional[JavaSource] = None
    test: Optional[JavaSource] = None

    @classmethod
    def load(cls, cache):
        return from_dict(cls, utils.read_json_from_file(cache))

    @classmethod
    def from_bug_id(cls, bug_id, clean):
        branch = bug_id if bug_id.endswith("-buggy") else f"{bug_id}-buggy"
        benchmark_dir = f"{BENCHMARKS_DIRECTORY}/{branch}"
        bug = Bug.from_json(f"{benchmark_dir}/bug.json")
        vfix_bug_id = bug_id.strip("-buggy").replace("-", "_") + "-1"
        root_dir = f"{VFIX_DIRECTORY}/dataset/{vfix_bug_id}"
        config_dir, source_dir, target_dir = (
            dirs := [f"{root_dir}/{dir}" for dir in ["config", "source", "target"]]
        )
        if os.path.exists((cache := f"{root_dir}/{cls.Cache}")) and not clean:
            print(f"{bug_id}: cache found")
            return cls.load(cache)
        try:
            shutil.rmtree(root_dir, ignore_errors=True)
            npe = utils.read_json_from_file(f"{benchmark_dir}/npe.json")
            # check existence just to make sure that if root dir has been removed in clean mode
            [os.makedirs(d, exist_ok=False) for d in dirs]
            utils.copyfile(benchmark_dir, source_dir, inner=True, verbosity=1)
            return cls(bug_id, bug, benchmark_dir, root_dir, *dirs, [Flag.INIT])

        except (FileNotFoundError, KeyError) as e:
            print(f"{bug_id}: failed to initialize due to {e}")
            return None

    def store(self, flag=None):
        if flag:
            self.flags.append(flag)
        utils.save_dict_to_jsonfile(f"{self.root_dir}/{self.Cache}", asdict(self))

    def step(flag, failure_msg):
        def wrapper(method):
            @wraps(method)
            def _impl(self, *args, **kwargs):
                if flag in self.flags:
                    print(
                        f"{self.bug_id}: {flag} is already marked. Jump to next next step"
                    )
                    return True
                if method(self, *args, **kwargs) == True:
                    self.store(flag)
                else:
                    raise Exception(self.bug_id, failure_msg)

            return _impl

        return wrapper

    @step(flag=Flag.NPE_FOUND, failure_msg="could not find npe")
    def prepare(self):
        # Set java version locally via jenv
        jenv_cmd = f'jenv local 1.{self.bug.build_info.java_version}'
        utils.execute(jenv_cmd, dir=self.source_dir)

        npe = utils.read_json_from_file(f"{self.benchmark_dir}/npe.json")
        if "nullpointer" in npe:
            self.nullpointer = npe["nullpointer"]
            return True
        else:
            return False

    @step(flag=Flag.BUILDABLE, failure_msg="failed to build")
    def build(self):
        Pom(f"{self.source_dir}/pom.xml").modify()
        java_version = self.bug.build_info.java_version
        compile_cmd = utils.get_compile_command(
            cwd=self.source_dir,
            project=None,
            java_version=java_version,
            phase="package",
            mvn_additional_options=[MVN_SKIP_TESTS, "dependency:copy-dependencies"],
        ) 
        
        if (utils.execute(compile_cmd, dir=self.source_dir, env=utils.set_java_version(java_version), verbosity=1,).return_code != 0) :
            return False

        os.makedirs(f"{self.target_dir}/classes")
        os.makedirs(f"{self.target_dir}/test-classes")
        if os.path.isdir(f"{self.source_dir}/src"):
            if os.path.isdir(f"{self.source_dir}/src/main/java"):
                utils.copyfile(f"{self.source_dir}/src/main/java", self.source_dir, inner=True, verbosity=1)
            for testjar in (glob.glob(f"{self.source_dir}/**/target/*-tests.jar")):
                utils.copyfile(testjar, f"{self.source_dir}/target/", verbosity=2)
        else:
            return False
        utils.copyfile(f"{self.source_dir}/target", self.target_dir, inner=True, verbosity=1)
        utils.copyfile(f"{self.source_dir}/target/dependency", self.target_dir, inner=True, verbosity=1)


        dep_jars = [ os.path.basename(jar) for jar in glob.glob(f"{self.target_dir}/*.jar") ]
        self.vfixConfig = VFixConfiguration(self.nullpointer, deps=dep_jars)
        self.vfixConfig.write(f"{self.config_dir}/config")
        return True

    @step(Flag.MAIN_COMPILED, "failed to compile main or test")
    def compile(self):
        # Write Main/TestMain.java
        test_class_name = self.bug.test_info.testcases[0].classname
        test_method = self.bug.test_info.testcases[0].method

        main = MainSource.generate(self.source_dir, test_class_name, test_method)
        test_main = TestMainSource.generate(self.source_dir)
        self.main, self.test = main, test_main

        main.write()
        test_main.write()

        # Compile Main/TestMain.java
        if not main.compile() or not test_main.compile():
            return False

        utils.copyfile(
            main.get_class_path(),
            (classes_dir := f"{self.target_dir}/classes"),
            verbosity=1,
        )
        utils.copyfile(
            test_main.get_class_path(), f"{self.target_dir}/test-classes", verbosity=1
        )
        package_as_dir = ".".join(test_class_name.split(".")[:-1]).replace(".", "/")
        test_class_file = (
            f'{self.target_dir}/test-classes/{test_class_name.replace(".", "/")}.class'
        )
        utils.copyfile(test_class_file, f"{classes_dir}/{package_as_dir}", verbosity=1)

        return True

    @step(Flag.NPE_TRIGGERABLE, "failed to trigger npe")
    def run_main(self):
        # Run Main.class and extract NPE log
        with open(log := f"{self.config_dir}/log", "w") as f:
            return self.main.run_java(cwd=self.source_dir, fp=f) == True

    @step(Flag.GZOLTAR_SUCCEEDS, "failed to run gzoltar")
    def run_gzoltar(self):
        vfix_bug_id = os.path.basename(self.root_dir).split("-")[0]
        cmd = f"java -jar VFix.jar {vfix_bug_id} 1"
        return utils.execute(cmd, dir=VFIX_DIRECTORY, verbosity=1).return_code == 0


class Pom:
    pom_path: str
    tree: ET.ElementTree
    DEPENDENCIES_DIR = "lib.dependencies"

    def __init__(self, pom_path):
        self.pom_path = pom_path
        self.tree = ET.parse(pom_path)

    def modify(self):
        tree = self.tree

        # Remove namespaces
        nsl = len(ns := "{http://maven.apache.org/POM/4.0.0}")
        for elem in self.tree.getroot().iter():
            elem.tag = elem.tag[nsl:] if elem.tag.startswith(ns) else elem.tag

        plugins = tree.find("build/plugins")
        if plugins == None:
            plugins = tree.find("build/pluginManagement/plugins")
        if (jar_plugin := tree.find(".//*[.='maven-jar-plugin']/..")) and jar_plugin in plugins :
            plugins.remove(jar_plugin)
        if (dep_plugin := tree.find(".//*[.='maven-dependency-plugin']/..")) and jar_plugin in plugins :
            plugins.remove(dep_plugin)

        # Remove all <provided> tags
        for node in tree.findall(".//dependency[scope='provided']"):
            node.remove(node.find("scope"))

        jar_plugin = ET.XML(
            "<plugin>"
            "<artifactId>maven-jar-plugin</artifactId>"
            "<version>2.4</version>"
            "<executions>"
            "<execution><goals><goal>test-jar</goal></goals></execution>"
            "</executions>"
            "</plugin>"
        )

        dep_plugin = ET.XML(
            "<plugin>"
                "<groupId>org.apache.maven.plugins</groupId>"
                "<artifactId>maven-dependency-plugin</artifactId>"
                "<executions>"
                    "<execution>"
                        "<id>copy-dependencies</id>"
                        "<phase>compile</phase>"
                        "<goals><goal>copy-dependencies</goal></goals>"
                    "</execution>"
                "</executions>"
                "<configuration>"
                    "<outputDirectory>${session.executionRootDirectory}/target</outputDirectory>"
                "</configuration>"
            "</plugin>"
        )

        # plugins.append(jar_plugin)
        plugins.append(dep_plugin)

        tree.write(self.pom_path, method="xml")


def run(bug_id, clean):
    try:
        proj = Proj.from_bug_id(bug_id, clean)
        proj.prepare()
        proj.build()
        proj.compile()
        proj.run_main()
        proj.run_gzoltar()
    except Exception as e:
        print(f"{bug_id}: {e}")


if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument("--bug-id", help="get repository info from commit url")
    parser.add_argument("--clean", action="store_true", default=False, help="remove vfix-cache and re-run all steps")
    args = parser.parse_args()

    if args.bug_id:
        run(args.bug_id, args.clean)

    else:
        target_branches = [
            os.path.basename(br)
            for br in glob.glob(".git/refs/remotes/origin/benchmarks/*-buggy")
        ]

        p = Pool(12)
        p.map(run, target_branches)

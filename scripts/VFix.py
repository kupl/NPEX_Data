#!/usr/bin/python3.8

import argparse
import glob
import os
from os import name
from benchmarks import Bug, ROOT_DIR
from config import *
import utils
from pathlib import Path
import xml.etree.ElementTree as ET

# INPUT: BUG-ID, target-directory
# OUTPUT: target-directory/setting된 bug-id project

BENCHMARKS_DIRECTORY = "/home/june/project/NPEX_data/benchmarks"
VFIX_DIRECTORY = "/home/june/project/vfix"
ROOT_DIR = Path(__file__).resolve().parent.parent
JUNIT_JAR_PATH = "/home/june/project/vfix/jar/junit-4.13.1.jar"


"""
Phase 1: PREPARE
  1. Prepare VFix directories in bug-id directory: config, source, target 
  2. Copy repository directory to bug-id/source/
  3. Modify pom to generate jars
  4. Build project to generate jars
  5. Copy root package directory into source directory
  6. Copy target directory to bug-id/target
  7. Copy bug-id/target/test-classes/* to bug-id/target/classes/
  8. Write config/config
"""


def prepare(bug_id):
    bug_repo = f"{BENCHMARKS_DIRECTORY}/{bug_id}"
    bug = Bug.from_json(f"{bug_repo}/bug.json")
    project_root_dir = f"{VFIX_DIRECTORY}/dataset/{bug_id}"
    project_source_dir = f"{project_root_dir}/source"
    os.makedirs(f"{project_root_dir}/config")
    os.makedirs(f"{project_root_dir}/source")
    os.makedirs(f"{project_root_dir}/target")
    utils.copyfile(bug_repo, f"{project_root_dir}/source", inner=True, verbosity=1)

    # Modify pom
    modify_pom(f"{project_source_dir}/pom.xml")

    # Build
    build(bug, project_source_dir)

    # Copy root pacakge!
    utils.copyfile(
        f"{project_source_dir}/src/main/java",
        project_source_dir,
        inner=True,
        verbosity=1,
    )

    # Copy taget directory to bug-id/target
    utils.copyfile(
        f"{project_source_dir}/target/",
        f"{project_root_dir}/target",
        inner=True,
        verbosity=1,
    )

    # Copy project classes in test-classes to classes
    utils.copyfile(
        f"{project_source_dir}/target/test-classes",
        f"{project_root_dir}/target/classes",
        inner=True,
        verbosity=1,
    )

    # Write config
    config_path = f"{project_root_dir}/config/config"
    dep_jars = [
        os.path.basename(jar) for jar in glob.glob(f"{project_root_dir}/target/*.jar")
    ]
    npe_json = utils.read_json_from_file(f"{project_source_dir}/npe.json")
    with open(f'{project_source_dir}/{npe_json["filepath"]}', "r") as f:
        print(f"Deref field: {npe_json['deref_field']}")
        print(f'Sink line: {f.readlines()[npe_json["line"] - 1]}')
    nullpointer = input(f"Enter nullpointer for {bug_id}: ")
    write_config(config_path, nullpointer, dep_jars)


def build(bug, dir):
    java_version = bug.build_info.java_version
    compile_cmd = utils.get_compile_command(
        dir,
        java_version=java_version,
        phase="package",
        mvn_additional_options=MVN_SKIP_TESTS,
    )
    return utils.execute(
        compile_cmd,
        dir=dir,
        env=utils.set_java_version(java_version=java_version),
        verbosity=1,
    )


def modify_pom(pom_path):
    tree = ET.parse(pom_path)

    # Remove namespaces
    nsl = len(ns := "{http://maven.apache.org/POM/4.0.0}")
    for elem in tree.getroot().iter():
        elem.tag = elem.tag[nsl:] if elem.tag.startswith(ns) else elem.tag

    plugins = tree.find("build/plugins")
    if (jar_plugin := tree.find(".//*[.='maven-jar-plugin']/..")) :
        plugins.remove(jar_plugin)
    if (asm_plugin := tree.find(".//*[.='maven-jar-plugin']/..")) :
        plugins.remove(asm_plugin)

    jar_plugin = ET.XML(
        "<plugin>"
        "<artifactId>maven-jar-plugin</artifactId>"
        "<version>2.4</version>"
        "<executions>"
        "<execution><goals><goal>test-jar</goal></goals></execution>"
        "</executions>"
        "</plugin>"
    )

    asm_plugin = ET.XML(
        "<plugin>"
        "<artifactId>maven-assembly-plugin</artifactId>"
        "<version>3.0.0</version>"
        "<configuration>"
        "<descriptorRefs>"
        "<descriptorRef>jar-with-dependencies</descriptorRef>"
        "</descriptorRefs>"
        "</configuration>"
        "<executions>"
        "<execution><phase>package</phase><goals><goal>single</goal></goals></execution>"
        "</executions>"
        "</plugin>"
    )
    plugins.append(asm_plugin)
    plugins.append(jar_plugin)

    tree.write(pom_path, method="xml")


def write_config(outpath, nullpointer, dep_jars, main="Main", test="TestMain"):
    deps = ":".join([f"/../{jar}" for jar in dep_jars])
    with open(outpath, "w") as f:
        f.write(f"main={main}\n")
        f.write(f"test={test}\n")
        f.write(f"nullpointer={nullpointer}\n")
        f.write(f"deps={deps}\n")


"""
Phase 2: PREPARE RUN (INPUT: manually written Main.java, config)
  1. Generate TestMain.java
  2. Compile both sources: Main.class, TestMain.class
  3. Execute Main.class to generate NPE log
  4. Move Main/TestMain.class properly
"""


def prepare2(bug_id):
    bug_repo = f"{BENCHMARKS_DIRECTORY}/{bug_id}"
    project_root_dir = f"{VFIX_DIRECTORY}/dataset/{bug_id}"
    project_source_dir = f"{project_root_dir}/source"
    project_target_dir = f"{project_root_dir}/target"
    project_config_dir = f"{project_root_dir}/config"
    bug = Bug.from_json(f"{bug_repo}/bug.json")

    # Write Main/TestMain.java
    testClass = bug.test_info.testcases[0].classname
    testMethod = bug.test_info.testcases[0].method
    write_main(testClass, testMethod, Path(f"{project_source_dir}/Main.java"))
    write_test(Path(f"{project_source_dir}/TestMain.java"))

    # Compile Main/TestMain.java
    mainClass, _ = compile_classes(bug_id, project_source_dir, project_target_dir)

    # Run Main.class and extract NPE log
    classpath = f"target/*:{JUNIT_JAR_PATH}:."
    ret_run_main = utils.execute(f"java -cp {classpath} Main", dir=project_source_dir)
    write = False
    with open(f"{project_config_dir}/log", "w") as f:
        for line in ret_run_main.stderr.splitlines():
            "java.lang.NullPointerException" in line and (write := True)
            write and f.write(line + "\n")


def write_main(klass, method, outpath: Path):
    source = (
        f"public class Main {{\n"
        f"   public static void main(String[] args) throws Exception {{\n"
        f"       {klass} testClass = new {klass}();\n"
        f"       testClass.{method}();\n"
        f"  }}\n"
        f"}}"
    )

    with open(outpath, "w") as f:
        f.write(source)


def write_test(outpath):
    source = (
        f"import org.junit.Test;\n\n"
        f"public class TestMain {{\n"
        f"  @Test\n"
        f"  public void test() throws Exception {{\n"
        f"      Main.main(null);\n"
        f"  }}\n"
        f"}}"
    )

    with open(outpath, "w") as f:
        f.write(source)


def compile_classes(bug_id, project_source_dir, project_target_dir):
    classpath = f"target/*:{JUNIT_JAR_PATH}:."
    main_src = f"{project_source_dir}/Main.java"
    test_src = f"{project_source_dir}/TestMain.java"

    mainClass = compile_class(main_src, classpath, project_source_dir)
    testClass = compile_class(test_src, classpath, project_source_dir)

    if mainClass is None or testClass is None:
        raise Exception("Could not compile Main/TestMain.java")

    utils.copyfile(mainClass, f"{project_target_dir}/classes/", verbosity=1)
    utils.copyfile(testClass, f"{project_target_dir}/test-classes/", verbosity=1)

    return (mainClass, testClass)


def compile_class(src, classpath, dir):
    cmd = f"javac -cp {classpath} {src}"
    if utils.execute(cmd, dir, verbosity=1).return_code != 0:
        return None
    return f"{os.path.dirname(src)}/{os.path.basename(src).split('.')[0]}.class"


"""
Phase 3: RUN VFix
  1. Clean VFix things: bug-id/config/target, bug-id/gzoltar-data
  2. Excecute twice: java -jar VFix.jar [bug] [id] in VFix directory
"""


if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument("--bug_id", help="get repository info from commit url")
    args = parser.parse_args()

    if args.bug_id:
        target_branches = [f"{args.bug_id}-buggy"]
    else:
        target_branches = [
            os.path.basename(br)
            for br in glob.glob(".git/refs/remotes/origin/benchmarks/*-buggy")
        ]
    prepare(target_branches[0])
    prepare2(target_branches[0])

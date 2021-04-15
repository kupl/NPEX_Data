#!/usr/bin/python3.8

import argparse
from dataclasses import dataclass, asdict
from typing import List, Optional
import os, glob, shutil
from multiprocessing import Pool
from functools import wraps

from benchmarks import Bug
import utils
from config import *

VFIX_DIRECTORY = "/home/june/project/vfix"
VFIX_LIB_DIRECTORY = "/home/june/project/vfix/lib"
log = open('log.log', 'w')

@dataclass
class Flag:
    INIT: str = "INIT"
    NPE_FOUND: str = "NPE_FOUND"
    MAIN_COMPILED: str = "MAIN_COMPILED"
    NPE_TRIGGERABLE: str = "NPE_TRIGGERABLE"
    GZOLTAR_SUCCEEDS: str = "GZOLTAR_SUCCEEDS"


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
    submodule_path: Optional[str] = None

    @classmethod
    def load(cls, cache):
        return from_dict(cls, utils.read_json_from_file(cache))

    @classmethod
    def from_bug_id(cls, benchmarks_dir, bug_id, clean):
        branch = bug_id
        benchmark_dir = f"{benchmarks_dir}/{branch}"
        bug = Bug.from_json(f"{benchmark_dir}/bug.json")
        vfix_bug_id = bug_id.replace("-", "_") + "-1"
        root_dir = f"{VFIX_DIRECTORY}/dataset/{vfix_bug_id}"
        config_dir, source_dir, target_dir = (
            dirs := [f"{root_dir}/{dir}" for dir in ["config", "source", "target"]]
        )
        if os.path.exists((cache := f"{root_dir}/{cls.Cache}")) and not clean:
            print(f"{bug_id}: cache found")
            return cls.load(cache)
        try:
            shutil.rmtree(root_dir, ignore_errors=True)
            os.makedirs(root_dir)
            npe = utils.read_json_from_file(f"{benchmark_dir}/npe.json")
            # check existence just to make sure that if root dir has been removed in clean mode
            utils.copyfile(benchmark_dir, source_dir)
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

    def get_all_poms(self):
        return [Pom(pom) for pom in glob.glob(f'{self.source_dir}/**/pom.xml', recursive=True)]

    def get_dependency_classpath(self, absolute=False):
        classpath = ':'.join(f'{self.submodule_path}/target/{d}' for d in ['classes', 'test-classes', 'dependency/*'])
        classpath += f':{VFIX_LIB_DIRECTORY}/*'
        return f'".:{classpath}"'


    @step(flag=Flag.NPE_FOUND, failure_msg="could not find npe.json")
    def prepare(self):
        # Clean git things and cached data
        utils.execute(f"rm -rf .git", dir=self.source_dir, verbosity=1)

        # Resolve nullpointer for VFix configuration
        npe = utils.read_json_from_file(f"{self.benchmark_dir}/npe.json")
        if "nullpointer" in npe:
            self.nullpointer = npe["nullpointer"]
        else:
            return False

        # Resolve submodule
        test_file = self.bug.repository_info.test_files[0]
        if test_file.startswith('src/test/java'):
          self.submodule_path = f'{self.source_dir}'
        else: 
          self.submodule_path = f'{self.source_dir}/{test_file.split("/src/test/java")[0]}'

        # Copy dependencies
        if utils.execute('mvn dependency:copy-dependencies', dir=self.submodule_path, verbosity=1).return_code != 0:
          return False

        # Collect all class files into target/classes for VFix
        os.makedirs(self.target_dir)
        os.makedirs(f'{self.target_dir}/classes')
        for target_dir in glob.glob(f'{self.source_dir}/**/target'):
          utils.copyfile(f'{target_dir}/classes', f'{self.target_dir}/classes', inner=True)
          
        # Copy submodule source folder to the root
        src_dir_copy_cmd = f'cp -r {self.submodule_path}/src/main/java/* ./'
        return utils.execute(src_dir_copy_cmd, dir=self.source_dir, verbosity=1).return_code == 0


    @step(flag=Flag.MAIN_COMPILED, failure_msg="failed to compile Main.java")
    def compile(self):
        # Write Main/TestMain.java
        test_class_name = self.bug.test_info.testcases[0].classname
        test_method = self.bug.test_info.testcases[0].method
        with open(f'{self.source_dir}/Main.java', 'w') as f:
            code = (
                f"public class Main {{\n"
                f"   public static void main(String[] args) throws Throwable {{\n"
                f"       {test_class_name} testClass = new {test_class_name}();\n"
                f"       testClass.{test_method}();\n"
                f"  }}\n"
                f"}}"
            )
            f.write(code)

        with open(f'{self.source_dir}/TestMain.java', 'w') as f:
            code = (
                f"import org.junit.Test;\n\n"
                f"public class TestMain {{\n"
                f"  @Test\n"
                f"  public void test() throws Throwable {{\n"
                f"      Main.main(null);\n"
                f"  }}\n"
                f"}}"
            )
            f.write(code)
    
        # Compile Main/TestMain classes
        classpath = self.get_dependency_classpath()
        print(classpath)
        main_compile_cmd = f'javac -cp {classpath} Main.java'
        testmain_compile_cmd = f'javac -cp {classpath} TestMain.java'

        ret_main_compile = utils.execute(main_compile_cmd, dir=self.source_dir, verbosity=1).return_code
        ret_testmain_compile = utils.execute(testmain_compile_cmd, dir=self.source_dir, verbosity=1).return_code

        if (ret_main_compile != 0 or ret_testmain_compile != 0):
            return False

        # Copy Main/TestMain to target build directory
        main_copied = shutil.copy(f'{self.source_dir}/Main.class', f'{self.submodule_path}/target/classes/')
        print(f'Main.class has been copied to target dir: {main_copied}')
        test_main_copied = shutil.copy(f'{self.source_dir}/TestMain.class', f'{self.submodule_path}/target/test-classes/')
        print(f'TestMain.class has been copied to target dir: {test_main_copied}')

        # Copy test-classes to classes
        utils.copyfile(f'{self.submodule_path}/target/test-classes', f'{self.submodule_path}/target/classes/', inner=True, verbosity=2)
        
        # Copy target build directory to root target directory
        utils.copyfile(f'{self.submodule_path}/target', self.target_dir, inner=True, verbosity=1)
        return os.path.exists(f'{self.target_dir}/classes/Main.class')

    @step(flag=Flag.NPE_TRIGGERABLE, failure_msg="failed to trigger NPE (maybe Main did not run properly?)")
    def run_main(self):
        os.makedirs(self.config_dir, exist_ok=True)

        # Run Main.class and write vfix configs
        main_run_cmd = f'java -cp {self.get_dependency_classpath()} Main'
        ret = utils.execute(main_run_cmd, dir=self.source_dir, verbosity=1)

        # Write NPE exception log
        with open(log := f'{self.config_dir}/log', 'w') as f:
            write = False
            for line in ret.stderr.splitlines():
                "java.lang.NullPointerException" in line and (write := True)
                write and f.write(line + "\n")
            if write != True:
                return False

        # Write config
        jar_names = [os.path.basename(jp) for jp in glob.glob(f'{self.target_dir}/dependency/*.jar')]
        deps = '/../' + ':/../'.join(['classes', 'test-classes'] + [f'dependency/{jar}' for jar in jar_names])
        with open(f'{self.config_dir}/config', 'w') as f:
            f.write(
                f'main=Main\n'
                f'test=TestMain\n'
                f'nullpointer={self.nullpointer}\n'
                f'deps={deps}\n')


        return os.path.exists(f'{self.config_dir}/log')

    @step(flag=Flag.GZOLTAR_SUCCEEDS, failure_msg="failed to run gzoltar")
    def run_gzoltar(self):
        vfix_bug_id = os.path.basename(self.root_dir).split("-")[0]
        cmd = f"java -jar VFix.jar {vfix_bug_id} 1"
        return utils.execute(cmd, dir=VFIX_DIRECTORY, verbosity=1).return_code == 0

def run(benchmarks_dir, bug_id, clean):
    proj = Proj.from_bug_id(benchmarks_dir, bug_id, clean)
    if proj == None:
      return
    print(proj.bug_id)
    try:
        proj.prepare()
        proj.compile()
        proj.run_main()
        proj.run_gzoltar()
        log.write(f'{bug_id}, {proj.flags[-1]}, Succeed\n')
    except Exception as e:
        log.write(f'{bug_id}, {proj.flags[-1]}, Exception occured, {e}\n')

    log.flush()
 
if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument('benchmarks_dir', help='benchmarks directory')
    parser.add_argument("--bug-id", help="get repository info from commit url")
    parser.add_argument("--clean", action="store_true", default=False, help="remove vfix-cache and re-run all steps")
    args = parser.parse_args()

    if args.bug_id:
        run(args.benchmarks_dir, args.bug_id, args.clean)

    else:
        p = Pool(20)
        parameters = [(args.benchmarks_dir, os.path.basename(b), args.clean) for b in glob.glob(f'{args.benchmarks_dir}/*')]
        p.starmap(run, parameters)




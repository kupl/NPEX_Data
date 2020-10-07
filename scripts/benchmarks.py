from typing import List, Set, Dict, Tuple, Optional
from dataclasses import asdict, dataclass, field, fields, is_dataclass
import xml.etree.ElementTree as ET
import utils
import os, sys, glob
from config import *
from pprint import pprint
from dacite import from_dict as _from_dict

ROOT_DIR = os.getcwd()
SEED_DIR = os.path.abspath("seed")

def from_dict(klass, d):
    if d == None:
        return None
    elif d == []:
        return []
    else:
        return _from_dict(data_class=klass, data=d)

def execute(cmd, dir):  #should not fail
    ret = utils.execute(cmd, dir=dir)
    if ret.return_code != 0:
        print(f"{ERROR}: failed to execute {cmd} at {dir}")
        exit(1)


@dataclass
class Repository:
    repo: str
    commit_url: str
    parent_url: str
    changed_files: List[str]
    patch_files: List[str]
    test_files: List[str]

@dataclass
class Build:
    compiled: bool
    build_command: Optional[str] = None
    java_version:  Optional[int] = None
    error_message: Optional[str] = None
    time:          Optional[float] = None


@dataclass(frozen=True)
class TestCase:
    classname: str
    method: str
    exn_type: str
    stack_trace: str

    @staticmethod
    def from_test_results(dir):
        test_result_files = glob.glob(f"{dir}/**/surefire-reports/TEST*.xml",
                                      recursive=True)
        testcases = []
        for test_result_file in test_result_files:
            root_tree = ET.parse(test_result_file).getroot()
            testcase_trees = [
                tc for tc in root_tree.findall("testcase") if
                tc.find("error") is not None or tc.find("failure") is not None
            ]
            for testcase_tree in testcase_trees:
                errors = root_tree.findall(
                    'testcase/error') + root_tree.findall('testcase/failure')
                for error in errors:
                    testcase = TestCase(
                        classname=testcase_tree.attrib["classname"],
                        method=testcase_tree.attrib["name"],
                        exn_type=error.attrib["type"],
                        stack_trace=error.text)
                    testcases.append(testcase)
        return testcases


@dataclass
class Test:
    test_command: str
    fail_buggy: bool
    pass_fixed: bool
    testcases: List[TestCase]


@dataclass
class Patch:
    patch_id: str
    patch_dir: str
    original_filepath: str
    compiled: Optional[bool] = None
    pass_testcase: Optional[bool] = None
    is_correct: Optional[bool] = None


@dataclass (unsafe_hash=True)
class Npe:
    filepath: str
    line: int
    deref_field: str
    npe_class: str
    npe_method: str
    sink_field: Optional[str] = None #to parse automatically generated npe
    jvmti_identify_succeed: Optional[bool] = None #to parse automatically generated npe
    is_original: Optional[bool] = field(default=None, hash=None, compare=False)

    @classmethod
    def from_json(cls, jsonfile):
        return from_dict(cls, utils.read_json_from_file(jsonfile))

    def set_original(self):
        self.is_original = True

    @staticmethod
    def list_from_dir(dir):
        ret = [] 
        npe_jsons = glob.glob(f"{dir}/npe*.json")
        for npe_json in npe_jsons:
            npe = Npe.from_json(npe_json)
            if os.path.basename(npe_json) == "npe.json":
                npe.set_original()
            ret.append(npe)
        return ret

@dataclass
class Bug:
    bug_id: str
    repository_info: Optional[Repository] = None
    build_info: Optional[Build] = None
    test_info: Optional[Test] = None
    npe_info: List[Npe] = field(default_factory=list)
    patch_results: List[Patch] = field(default_factory=list)

    @classmethod
    def from_json(cls, jsonfile):
        bug = from_dict(cls, utils.read_json_from_file(jsonfile))
        if bug.npe_info is None:
            bug.npe_info = []
        
        if bug.patch_results is None:
            bug.patch_results = []
       
        return bug 

    def fixed_id(self):
        return self.bug_id[:-6]

    def build(self, dir):
        for java_version in [8, 7, 11]:
            compile_cmd = utils.get_compile_command(dir,
                                                    java_version=java_version)
            ret_compile = utils.execute(
                compile_cmd,
                dir=dir,
                env=utils.set_java_version(java_version=java_version))
            if ret_compile.return_code == 0:
                self.build_info = Build(compiled=True,
                                        build_command=compile_cmd,
                                        java_version=java_version,
                                        time=ret_compile.time)
                print(
                    f"{SUCCESS}: successfully compiled {self.bug_id} by java {java_version}"
                )
                break
            else:
                continue

        if ret_compile.return_code != 0:
            print(f"{FAIL}: failed to compile {self.bug_id}")
            self.build_info = Build(compiled=False,
                                    error_message=utils.parse_error(
                                        ret_compile.stdout))

    def execute_compile(self, dir):
        java_version = self.build_info.java_version
        compile_cmd = utils.get_compile_command(dir, java_version=java_version)
        return utils.execute(
            compile_cmd,
            dir=dir,
            env=utils.set_java_version(java_version=java_version))

    def execute_test_all(self, dir):
        java_version = self.build_info.java_version
        test_cmd = utils.get_test_command(dir, java_version=java_version)
        return utils.execute(
            test_cmd,
            dir=dir,
            env=utils.set_java_version(java_version=java_version))
    
    def execute_test(self, dir):
        java_version = self.build_info.java_version
        test_cmd = f'mvn clean test -DfailIfNoTests=false {MVN_OPTION}' 
        for testcase in self.test_info.testcases:
            test_cmd = test_cmd + f" -Dtest={testcase.classname}#{testcase.method}" 
        return utils.execute(
            test_cmd,
            dir=dir,
            env=utils.set_java_version(java_version=java_version))
    
    def test(self, dir):
        if self.build_info.compiled is False:
            print(f"{WARNING}: {self.bug_id} is not compiled")
            return

        test_cmd = utils.get_test_command(dir, java_version=self.build_info.java_version)
        
        execute(f"git checkout benchmarks/{self.fixed_id()}", dir)
        ret_fixed_test = self.execute_test_all(dir)
        testcases_fixed = TestCase.from_test_results(dir)

        execute(f"git checkout benchmarks/{self.bug_id}", dir)
        ret_buggy_test = self.execute_test_all(dir)
        testcases_buggy = TestCase.from_test_results(dir)

        testcases = list(set(testcases_buggy) - set(testcases_fixed))

        if testcases != []:
            print(f"{SUCCESS}: found validating testcases for {self.bug_id}")
        else:
            print(
                f"{FAIL}: failed to find meaningful testcases for {self.bug_id}"
            )

        self.test_info = Test(test_command=test_cmd,
                              fail_buggy=ret_buggy_test.return_code == 1,
                              pass_fixed=ret_fixed_test.return_code == 0,
                              testcases=testcases)

    def to_json(self, dir):
        utils.save_dict_to_jsonfile(f"{dir}/bug.json", asdict(self))


    def checkout(self, dir):
        execute(f"git checkout -f benchmarks/{self.bug_id}", dir)

    def patch(self, dir):
        self.patch_results = []
        self.checkout(dir)
        
        if os.path.isdir(f"{dir}/patches"):
            execute(f"rm -rf {dir}/patches", dir)
        for npe in self.npe_info:
            utils.save_dict_to_jsonfile(f"{dir}/npe.json", asdict(npe))
            env = utils.set_java_version(self.build_info.java_version)
            utils.execute( f"java -cp {SYNTHESIZER} npex.Main -patch {dir} {dir}/npe.json")
            patch_dirs = glob.glob(f"{dir}/patches/*")
            for patch_dir in patch_dirs:
                patch_id = os.path.basename(patch_dir)
                if os.path.isfile(f"{patch_dir}/patch.json") is False:
                    execute(f"rm -rf {patch_dir}", dir)
                    print(f"{ERROR} {self.bug_id}-{patch_id} NOT IMPLEMENTED")
                    continue
                original_filepath = utils.read_json_from_file( f"{patch_dir}/patch.json")["original_filepath"]
                self.patch_results.append(
                    Patch(patch_id=patch_id,
                          patch_dir=patch_dir,
                          original_filepath=original_filepath))

            if self.patch_results != []:
                print(f"{PROGRESS}: {len(self.patch_results)} patches are generated for {self.bug_id}")
            else:
                print(f"{SERIOUS}: no patches are generated for {self.bug_id}")                    

    def validate_patch(self, dir):
        for patch in self.patch_results:
            if patch.compiled is False or patch.pass_testcase is not None:
                continue
            self.checkout(dir)
            execute(f"cp \"{patch.patch_dir}/patch.java\" {dir}/{patch.original_filepath}", dir)
            patch.compiled = self.execute_compile(dir).return_code == 0
            if patch.compiled and self.test_info.testcases != []:
                patch.pass_testcase = self.execute_test(dir).return_code == 0
        
            # if patch.pass_testcase is True:
            #     print(f"{SUCCESS}: {self.bug_id}-{patch.patch_id} pass testcase")
            # elif patch.pass_testcase is False:
            #     print(f"{FAIL}: {self.bug_id}-{patch.patch_id} failed to pass testcase")
            # elif patch.compiled:
            #     print(f"{WARNING}: {self.bug_id}-{patch.patch_id} has no testcases")
            # else:
            #     print(f"{FAIL}: {self.bug_id}-{patch.patch_id} failed to be compiled")

    @classmethod
    def from_branch(cls, target_branch):
        bug_dir = f"{ROOT_DIR}/{target_branch}"
        return cls.from_json(f"{bug_dir}/bug.json")

    @staticmethod
    def configure(target_branch):
        print(f"{PROGRESS}: configuring {target_branch}...")
        bug_dir = f"{ROOT_DIR}/{target_branch}"

        if os.path.isdir(bug_dir) is False:
            utils.execute(f"cp -r {SEED_DIR} {bug_dir}", dir=ROOT_DIR, verbosity=1)
            execute(f"git checkout benchmarks/{target_branch}", dir=bug_dir)

        if os.path.isfile(f"{bug_dir}/bug.json"):
            bug = Bug.from_json(f"{bug_dir}/bug.json")
        else:
            bug = Bug(target_branch)

        bug.checkout(bug_dir)

        if bug.build_info is None:
            bug.build(bug_dir)

        if bug.test_info is None or bug.test_info.testcases == []:
            bug.test(bug_dir)

        npe_list = Npe.list_from_dir(bug_dir)
        if set(npe_list) != set(bug.npe_info): #npe.json changed
            bug.npe_info = npe_list
            bug.patch_results = [] 
            
        bug.patch_results = [] # TODO: remove it
             
        if bug.patch_results == []:
            bug.patch(bug_dir)
        
        bug.validate_patch(bug_dir)
        if any([p.pass_testcase for p in bug.patch_results]):
            print (f"{SUCCESS}: {bug.bug_id} has a plausible patch")
        else:
            print (f"{FAIL}: {bug.bug_id} has no plausible patches")
        
        bug.to_json(bug_dir)
        print(f"{PROGRESS}: finished {target_branch}")
        


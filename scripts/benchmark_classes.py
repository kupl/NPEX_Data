from typing import List, Set, Dict, Tuple, Optional
from dataclasses import asdict, dataclass, field, fields, is_dataclass
import xml.etree.ElementTree as ET
import utils
import os, sys, glob
from config import *
from pprint import pprint
from dacite import from_dict as _from_dict
from copy import deepcopy

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
class TraceEntry:
    tag: str
    filepath: str
    line_number: int
    description: str

    @classmethod
    def parse_from_line(cls, ln, dir):
        pattern = r'\[(?P<tag>.*)\] Filepath: (?P<filepath>.*), Package: (?P<pkg>.*), Line: (?P<lineno>\d+), Element: (?P<desc>.*)'
        if (m := re.search(pattern, ln)):
            tag = m.group('tag')
            filepath = m.group('filepath')
            line_number = int(m.group ('lineno'))
            description = m.group('desc')
            return cls(tag, filepath, line_number, description)
        else:
            return None

    @classmethod
    def generate_trace_json(cls, trace_lines, dir):
        trace = [cls.parse_from_line(ln, dir) for ln in trace_lines]
        trace = [asdict(te) for te in trace if te]
        if trace == []:
            print (f"{FAIL}: no trace.json is generated at {dir}")
            return False
        print (f"{SUCCESS}: trace.json is generated at {dir}")
        utils.save_dict_to_jsonfile(f"{dir}/trace.json", trace)
        return True



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


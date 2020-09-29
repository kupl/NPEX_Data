import os, sys, glob
import utils
import argparse
import pprint
import re
from typing import List, Set, Dict, Tuple, Optional

import xml.etree.ElementTree as ET

ROOT_DIR = os.getcwd()

parser = argparse.ArgumentParser()
parser.add_argument("--json", help="json file for benchmarks info")
parser.add_argument("--directory", help="benchmarks directory")

args = parser.parse_args()

benchmarks = utils.read_json_from_file(args.json)
directory = f"{ROOT_DIR}/{args.directory}"

for bug_data in benchmarks:
    bug_id = bug_data["bug_id"]
    fixed_dir = f"{directory}/{bug_id}"
    buggy_dir = f"{directory}/{bug_id}-buggy"

    if bug_data["build_info"]["compiled"] is False:
        continue
    
    java_version = bug_data["build_info"]["java_version"]
    test_files = bug_data["repository_info"]["test_files"] if "test_files" in bug_data["repository_info"] else []

    if os.path.isdir(f"{buggy_dir}/ant"):
        build_dir = f"{buggy_dir}/ant"
        build_fixed_dir = f"{fixed_dir}/ant"
    else:
        build_dir = buggy_dir
        build_fixed_dir = fixed_dir
        
    if test_files:
        test_classes = [
            test_file.split('/')[-1].split('.')[0] for test_file in test_files
        ]
        test_cmd = utils.get_test_command(build_dir,
                                          test_classes=test_classes,
                                          java_version=java_version)
    else:
        test_cmd = utils.get_test_command(build_dir,
                                          java_version=java_version)

    ret_fixed_test = utils.execute(test_cmd, dir=build_fixed_dir, verbosity=1, env=utils.set_java_version(java_version=java_version))
    ret_buggy_test = utils.execute(test_cmd, dir=build_dir, verbosity=1, env=utils.set_java_version(java_version=java_version))

    testcase_data = []
    test_result_files = glob.glob(
        f"{buggy_dir}/**/surefire-reports/TEST*.xml", recursive=True)
    pprint.pprint(test_result_files)
    for test_result_file in test_result_files:
        root = ET.parse(test_result_file).getroot()
        tests = root.findall("testcase")
        print(f"# of all testcases: {len(tests)}")
        testcases = [
            tc for tc in root.findall("testcase")
            if tc.find("error") is not None or tc.find("failure") is not None
        ]
        print(f"# of testcases: {len(testcases)}")
        for testcase in testcases:
            errors = root.findall('testcase/error') + root.findall(
                'testcase/failure')
            print(f"# of errors : {len(errors)}")
            for error in errors:
                test_info = {
                    "test_info": {
                        "class": testcase.attrib["classname"],
                        "method": testcase.attrib["name"]
                    },
                    "failure_info": {
                        "type": error.attrib["type"],
                        "stack_trace": error.text
                    }
                }
                testcase_data.append(test_info)

    bug_data["test_info"] = {
        "test_command": test_cmd,
        "summary": {
            "fail_buggy": ret_buggy_test.return_code == 1,
            "pass_fixed": ret_fixed_test.return_code == 0
        },
        "testcases": testcase_data
    }

    utils.save_dict_to_jsonfile(f"{ROOT_DIR}/{args.json}", benchmarks)

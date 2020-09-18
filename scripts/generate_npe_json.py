import os, sys, glob
import utils
import argparse
import pprint
import re
import xml.etree.ElementTree as ET
from typing import List, Set, Dict, Tuple, Optional
from config import *

ROOT_DIR = os.getcwd()

parser = argparse.ArgumentParser()
parser.add_argument("--json", help="json file for benchmarks info")
parser.add_argument("--directory", help="benchmarks directory")

args = parser.parse_args()

benchmarks = utils.read_json_from_file(args.json)
directory = f"{ROOT_DIR}/{args.directory}"

for bug_data in benchmarks:
    bug_id = bug_data["bug_id"]
    buggy_dir = f"{directory}/{bug_id}-buggy"

    if bug_data["build_info"]["compiled"] is False:
        continue

    if os.path.isfile(f"{buggy_dir}/npe.json"):
        print(f" - {bug_id} has npe.json")
        continue

    if os.path.isfile(f"{buggy_dir}/pom.xml"
                      ) is False and bug_data["test_info"]["testcases"] == []:
        continue

    java_version = bug_data["build_info"]["java_version"]
    test_classes = []
    for testcase in bug_data["test_info"]["testcases"]:
        if testcase["failure_info"][
                "type"] == "java.lang.NullPointerException":
            test_classes.append(testcase["test_info"]["class"])

    test_cmd = utils.get_test_command(buggy_dir,
                                      test_classes=list(set(test_classes)),
                                      java_version=java_version)

    env = utils.set_java_version(java_version)
    env = utils.set_detailed_npe(java_version, env=env)
    ret_test = utils.execute(test_cmd, dir=buggy_dir, env=env)

    if os.path.isfile(f"{buggy_dir}/npe.json"):
        print(f"{SUCCESS}: DetailedNPE generated npe.json for {bug_id}")
    else:
        print(f"{FAIL}: failed to generated npe.json for {bug_id}")

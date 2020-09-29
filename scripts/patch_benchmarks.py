import os, sys, glob
import utils
import argparse
import pprint
import re
import time
from typing import List, Set, Dict, Tuple, Optional
from config import *

import xml.etree.ElementTree as ET

ROOT_DIR = os.getcwd()


def get_test_command(bug_data):
    java_version = bug_data["build_info"]["java_version"]
    test_classes = []
    for testcase in bug_data["test_info"]["testcases"]:
        if MSG_NPE in testcase["failure_info"]["type"]:
            test_classes.append(testcase["test_info"]["class"])

    test_cmd = utils.get_test_command(buggy_dir,
                                      test_classes=list(set(test_classes)),
                                      java_version=java_version)
    env = utils.set_java_version(java_version)
    env["_JAVA_OPTIONS"] = ""
    return test_cmd, env


def get_spoon_cmd(buggy_dir):
    return f"java -cp {SYNTHESIZER} npex.Main -patch {buggy_dir}/ {buggy_dir}/npe.json"


def test_and_validate_patch(test_cmd, env, buggy_dir, patch_dir):
    patch_id = os.path.basename(patch_dir)
    patch_java = f"{patch_dir}/patch.java"
    patch_json = utils.read_json_from_file(f"{patch_dir}/patch.json")
    original_filepath = patch_json["original_filepath"]

    utils.execute(f"git checkout -- {original_filepath}", dir=buggy_dir)
    ret_cp = utils.execute(f"cp \"{patch_java}\" {original_filepath}",
                           dir=buggy_dir)
    ret_test = utils.execute(test_cmd, dir=buggy_dir, env=env, timeout=300)
    utils.execute(f"git checkout -- {original_filepath}", dir=buggy_dir)
    if ret_cp.return_code != 0:
        print(f"[ERROR] {ret_cp} command is not applicable!")

    return ret_test


def execute_spoon(env, buggy_dir):
    spoon_cmd = get_spoon_cmd(buggy_dir)
    utils.execute(f"rm -rf {buggy_dir}/patches", dir=buggy_dir)
    print(f" - generating patches for {bug_id} ...")
    dirs = [dir for dir in glob.glob(f"{buggy_dir}/*") if os.path.isdir(dir)]
    for dir in dirs:
        if os.path.basename(dir) == "target" or os.path.basename(dir) == "spooned":
          continue
        if (utils.execute(f"git checkout -- {dir}", dir=buggy_dir).return_code != 0):
          print (f"[ERROR] git checkout for {dir} is failed at {buggy_dir}")

    while True:
        if os.path.isfile(SYNTHESIZER):
            break
        print(" - wait compiling synthsizer")
        time.sleep(1)
    utils.execute(spoon_cmd, dir=buggy_dir, env=env)


parser = argparse.ArgumentParser()
parser.add_argument("--json", help="json file for benchmarks info")
parser.add_argument("--dir", help="benchmarks directory")
parser.add_argument("--bug_id", help="bug-id")
args = parser.parse_args()

benchmarks = utils.read_json_from_file(args.json)
directory = f"{ROOT_DIR}/{args.dir}"

for bug_data in benchmarks:
    bug_id = bug_data["bug_id"]
    buggy_dir = f"{directory}/{bug_id}-buggy"

    if args.bug_id and bug_id != args.bug_id:
        continue

    if bug_data["build_info"]["compiled"] is False or os.path.isfile(
            f"{buggy_dir}/npe.json") is False:
        continue

    test_cmd, env = get_test_command(bug_data)
    execute_spoon(env, buggy_dir)

    patch_dirs = glob.glob(f"{buggy_dir}/patches/*")
    if patch_dirs == []:
        print(f"[WARNING] no patches are generated for {bug_id} ...")

    patch_results = []

    for patch_dir in patch_dirs:
        patch_id = os.path.basename(patch_dir)
        if os.path.isfile(f"{patch_dir}/patch.json") is False:
            print(f"[ERROR] {bug_id}-{patch_id} NOT IMPLEMENTED")
            continue

        # print(f" - testing {patch_id} ...")
        ret_test = test_and_validate_patch(test_cmd, env, buggy_dir, patch_dir)

        if ret_test.return_code == 0:
            error_type = None
            print(f"   - pass! {bug_id}_{patch_id}")
        else:
            error_type = utils.parse_error(ret_test.stdout)
            print(f"   - {error_type}! {bug_id}_{patch_id}")

        patch_result = {
            "patch_id": patch_id,
            "pass_testcase": ret_test.return_code == 0,
            "error_type": error_type
        }
        patch_results.append(patch_result)

    bug_data["patch_results"] = patch_results

    utils.save_dict_to_jsonfile(f"{ROOT_DIR}/{args.json}", benchmarks)

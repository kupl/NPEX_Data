import os, sys, glob
import time
import argparse
import pprint
import shutil
import copy
from colorama import Fore, Style  #type:ignore

from typing import List, Set, Dict, Tuple, Optional
from config import *
import xml.etree.ElementTree as ET

# Multi-processing
from itertools import repeat
from multiprocessing import Process
from multiprocessing import Manager
from multiprocessing import Pool

#Helper functions
ROOT_DIR = os.getcwd()
sys.path.append(ROOT_DIR)
import utils

JAVA_VERSION = 8
METADATA = f"{ROOT_DIR}/metadata.json"
BUGDATA = f"{ROOT_DIR}/bugdata.json"
BENCH_DIR = f"{ROOT_DIR}/benchmarks"
LEARNING_DIR = f"{ROOT_DIR}/learning_data"
MARSHAL = ".rawdata_marshalled"


def is_true(field, data):
    return field in data and data[field] is True


def print_stat(assert_only=False):
    repo_data_path_list = glob.glob(f"{LEARNING_DIR}/*/data.json")

    number_of_all_bugs = 0
    number_of_bugs = 0
    number_of_fixed_bugs = 0
    number_of_patches = 0
    number_of_plausibles = 0
    number_of_patches_compile = 0
    number_of_patches_assert = 0
    number_of_patches_npe = 0
    number_of_other_fail = 0

    for repo_data_path in repo_data_path_list:
        repo_data = utils.read_json_from_file(repo_data_path)
        repo = repo_data["repo"]

        if assert_only is True:
            bugs = [
                b for b in repo_data["bugs"] if any([
                    "error_type" in p and p["error_type"] == MSG_ASSERT_FAIL
                    for p in b["patches"]
                ])
            ]
        else:
            bugs = repo_data["bugs"]

        for bug_data in bugs:
            if is_true("has_testcase", bug_data) is False:
                continue
            number_of_all_bugs = number_of_all_bugs + 1
            patches = bug_data["patches"]
            patches_without_devel = [
                p for p in patches if p["patch_id"] != "devel_patch"
            ]

            if all(
                ["pass_testcase" not in patch_data for patch_data in patches]):
                continue

            number_of_bugs = number_of_bugs + 1
            if any([
                    is_true("pass_testcase", patch_data)
                    for patch_data in patches_without_devel
            ]):
                number_of_fixed_bugs = number_of_fixed_bugs + 1

            for patch_data in patches_without_devel:
                number_of_patches = number_of_patches + 1
                if "error_type" not in patch_data:
                    print(" - %s-%s-%s has no error type" %
                          (repo, bug_data["bug_id"], patch_data["patch_id"]))
                    continue
                    print(f" - {pprint.pprint(patch_data)}")
                error_type = patch_data["error_type"]
                if patch_data["pass_testcase"]:
                    number_of_plausibles = number_of_plausibles + 1
                elif error_type == MSG_ASSERT_FAIL:
                    number_of_patches_assert = number_of_patches_assert + 1
                elif error_type == MSG_COMPILE_FAIL:
                    number_of_patches_compile = number_of_patches_compile + 1
                elif error_type == MSG_NPE:
                    number_of_patches_npe = number_of_patches_npe + 1
                elif error_type == MSG_TEST_FAIL:
                    number_of_other_fail = number_of_other_fail + 1

    print(f"number of all bugs: {number_of_all_bugs}")
    print(f"number of bugs: {number_of_bugs}")
    print(f"number of fixed bugs: {number_of_fixed_bugs}")
    print(f"number of patches: {number_of_patches}")
    print(f"number of patches (pass testcases): {number_of_plausibles}")
    print(
        f"number of patches (compilation failures): {number_of_patches_compile}"
    )
    print(
        f"number of patches (assertion failures): {number_of_patches_assert}")
    print(
        f"number of patches (null-pointer-exceptions): {number_of_patches_npe}"
    )
    print(f"number of patches (other test failures): {number_of_other_fail}")


print(
    f"===={Fore.LIGHTYELLOW_EX}Statistics with Patch-Validated Bugs{Style.RESET_ALL}===="
)
print_stat(assert_only=False)
print(
    f"===={Fore.LIGHTYELLOW_EX}Statistics with Assertion-Failed Bugs{Style.RESET_ALL}===="
)
print_stat(assert_only=True)

import os, sys, glob
import time
import argparse
import pprint
import shutil
import copy

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

MAXLOC = 100000

incremental = True


def is_true(field, data):
    return field in data and data[field] is True


def is_done(data: Dict, field: str):
    if incremental and field in data and data[field] is True:
        return data
    return False


def check_error_in_test(repo_dir, bug_id):
    reports = utils.find_file(f"{repo_dir}/target/surefire-reports/TEST-*.xml")
    if reports is None:
        print(f" - no TEST.xml found at {repo_dir}")
        return False

    for report in reports:
        root = ET.parse(report).getroot()
        failures = root.findall('testcase/failure')
        for failure in failures:
            if f"({bug_id}.java" in failure:
                return True
    return False


def setup_benchmark(project_dir):
    utils.execute("git clean -df", project_dir)
    utils.execute("git checkout -f", project_dir)


def capture(repo, metadata):
    repo_dir = f"{BENCH_DIR}/{repo}"
    data_dir = f"{LEARNING_DIR}/{repo}"

    repodata = metadata[repo]

    print(f" - compiling {repo}...")
    compile_cmd = utils.get_compile_command(repo_dir)
    ret_compile = utils.execute(
        f"infer capture --java-version {JAVA_VERSION} -- {compile_cmd}",
        repo_dir)

    if ret_compile.return_code is 0:
        repodata["infer-compiled"] = True
        shutil.move(f"{repo_dir}/infer-out", f"{data_dir}/infer-out")
    else:
        repodata["infer-compiled"] = False

    metadata[repo] = repodata
    utils.save_dict_to_jsonfile(METADATA, metadata.copy())


def generate_data(repo: str, metadata):
    repodata = metadata[repo]

    repo_dir = f"{BENCH_DIR}/{repo}"
    data_dir = f"{LEARNING_DIR}/{repo}"

    if not repodata["pass_testcase"] or repodata["LoC"] > MAXLOC:
        print(f" - skip {repo}")
        return

    #if os.path.isfile(f"{data_dir}/data.json"):
    #    print(f" - already done {repo}")
    #    return

    utils.execute(f"git checkout -f", dir=repo_dir)

    print(f" - generating bug-data for {repo}...")
    spoon_cmd = f"java -cp {SYNTHESIZER} npex.Main -extract {repo_dir} {LEARNING_DIR}"
    utils.execute(spoon_cmd, dir=ROOT_DIR, timeout=300)

    bug_dirs = [
        dir for dir in glob.glob(f"{data_dir}/bugs/*") if os.path.isdir(dir)
    ]
    print(f"   - {len(bug_dirs)} bugs generated for {repo}...")

    repo_data = {"repo": repo, "number_of_bugs": len(bug_dirs), "bugs": []}

    for bug_dir in bug_dirs:
        bug_id = os.path.basename(bug_dir)
        patch_dirs = [
            dir for dir in glob.glob(f"{bug_dir}/patches/*")
            if os.path.isfile(f"{dir}/patch.json")
        ]

        patches = []
        for patch_dir in patch_dirs:
            patch_id = os.path.basename(patch_dir)
            patch_data = {
                "patch_id": patch_id,
            }
            patches.append(patch_data)

        if os.path.isfile(
                f"{bug_dir}/patches/devel_patch/patch.json") is False:
            print(
                f"{WARNING}: {repo}/{bug_id} has buggy.java but no patch.json")
            continue

        filepath = utils.read_json_from_file(
            f"{bug_dir}/patches/devel_patch/patch.json")["original_filepath"]

        bug_data = {
            "bug_id": bug_id,
            "repo": repo,
            "filepath": filepath,
            "patches": patches
        }
        repo_data["bugs"].append(bug_data)

    utils.save_dict_to_jsonfile(f"{data_dir}/data.json", repo_data)


def apply_and_test(original_filepath,
                   patch_filepath,
                   repo_dir,
                   test_classes=[]):
    utils.execute(f"git checkout -f", dir=repo_dir)
    utils.execute(f"cp {patch_filepath} {original_filepath}", dir=repo_dir)
    test_cmd = utils.get_test_command(repo_dir, test_classes=test_classes)
    ret_test = utils.execute(test_cmd, dir=repo_dir, timeout=300)
    utils.execute(f"git checkout -f", dir=repo_dir)
    return ret_test


def find_test(repo):
    repo_dir = f"{BENCH_DIR}/{repo}"
    data_dir = f"{LEARNING_DIR}/{repo}"
    if os.path.isfile(f"{data_dir}/data.json") is False:
        return

    repo_data = utils.read_json_from_file(f"{data_dir}/data.json")

    if repo_data["bugs"] == []:
        print(f" - {repo} has no bug data")

    for bug_data in repo_data["bugs"]:
        bug_id = bug_data["bug_id"]
        bug_dir = f"{data_dir}/bugs/{bug_id}"

        #TODO: remove it
        if "has_testcase" in bug_data:
            print(f" - {repo}/{bug_id} already done")

        #if is_true("has_testcase", bug_data):
        #    print (f" - {repo}/{bug_id} has testcase")
        #    continue

        #print(f" - test {repo}/{bug_id}")

        original_filepath = bug_data["filepath"]
        buggy_filepath = f"{bug_dir}/buggy.java"

        ret_test = apply_and_test(original_filepath, buggy_filepath, repo_dir)

        bug_data["has_testcase"] = MSG_NPE in ret_test.stdout
        print(f" - found NPE testcase! for {repo}-{bug_id}")

        bug_data["time_to_test"] = ret_test.time
        bug_data["error_type"] = utils.parse_error(ret_test.stdout)
        if bug_data["error_type"] == MSG_COMPILE_FAIL:
            print(f"failed to compile for {repo}/{bug_id}")

        testcase_data = []
        test_result_files = glob.glob(
            f"{repo_dir}/**/surefire-reports/TEST*.xml", recursive=True)
        #pprint.pprint(test_result_files)
        for test_result_file in test_result_files:
            try:
                root = ET.parse(test_result_file).getroot()
                tests = root.findall("testcase")
                #print(f"# of all testcases: {len(tests)}")
                testcases = [
                    tc for tc in root.findall("testcase")
                    if tc.find("error") is not None
                    or tc.find("failure") is not None
                ]
                #print(f"# of failure testcases for {bug_id}: {len(testcases)}")
                for testcase in testcases:
                    errors = root.findall('testcase/error') + root.findall(
                        'testcase/failure')
                    #print(f"# of errors : {len(errors)}")
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
            except:
                continue
        bug_data["testcases"] = testcase_data

    print(f" - complete {repo}")
    utils.save_dict_to_jsonfile(f"{data_dir}/data.json", repo_data)


def test_patch(repo):
    repo_dir = f"{BENCH_DIR}/{repo}"
    data_dir = f"{LEARNING_DIR}/{repo}"
    if os.path.isfile(f"{data_dir}/data.json") is False:
        return

    repo_data = utils.read_json_from_file(f"{data_dir}/data.json")

    for bug_data in repo_data["bugs"]:
        bug_id = bug_data["bug_id"]
        if is_true("has_testcase", bug_data) is False:
            continue

        test_classes = []
        for testcase in bug_data["testcases"]:
            if MSG_NPE in testcase["failure_info"]["type"]:
                test_classes.append(testcase["test_info"]["class"])

        test_classes = list(set(test_classes))

        for patch_data in bug_data["patches"]:
            patch_id = patch_data["patch_id"]
            patch_dir = f"{data_dir}/bugs/{bug_id}/patches/{patch_id}"

            # TODO: remove it
            if "pass_testcase" in patch_data:
                continue

            if patch_id == "devel_patch":
                patch_data["pass_testcase"] = True
                continue

            if "pass_testcase" in patch_data:  # TODO: remove it later
                continue

            if os.path.isfile(f"{patch_dir}/patch.json") is False:
                print(
                    f"{WARNING}: no patch json for {patch_id}-{bug_id}-{repo}")

            original_filepath = utils.read_json_from_file(
                f"{patch_dir}/patch.json")["original_filepath"]
            patch_filepath = f"{patch_dir}/patch.java"

            try:
                ret_test = apply_and_test(original_filepath,
                                          patch_filepath,
                                          repo_dir,
                                          test_classes=test_classes)

                patch_data["pass_testcase"] = ret_test.return_code == 0
                patch_data["error_type"] = utils.parse_error(ret_test.stdout)
                if ret_test.return_code == 0:
                    print(f"{SUCCESS}: {patch_id}-{bug_id}-{repo}")

            except:
                patch_data["pass_testcase"] = -100
                patch_data["error_type"] = "ERROR:NOT EXECUTED"
                print(f"{ERROR}: severe error in {patch_id}-{bug_id}-{repo}")

    utils.save_dict_to_jsonfile(f"{data_dir}/data.json", repo_data)


def get_repo_list(field, metadata):
    return [repo for repo in metadata if is_true(field, metadata[repo])]


if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument("--capture",
                        action='store_true',
                        default=False,
                        help="compile and capture benchmarks")
    parser.add_argument(
        "--buggy_data",
        action='store_true',
        default=False,
        help="generate buggy data by deleting existing null handling code")
    parser.add_argument("--find_test",
                        action='store_true',
                        default=False,
                        help="find oracle testcase for each bug")
    parser.add_argument("--test_patch",
                        action='store_true',
                        default=False,
                        help="test each patch")
    parser.add_argument("--n_cpus",
                        type=int,
                        default=20,
                        help="number of cpus")
    parser.add_argument("--repo_list",
                        nargs='+',
                        default=[],
                        help="list of repositories to learn")
    args = parser.parse_args()

    metadata = utils.read_json_from_file(METADATA)

    p = Pool(args.n_cpus)

    repo_list = [repo for repo in args.repo_list]
    if repo_list == []:
        repo_list = get_repo_list("is_compiled", metadata)

    metadata = Manager().dict(metadata)

    if args.capture:
        p.starmap(capture, zip(repo_list, repeat(metadata)))

    if args.buggy_data:
        p.starmap(generate_data, zip(repo_list, repeat(metadata)))

    if args.find_test:
        p.map(find_test, repo_list)

    if args.test_patch:
        p.map(test_patch, repo_list)

    if not (args.capture or args.buggy_data or args.find_test
            or args.test_patch):
        print("no argument given")

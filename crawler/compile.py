import os, sys, glob
ROOT_DIR = os.getcwd()
sys.path.append(ROOT_DIR)
import utils
import time
import argparse
import re
import requests
import json
import subprocess
from easyprocess import EasyProcess  # type: ignore
from multiprocessing import Pool
from multiprocessing import Manager
from itertools import repeat
import logging

logfile = open("logs/%s.log" % (time.strftime("%m%d_%I%M", time.localtime())),
               'w')

METADATA = f"{ROOT_DIR}/metadata.json"
BENCH_DIR = f"{ROOT_DIR}/benchmarks"
APACHE = "https://github.com/apache"


def is_done(repodata):
    return "is_compiled" not in repodata or not repodata["is_compiled"]
    #return "is_compiled" in repodata # and repodata["is_compiled"]


def parse_error(error_messages, commit_data):
    for error_message in error_messages:
        if error_message.startswith('[FATAL]'):
            commit_data["FATAL"] = error_message
        if error_message.startswith('[ERROR]'):
            commit_data["ERROR"] = error_message
        if "Failed to execute goal" in error_message:
            commit_data["FAILED_TO_EXECUTE"] = error_message
        if "missing" in error_message:
            commit_data["MISSING"] = error_message
        if "transfer" in error_message:
            commit_data["TRANSFER"] = error_message


def get_subdirs(repo_dir):
    if os.path.isfile(f"{repo_dir}/pom.xml"):
        pom_paths = [
            os.path.abspath(path)
            for path in glob.glob(f"{repo_dir}/*/pom.xml")
        ]
        return [pom_path.strip("/pom.xml") for pom_path in pom_paths]
    else:
        return []


def compile(repo_dir, repodata):
    if "is_compiled" in repodata and repodata["is_compiled"]:
        return True

    repo = os.path.basename(repo_dir)
    compile_cmd = utils.get_compile_command(repo_dir)
    if compile_cmd is None:
        repodata["is_compiled"] = False
        print(f"{repo} has no pom")
        return False

    ret_clone = utils.execute(compile_cmd, repo_dir)
    if ret_clone.return_code is 1:
        repodata["is_compiled"] = False
        print(f"{repo} is failed to be compiled")
        parse_error(ret_clone.stdout, repodata)
        return False

    repodata["is_compiled"] = True
    return True


def test(repo_dir, repodata):
    if "pass_testcase" in repodata and repodata["pass_testcase"]:
        return True
    
    repo = os.path.basename(repo_dir)
    ret_test = utils.execute("mvn test -Drat.skip", repo_dir)
    if ret_test.return_code is 1:
        repodata["pass_testcase"] = False
        print(f"{repo} is failed to pass testcase")
        return False
    
    repodata["pass_testcase"] = True
    return True 


def do_subdir(sub_dir, sub_project_data):
    compile_cmd = utils.get_compile_command(sub_dir)
    if compile_cmd is None:
        return False

    ret_clone = utils.execute(compile_cmd, sub_dir)
    if ret_clone.return_code is 1:
        sub_project_data["is_compiled"] = False
        return False
    sub_project_data["is_compiled"] = True

    ret_test = utils.execute("mvn test -Drat.skip", sub_dir)
    if ret_test.return_code is 1:
        sub_project_data["pass_testcase"] = False
        return False
    sub_project_data["pass_testcase"] = True
    return True


def do_repo(repo, metadata):
    repodata = metadata[repo] if repo in metadata else {}

    repo_dir = f"{BENCH_DIR}/{repo}"
    if is_done(metadata[repo]):
        print(f"{repo} is done!")
        return None

    print('compiling %s...' % repo)

    if compile(repo_dir, repodata) is False:
        metadata[repo] = repodata
        return

    if test(repo_dir, repodata) is False:
        metadata[repo] = repodata
        return

    sub_dirs = get_subdirs(repo_dir)
    subdata = repodata["sub_projects"] if "sub_projects" in repodata else {}
    for sub_dir in sub_dirs:
        sub_project = os.path.basename(sub_dir)
        sub_project_data = subdata[sub_project] if sub_project in subdata else {}
        do_subdir(sub_dir, sub_project_data)
        subdata[sub_project] = sub_project_data   

    repodata["sub_projects"] = subdata
    metadata[repo] = repodata

    utils.save_dict_to_jsonfile(METADATA, metadata.copy())


if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument("--n_cpus",
                        type=int,
                        default=1,
                        help="specify # of threads to use")
    args = parser.parse_args()
    n_cpus = args.n_cpus

    repo_file = open("repo.txt", 'r')

    if os.path.isfile(f"{ROOT_DIR}/metadata.json"):
        metadata = utils.read_json_from_file(f"{ROOT_DIR}/metadata.json")
    else:
        metadata = {}

    repos = [repo.split('\n')[0] for repo in repo_file.readlines()]

    with Pool(n_cpus) as p:
        metadata = Manager().dict(metadata)
        p.starmap(do_repo, zip(repos, repeat(metadata)))
        metadata = metadata.copy()

    utils.save_dict_to_jsonfile(METADATA, metadata)

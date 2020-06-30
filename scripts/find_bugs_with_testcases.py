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
import shutil
from easyprocess import EasyProcess  #type: ignore
from easyprocess import EasyProcessError
from multiprocessing import Process
from multiprocessing import Pool
from multiprocessing import Manager
from functools import partial
from itertools import repeat

logfile = open("logs/%s.log" % (time.strftime("%m%d_%I%M", time.localtime())),
               'w')
incremental = True


def test_filenames(class_name):
    return \
    ['%sTest.java' % class_name, '%sTests.java' % class_name, \
     '%stest.java' % class_name, '%stests.java' % class_name, \
     'Test%s.java' % class_name, 'Tests%s.java' % class_name, \
     'test%s.java' % class_name, 'tests%s.java' % class_name]


def is_testfile(class_name):
    testname = [class_name[-4:], class_name[:4]]
    tests = ('Test', 'Tests', 'test', 'tests')
    for test in tests:
        if test in testname:
            return class_name.replace(test, '')
    return False


def find_unit_tests(commit):
    commit_id = commit['commit'].split('/')[-1][:7]
    repo = commit['repo']
    bug_id = "%s_%s" % (repo, commit_id)
    commit_dir = f"{ROOT_DIR}/benchmarks/{repo}/{commit_id}"

    unit_tests = set()
    patched = set()

    files = commit['file']

    find_cmd = 'find . -name '
    there_is_test = False
    file_names = []
    for file_data in files:
        filepath = file_data['filename']
        filename = filepath.split('/')[-1]
        if filename.split('.')[-1] != 'java':
            patched.add(filename)
            continue
        classname = filename.split('.')[0]

        replaced_testfile = is_testfile(classname)

        #case 1. file_data is testfile
        if replaced_testfile:
            there_is_test = True
            patched_filename = replaced_testfile + '.java'
            find = find_cmd + patched_filename
            ret = utils.execute(find, commit_dir)
            if ret.stdout != '':
                patched.add(patched_filename)
            unit_tests.add(classname + '.java')
        else:
            file_names.append(classname + '.java')

        #case 2. file_data is not testfile & has testfile
        filenames_to_find = test_filenames(classname)
        for test_filename in filenames_to_find:
            find = find_cmd + test_filename
            ret = EasyProcess(find).call()
            if ret.stdout != '':
                patched.add(classname + '.java')
                unit_tests.add(test_filename)

    if there_is_test:
        patched |= set(file_names)

    return list(patched), list(unit_tests)


def is_done(commit):
    repo = commit['repo']
    commit_id = commit['commit'].split('/')[-1][:7]
    bug_id = f"{repo}_{commit_id}"
    metadata = utils.read_json_from_file(f"{ROOT_DIR}/metadata.json")
    if bug_id not in metadata: return False
    else: return True
    if "is_invalid_repo" in metadata[bug_id]: return True
    if "is_invalid_commit" in metadata[bug_id]: return True
    if "size" in metadata[bug_id] and metadata[bug_id]["size"].endswith("G"):
        return True
    if "is_maven2" in metadata[
            bug_id] and metadata[bug_id]["is_maven2"] is False:
        return True
    return incremental and "has_testcase_commits" in metadata[
        bug_id] and metadata[bug_id]["has_testcase_commits"]


def do_commit(commit, output):
    repo = commit['repo']
    commit_id = commit['commit'].split('/')[-1][:7]
    bug_id = "%s_%s" % (repo, commit_id)

    if is_done(commit):
        print(f"{bug_id} is done!")
        return None

    print('doing %s...' % bug_id)
    repo_dir = f"{ROOT_DIR}/benchmarks/{repo}"
    commit_dir = f"{repo_dir}/{commit_id}"
    original_dir = f"{repo_dir}/{repo}"
    ret = {"repo": repo, "commit_id": commit_id}

    #2. Clone
    if os.path.isdir(original_dir) is False:
        ret_clone = utils.execute(
            f"git clone https://github.com/apache/{repo} {repo}", repo_dir)
        if ret_clone.return_code is 128:
            ret["is_invalid_repo"] = True
            return ret
    if os.path.isdir(commit_dir) is False:
        utils.execute(f"cp -r {original_dir} {commit_dir}", repo_dir)
    os.chdir(commit_dir)
    git_checkout_command = "git checkout -f %s" % commit_id
    ret_checkout = utils.execute(git_checkout_command, commit_dir)
    if ret_checkout.return_code is 1:
        ret["is_invalid_commit"] = True
        shutil.rmtree(f"{commit_dir}")
        return ret

    #3. Check if unit-tests exist for each commit
    ret["size"] = subprocess.check_output(['du', '-sh', commit_dir
                                           ]).split()[0].decode('utf-8')
    ret["is_maven2"] = os.path.isfile(f"{commit_dir}/pom.xml")
    if ret["is_maven2"] is False or ret["size"].endswith("G"):
        shutil.rmtree(f"{commit_dir}")
        return ret

    patched, unit_tests = find_unit_tests(commit)
    os.chdir('..')
    if unit_tests:
        logfile.writelines("%s: has unit-test \n" % bug_id)
        commit['bug_id'] = bug_id
        commit['patched_files'] = patched
        commit['unit_tests'] = unit_tests
        output[bug_id] = commit
        ret["has_testcase_commits"] = True
    else:
        ret["has_testcase_commits"] = False
        shutil.rmtree(f"{commit_dir}")
        logfile.writelines("%s: has no unit-tests\n" % bug_id)
    logfile.flush()
    return ret


def is_done_repo(repo):
    return incremental and os.path.isfile(f"{ROOT_DIR}/data/{repo}_test.json")


def do_parallel(repos, n_cpus=8):
    if os.path.isfile(f"{ROOT_DIR}/metadata.json"):
        metadata = utils.read_json_from_file(f"{ROOT_DIR}/metadata.json")
    else:
        metadata = {}

    for repo in repos:
        repo = repo.split('\n')[0]
        if is_done_repo(repo):
            print("%s is already done!" % repo)
        elif os.path.isfile(f"{ROOT_DIR}/data/{repo}_data.json") is False:
            print("%s has no data_json" % repo)
        if os.path.isdir(f"{ROOT_DIR}/benchmarks/{repo}") is False:
            os.mkdir(f"{ROOT_DIR}/benchmarks/{repo}")

        bugs_in_one_repo = utils.read_json_from_file(f"data/{repo}_data.json")

        output = Manager().dict()

        commits = []
        with Pool(n_cpus) as p:
            commits = p.starmap(do_commit, zip(bugs_in_one_repo,
                                               repeat(output)))

        output = output.copy()
        utils.save_dict_to_jsonfile(f"{ROOT_DIR}/data/{repo}_test.json",
                                    output)

        for commit in commits:
            if commit is None: continue
            bug_id = "%s_%s" % (commit["repo"], commit["commit_id"])
            metadata[bug_id] = commit

        utils.save_dict_to_jsonfile(f"{ROOT_DIR}/metadata.json", metadata)


if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument("--repo",
                        type=str,
                        default='',
                        help="specify NPE-fix commits by REPO")
    parser.add_argument("--n_cpus",
                        type=int,
                        default=1,
                        help="specify # of threads to use")
    parser.add_argument("-only-unit-test",
                        type=bool,
                        default=True,
                        help="compile only commits with testcase")
    parser.add_argument("--re_analyze",
                        action='store_false',
                        default=True,
                        help="re-analyze")
    args = parser.parse_args()
    incremental = args.re_analyze

    repo = args.repo
    n_cpus = args.n_cpus

    repo_file = open("repo_with_commits.txt", 'r')
    do_parallel(repo_file.readlines(), n_cpus)

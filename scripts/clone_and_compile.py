import os, sys, glob
import time
import argparse
import re
import requests
import json
from easyprocess import EasyProcess
from easyprocess import EasyProcessError
from multiprocessing import Process
from multiprocessing import Pool
import logging

ROOT_DIR = os.getcwd()
APACHE_URL = "https://github.com/apache"

## global repository dictonary
repo_dict = {}

def get_compile_command():
    if os.path.isfile('pom.xml'):
        return 'cpulimit --limit=100 -- mvn clean install -DskipTests'
    elif os.path.isfile('maven.xml'):
        return 'cpulimit --limit=100 -- maven clean install -DskipTests'
    else:
        return None

def get_test_command(testClass, project):
    if os.path.isfile('pom.xml'):
        return 'mvn clean test -Dtest=%s -DfailIfNoTests=false' % testClass if project == 'src' \
        else 'mvn clean test -Dtest=%s --pl %s -amd -DfailIfNoTests=false' % (testClass, project) 
    elif os.path.isfile('maven.xml'):
        return 'maven clean test -Dtest=%s -DfailIfNoTests=false' % testClass
    else:
        return None

## find unittests for NPE class
def find_file_path(filenames):
    # TODO: how to select NPE file?
    file_paths = []
    for file_name in filenames:
        file_paths.extend(glob.glob("**/%s" % file_name, recursive=True))
        
    return file_paths

def has_outdated_urls():
    urls = ['nexus.codehaus.org', 'vm094.oxylos.org']
    for url in urls:
        if not (EasyProcess('grep %s pom.xml' % url).call().stdout is ''):
            return True
    return False


def unittest(commit, testFilename, non_testing_files):
    #TODO: we only consider a single class to test.
    ret = {}
    ret['test_file'] = testFilename
    
    #a) Is fixed code correct w.r.t. test-cases?
        #TODO: we do not consider package.class, but class only.
    testFile = testFilename.split('/')[-1]
    testClass = testFile.split('.')[0]

    test_cmd = get_test_command(testClass, testFilename.split('/')[1])
    if test_cmd is None:
        logger.warning(" - not maven project")
        logger.handlers[0].flush()
        ret['fixed'] = False
        ret['buggy'] = False
        ret['test_file'] = None
        return ret

    logger.info("test command: %s" % (test_cmd))
    logger.handlers[0].flush()
    
    test_fixed_ret = EasyProcess(test_cmd).call()
    ret['fixed'] = True if test_fixed_ret.return_code is 0 else False

    #b) Is buggy code incorrect w.r.t. test-cases?
    parent_commit = commit['parent'].split('/')[-1]

    checkout_cmd = 'git checkout %s -- %s' % (parent_commit, ' '.join(non_testing_files))
    logger.info("git checkout command for buggy version: %s" % (checkout_cmd))
    logger.handlers[0].flush()
    checkout_ret = EasyProcess(checkout_cmd).call()

    test_buggy_ret = EasyProcess(test_cmd).call()
    ret['buggy'] = True if test_buggy_ret.return_code is 0 else False

    #TODO: parse error message of test_ret.stderr / .stdout
    ret['buggy_files'] = non_testing_files
    
    return ret

def is_done(bug_id):
    with open("logs/clone_and_compile.log", 'r') as logfile:
        if bug_id in logfile.read():
            return True
        else:
            return False

def do_commit(commit):
    repo = commit['repo']
    os.chdir(ROOT_DIR)
    if is_done(commit['bug_id']):
        print("%s is already done!" % commit['bug_id'])
        return False

    repo_path = os.path.abspath("benchmarks/%s" % repo)
    os.makedirs(repo_path, exist_ok=True)
    os.chdir(repo_path)

    print("doing %s ..." % commit['bug_id'])
    repo_url = "%s/%s" % (APACHE_URL, repo)

    patchedfiles = commit['patched_files']
    unittests = commit['unit_tests']
    
    commit_url = commit['commit']
    # 6-digit commit hash, which is used as the name of a directory
    commit_id = commit['commit'].split('/')[-1]
    commit_dir = commit_id[:6]

    ## 1. checkout commit
    git_checkout_command = "git checkout -f %s" % commit_id

    os.chdir(commit_dir)
    logger.info("git checkout command for fixed version: %s" % (git_checkout_command))
    ret_checkout = EasyProcess(git_checkout_command).call()

    ## 2. build repo if unit-test exists
    compile_cmd = get_compile_command()
    non_testing_files = find_file_path(patchedfiles)
    test_files = find_file_path(unittests)
    if compile_cmd is None:
        logger.warning("# %s IS NOT MAVEN PROJECT" % commit['bug_id'])
        logger.handlers[0].flush()
        return False
    elif not test_files:
        logger.warning("# %s HAS NO TESTCASE" % commit['bug_id'])
        logger.handlers[0].flush()
        return False
    elif not non_testing_files:
        logger.warning("# %s HAS NO PATCHED FILE" % commit['bug_id'])
        logger.handlers[0].flush()
        return False
    elif has_outdated_urls():
        logger.warning("# %s HAS OUTDATED URLS" % commit['bug_id'])
        logger.handlers[0].flush()
        return False

    ##### HEURISTIC: skip commit that has only testfile #####
    changed_files = set(changed_file['filename'].split('/')[-1] for changed_file in commit['file'])
    if len(changed_files - set(unittests)) == 0:
        logger.warning("# %s HAS NO PATCHED FILE COMMITED" % commit['bug_id'])
        logger.handlers[0].flush()
        return False

    logger.info("compile command for buggy version: %s" % (compile_cmd))
    ret_compile = EasyProcess(compile_cmd).call()

    ## 3. Testing
    status = ""
    json_for_write = [commit]
    for test in test_files:
        ret = unittest(commit, test, non_testing_files)
        status = "Bug: %s, Compiled: %d, Fixed: %s, Buggy: %s" \
        % (commit['bug_id'], ret_compile.return_code, ret['fixed'], ret['buggy'])
        logger.info(status)
        logger.handlers[0].flush()
        if (ret['fixed'] & (not ret['buggy'])):
            json_for_write.append(ret)
    if len(json_for_write) > 1:
        with open(ROOT_DIR + '/data/%s_npe.json' % commit['bug_id'], 'a') as jsonfile:
            jsonfile.write(json.dumps(json_for_write, indent=4))
        return True
    return False

def do_repo(repo, n_cpus):
    commits = list(repo_dict[repo]['commits'].values())
    with Pool(n_cpus) as p:
        p.map(do_commit, commits)

## main function
if __name__ == '__main__':
    logger = logging.getLogger()
    logger.setLevel(logging.INFO)
    formatter = logging.Formatter('[%(asctime)s/%(levelname)s]%(processName)s - %(message)s')

    file_handler = logging.FileHandler("logs/clone_and_compile.log")
    file_handler.setFormatter(formatter)
    logger.addHandler(file_handler)

    parser = argparse.ArgumentParser()
    parser.add_argument("--n_cpus", type=int, default=12, help="specify # of threads to use")
    parser.add_argument("--repo", type=str, default=None, help="specify a repository to test, default: all repository")
    args = parser.parse_args()
    n_cpus = args.n_cpus
    repo = args.repo

    os.chdir(ROOT_DIR)
    datadir = '%s/data' % ROOT_DIR

    repos = []
    if repo is None:
        with open("repo_with_commits.txt", 'r') as repo_file:
            repos = [repo.split('\n')[0] for repo in repo_file.readlines()]
    else:
        repos = [repo]

    for repo in repos:
        with open("data/%s_test.json" % repo, 'r') as repo_data_file:
            repo_json = json.loads(repo_data_file.read())
        
        if len(repo_json.keys()) is 0:
            continue
        
        repo_info = {}
        repo_info['n_commits'] = len(repo_json.keys())
        repo_info['commits'] = repo_json
        repo_dict[repo] = repo_info

    for repo in repo_dict.keys():
        do_repo(repo, n_cpus)
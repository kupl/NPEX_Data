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

ROOT_DIR = os.getcwd()
APACHE_URL = "https://github.com/apache"

## global repository dictonary
repo_dict = {}

## log files
starttime = time.strftime("%m%d_%I%M", time.localtime())
logfile = open("logs/%s.log" % starttime, 'w')

def has_outdated_urls():
    urls = ['nexus.codehaus.org', 'vm094.oxylos.org']
    for url in urls:
        if not (EasyProcess('grep %s pom.xml' % url).call().stdout is ''):
            return True
    return False

def get_test_command(testClass, project):
    if os.path.isfile('pom.xml'):
        return 'mvn clean test -Dtest=%s -DfailIfNoTests=false' % testClass if project == 'src' \
        else 'mvn clean test -Dtest=%s --pl %s -amd -DfailIfNoTests=false' % (testClass, project) 
    elif os.path.isfile('maven.xml'):
        return 'maven clean test -Dtest=%s -DfailIfNoTests=false' % testClass
    else:
        return None


def get_compile_command():
    if os.path.isfile('pom.xml'):
        return 'mvn clean install -DskipTests'
    elif os.path.isfile('maven.xml'):
        return 'maven clean install -DskipTests'
    else:
        return None 

## Load repo data into a repo_dict
def load_repository_data(repos): 
    for repo in repos:
        repo_data_file = open("data/%s.json" % repo, 'r')
        repo_json = json.loads(repo_data_file.read())
        repo_data_file.close()
        
        if len(repo_json.keys()) is 0:
          continue
        
        repo_info = {}
        repo_info['n_commits'] = len(repo_json.keys())
        repo_info['commits'] = repo_json
        repo_dict[repo] = repo_info


## find unittests for NPE class
def find_test_classes(commit):
    # TODO: how to select NPE file?
    test_files = []
    for file_data in commit['file']:
        filename = file_data['filename']
        classname = filename.split('/')[-1].split('.')[0]

        test_patterns = \
            [   '%sTest.java' % classname, '%sTests.java' % classname, \
                '%stest.java' % classname, '%stests.java' % classname, \
                'Test%s.java' % classname, 'Tests%s.java' % classname, \
                'test%s.java' % classname, 'tests%s.java' % classname ]

        for tp in test_patterns:
            #glob_patterns = [ '**/%s' % tp for tp in test_patterns ]
            found = glob.glob('**/%s' % tp, recursive=True)
            test_files.extend(found)
        
    return test_files


## make a directory for repo. and iterate commits until succeed count reaches limit
def do_repo(repo, limit=100, dir=ROOT_DIR):
    os.chdir(dir) 
    repo_path = os.path.abspath("benchmarks/%s" % repo)
    os.makedirs(repo_path, exist_ok=True)

    commits = repo_dict[repo]['commits']
    for bug_id in commits:
        os.chdir(repo_path)

        if limit == 0: return

        if (do_commit(commits[bug_id], repo_path) == True):
            limit = limit + 16
        else:
            limit = limit - 1
        logfile.flush()


def unittest(commit, testFile):
    #TODO: we only consider a single class to test.
    ret = {}
    ret['buggy_class'] = None 
    
    #a) Is fixed code correct w.r.t. test-cases?
        #TODO: we do not consider package.class, but class only.
    testClass = testFile.split('.')[0]
    testFilename = (EasyProcess('find . -name %s' % testFile).call()).stdout.split('\n')[0]
    # Testcase exists for latest version, but not for this version.
    if testFilename is '':
        logfile.writelines(" - no testfile found for %s\n" % commit['bug_id'])
        ret['fixed'] = False
        ret['buggy'] = False
        ret['buggy_class'] = None
        return ret
    
    test_cmd = get_test_command(testClass, testFilename.split('/')[1])
    if test_cmd is None:
        logfile.writelines(" - not maven project\n")
        ret['fixed'] = False
        ret['buggy'] = False
        ret['buggy_class'] = None
        return ret

    logfile.writelines(" - test command: %s\n" % test_cmd)
    
    test_ret = EasyProcess(test_cmd).call()
    ret['fixed'] = True if test_ret.return_code is 0 else False

    #b) Is buggy code incorrect w.r.t. test-cases?
    parent_commit = commit['parent'].split('/')[-1]
   
    non_testing_names = [changed_file['filename'] for changed_file in commit['file'] \
        if changed_file['filename'].split('/')[-1] != testFile ]
    checkout_cmd = 'git checkout %s -- %s' % (parent_commit, ' '.join(non_testing_names))
    logfile.writelines(" - git checkout command for buggy version: %s\n" % checkout_cmd)
    checkout_ret = EasyProcess(checkout_cmd).call()
   
    test_ret = EasyProcess(test_cmd).call()
    ret['buggy'] = True if test_ret.return_code is 0 else False
  
    #TODO: parse error message of test_ret.stderr / .stdout
    ret['buggy_class'] = testFile.split('.')[0] 
    
    return ret 

def do_commit(commit, dir):
    print("doing %s ..." % commit['bug_id'])
    repo = commit['repo']
    repo_url = "%s/%s" % (APACHE_URL, repo)

    unittests = commit['unit_tests']
    
    commit_url = commit['commit']
    # 6-digit commit hash, which is used as the name of a directory
    commit_id = commit['commit'].split('/')[-1][:6]

    ## 1. clone repo and checkout commit
    git_clone_command = "git clone %s %s" % (repo_url, commit_id)
    git_checkout_command = "git checkout -f %s" % commit_id
    
    ret_clone = EasyProcess(git_clone_command).call()
    os.makedirs(commit_id, exist_ok=True)
    os.chdir(commit_id)
    ret_checkout = EasyProcess(git_checkout_command).call()
  
    # Do not log in the repository. Some repos require no additional files in the repo.
    if os.path.isfile('commands.log'):
        os.system('rm commands.log')

    ## 2. build repo if unit-test exists
    compile_cmd = get_compile_command()
    if compile_cmd is None:
        logfile.writelines("# %s IS NOT MAVEN PROJECT\n" % commit['bug_id'])
        return False
    elif not find_test_classes(commit):
        logfile.writelines("# %s HAS NO TESTCASE \n" % commit['bug_id'])
        return False
    elif has_outdated_urls(): 
        logfile.writelines("# %s HAS OUTDATED URLS \n" % commit['bug_id'])
        return False

    ret_compile = EasyProcess(compile_cmd).call()

    ## 3. Testing
    status = ""
    for test in unittests:
        ret = unittest(commit, test)
        status = "Bug: %s, Compiled: %d, Fixed: %s, Buggy: %s, BuggyClass: %s\n" \
          % (commit['bug_id'], ret_compile.return_code, ret['fixed'], ret['buggy'], ret['buggy_class'])

        if (ret['fixed'] & (not ret['buggy'])):
            logfile.writelines(status)
            return True
    logfile.writelines(status) 
    return False



## main function
if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument("--n_cpus", type=int, default=16, help="specify # of threads to use")
    parser.add_argument("--repo", type=str, default=None, help="specify a repository to test, default: all repository")
    args = parser.parse_args()
    n_cpus = args.n_cpus
    repo = args.repo

    os.chdir(ROOT_DIR)
    datadir = '%s/data' % ROOT_DIR

    repos = []
    if repo is None:
        repo_file = open("repo_with_pom.txt", 'r')
        repos = [repo.split('\n')[0] for repo in repo_file.readlines()]
        repo_file.close()
    else:
        repos = [repo]
    load_repository_data(repos)

    p = Pool(16)
    args = [[k] for k in sorted(repo_dict, key=lambda k: repo_dict[k]['n_commits'], reverse=True)]
    p.starmap(do_repo, args)




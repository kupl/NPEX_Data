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

def get_compile_command():
    if os.path.isfile('pom.xml'):
        return 'mvn clean install -DskipTests'
    elif os.path.isfile('maven.xml'):
        return 'maven clean install -DskipTests'
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

def get_test_command(testClass, project):
    if os.path.isfile('pom.xml'):
        return 'mvn clean test -Dtest=%s -DfailIfNoTests=false' % testClass if project == 'src' \
        else 'mvn clean test -Dtest=%s --pl %s -amd -DfailIfNoTests=false' % (testClass, project) 
    elif os.path.isfile('maven.xml'):
        return 'maven clean test -Dtest=%s -DfailIfNoTests=false' % testClass
    else:
        return None

class clone_and_compile:

    def __init__(self, repos):
        ## global repository dictonary
        self.repo_dict = {}
        for repo in repos:
            with open("data/%s_test.json" % repo, 'r') as repo_data_file:
                repo_json = json.loads(repo_data_file.read())
            
            if len(repo_json.keys()) is 0:
                continue
            
            repo_info = {}
            repo_info['n_commits'] = len(repo_json.keys())
            repo_info['commits'] = repo_json
            self.repo_dict[repo] = repo_info

        ## log files
        starttime = time.strftime("%m%d_%I%M", time.localtime())
        self.logfile = open("logs/%s.log" % starttime, 'w')
    
    def unittest(self, commit, testFilename, non_testing_files):
        #TODO: we only consider a single class to test.
        ret = {}
        ret['buggy_class'] = None 
        
        #a) Is fixed code correct w.r.t. test-cases?
            #TODO: we do not consider package.class, but class only.
        testFile = testFilename.split('/')[-1]
        testClass = testFile.split('.')[0]

        test_cmd = get_test_command(testClass, testFilename.split('/')[1])
        if test_cmd is None:
            self.logfile.writelines(" - not maven project\n")
            ret['fixed'] = False
            ret['buggy'] = False
            ret['buggy_class'] = None
            return ret
        

        self.logfile.writelines(" - test command: %s\n" % test_cmd)
        
        test_ret = EasyProcess(test_cmd).call(timeout=300)
        ret['fixed'] = True if test_ret.return_code is 0 else False

        #b) Is buggy code incorrect w.r.t. test-cases?
        parent_commit = commit['parent'].split('/')[-1]

        checkout_cmd = 'git checkout %s -- %s' % (parent_commit, ' '.join(non_testing_files))
        self.logfile.writelines(" - git checkout command for buggy version: %s\n" % checkout_cmd)
        checkout_ret = EasyProcess(checkout_cmd).call()

        test_ret = EasyProcess(test_cmd).call(timeout=300)
        ret['buggy'] = True if test_ret.return_code is 0 else False

        #TODO: parse error message of test_ret.stderr / .stdout
        ret['buggy_class'] = testFile.split('.')[0] 
        
        return ret 

    def do_commit(self, commit):
        repo = commit['repo']
        os.chdir(ROOT_DIR)
        repo_path = os.path.abspath("benchmarks/%s" % repo)
        os.makedirs(repo_path, exist_ok=True)
        os.chdir(repo_path)

        print("doing %s ..." % commit['bug_id'])
        repo_url = "%s/%s" % (APACHE_URL, repo)

        patchedfiles = commit['patched_files']
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
        non_testing_files = find_file_path(patchedfiles)
        test_files = find_file_path(unittest)
        if compile_cmd is None:
            self.logfile.writelines("# %s IS NOT MAVEN PROJECT\n" % commit['bug_id'])
            return False
        elif not test_files:
            self.logfile.writelines("# %s HAS NO TESTCASE \n" % commit['bug_id'])
            return False
        elif not non_testing_files:
            self.logfile.writelines("# %s HAS NO PATCHED FILE\n" % commit['bug_id'])
            return False
        elif has_outdated_urls():
            self.logfile.writelines("# %s HAS OUTDATED URLS \n" % commit['bug_id'])
            return False
        ##### HEURISTIC: test only if testfile is commited #####
        changed_files = set(changed_file['filename'].split('/')[-1] for changed_file in commit['file'])
        if len(changed_files - set(unittests)) == len(changed_files): 
            self.logfile.writelines("# %s HAS NO TESTCASE COMMITED \n" % commit['bug_id'])
            return False

        ret_compile = EasyProcess(compile_cmd).call(timeout=300)

        ## 3. Testing
        status = ""
        for test in test_files:
            ret = self.unittest(commit, test, non_testing_files)
            status = "Bug: %s, Compiled: %d, Fixed: %s, Buggy: %s, BuggyClass: %s\n" \
            % (commit['bug_id'], ret_compile.return_code, ret['fixed'], ret['buggy'], ret['buggy_class'])

            if (ret['fixed'] & (not ret['buggy'])):
                self.logfile.writelines(status)
                return True
        self.logfile.writelines(status) 
        return False


## main function
if __name__ == '__main__':
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
        with open("repo_with_pom.txt", 'r') as repo_file:
            repos = [repo.split('\n')[0] for repo in repo_file.readlines()]
    else:
        repos = [repo]
    cnc = clone_and_compile(repos)

    p = Pool(16)
    commits = []
    for repo in repos:
        commits += cnc.repo_dict[repo]['commits'].values()
    p.starmap(cnc.do_commit, commits)

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
from functools import partial

starttime = time.strftime("%m%d_%I%M", time.localtime())
log = "%s.log" % starttime
logfile = open("logs/" + log, 'w')

build_command = \
{   \
    'camel': 'clean install -Pfastinstall'  
}

def test_filenames(class_name):
    return \
    ['%sTest.java' % class_name, '%sTests.java' % class_name, \
     '%stest.java' % class_name, '%stests.java' % class_name, \
     'Test%s.java' % class_name, 'Tests%s.java' % class_name, \
     'test%s.java' % class_name, 'tests%s.java' % class_name] 

def find_unit_tests(commit):
    commit_id = commit['commit'].split('/')[-1]
    repo = commit['repo']
    bug_id = "%s_%s" % (repo, commit_id[:7])
    
    logfile_commit = open('%s.log' % bug_id, 'w')
    unit_tests = []

    logfile_commit.writelines("==== Changed files ====\n")
    files = commit['file']
    for file_data in files:
        filename = file_data['filename']
        classname = filename.split('/')[-1].split('.')[0]
        
        filenames_to_find = test_filenames(classname)
        unit_tests = []
        for test_filename in filenames_to_find:
            find_cmd = 'find . -name ' + test_filename
            ret = EasyProcess(find_cmd).call()
            if ret.stdout != '':
                unit_tests.append(test_filename)
        
        logfile_commit.writelines("%s\n" % filename)

    logfile_commit.writelines("\n==== RESULTS ====\n")
    if unit_tests:
        logfile_commit.writelines("Found testcases:\n - %s\n" % unit_tests)
    else:
        logfile_commit.writelines("Unit-tests are not found")
    logfile_commit.close()
    
    return unit_tests 

def do_repo(repo):
    output_file = open("data/%s.json" % repo, 'w')
    output = {}
    
    #1. Find commit data of repo
    bug_file = None
    try:
        bug_file = open("data/%s_data.json" % repo, 'r')
    except:
        return
    os.system("mkdir benchmarks/%s" % repo)
    os.chdir("benchmarks/%s" % repo)
    print(os.getcwd())
    
    #2. Clone 
    git_http = "https://github.com/apache/%s" % repo
    git_clone_cmd = "git clone %s" % git_http
    ret_clone = EasyProcess(git_clone_cmd).call()
   
    #3. Check if unit-tests exist for each commit
    os.chdir(repo)
    print(os.getcwd())
    
    for bugs_in_one_repo in bug_file.readlines():
        bugs_in_one_repo = json.loads(bugs_in_one_repo.split('\n')[0])
        for bug_commit in bugs_in_one_repo:
            commit_id = bug_commit['commit'].split('/')[-1]
            bug_id = "%s_%s" % (repo, commit_id[:7])
            unit_tests = find_unit_tests(bug_commit)
            if unit_tests:
                logfile.writelines("%s: has unit-test \n" % bug_id)
                bug_commit['bug_id'] = bug_id
                bug_commit['unit_tests'] = unit_tests
                output[bug_id] = bug_commit
            else:
                logfile.writelines("%s: has no unit-tests\n" % bug_id)
  
    logfile.flush()
    bug_file.close()
    output_file.write(json.dumps(output, indent=4, sort_keys=True))
    output_file.close()
    os.chdir("..")
    os.chdir("../..")

def do_parallel(repos, n_cpus=8):
    p = Pool(n_cpus)
    args = [[repo.split('\n')[0]] for repo in repos]
    
    p.starmap(do_repo, args)

if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument("--repo", type=str, default='', help="specify NPE-fix commits by REPO")
    parser.add_argument("--n_cpus", type=int, default=1, help="specify # of threads to use")
    parser.add_argument("-only-unit-test", type=bool, default=True, help="compile only commits with testcase")
    args = parser.parse_args()
   
    repo = args.repo
    n_cpus = args.n_cpus

    repo_file = open("repo.txt", 'r')
    do_parallel(repo_file.readlines(), n_cpus)

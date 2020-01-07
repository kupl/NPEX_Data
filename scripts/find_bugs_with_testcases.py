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
from multiprocessing import Queue
from functools import partial

starttime = time.strftime("%m%d_%I%M", time.localtime())
log = "%s.log" % starttime
logfile = open("logs/" + log, 'w')

build_command = \
{   \
    'camel': 'clean install -Pfastinstall'  
}

PATH = os.path.abspath(os.getcwd())
q = Queue()

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
    commit_id = commit['commit'].split('/')[-1]
    repo = commit['repo']
    bug_id = "%s_%s" % (repo, commit_id[:7])

    unit_tests = set()
    patched = set()

    files = commit['file']

    find_cmd = 'find . -name '
    there_is_test = False
    file_names = []
    for file_data in files:
        filename = file_data['filename']
        classname = filename.split('/')[-1].split('.')[0]

        replaced_testfile = is_testfile(classname)
        
        #case 1. file_data is testfile
        if replaced_testfile:
            there_is_test = True
            patched_filename = replaced_testfile + '.java'
            find = find_cmd + patched_filename
            ret = EasyProcess(find).call()
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

def do_commit(commit):
    repo = commit['repo']
    git_http = "https://github.com/apache/%s" % repo
    commit_id = commit['commit'].split('/')[-1]
    bug_id = "%s_%s" % (repo, commit_id[:7])
    print('doing %s...' % bug_id)

    git_clone_cmd = "git clone %s %s" % (git_http, commit_id[:6])
    git_checkout_command = "git checkout -f %s" % commit_id[:6]

    #2. Clone 
    ret_clone = EasyProcess(git_clone_cmd).call()
    os.makedirs(commit_id[:6], exist_ok=True)
    os.chdir(commit_id[:6])
    ret_checkout = EasyProcess(git_checkout_command).call()

    output = ()
    #3. Check if unit-tests exist for each commit
    patched, unit_tests = find_unit_tests(commit)
    if unit_tests:
        logfile.writelines("%s: has unit-test \n" % bug_id)
        commit['bug_id'] = bug_id
        commit['patched_files'] = patched
        commit['unit_tests'] = unit_tests
        output = (bug_id, commit)
    else:
        logfile.writelines("%s: has no unit-tests\n" % bug_id)
    logfile.flush()
    q.put(output)

def do_repo(repo, n_cpus):
    os.chdir(PATH)
    output_file = open("data/%s_test.json" % repo, 'w')
    
    #1. Find commit data of repo
    bug_file = None
    try:
        bug_file = open("data/%s_data.json" % repo, 'r').read()
    except:
        return
    os.system("mkdir benchmarks/%s" % repo)
    os.chdir("benchmarks/%s" % repo)
    print(os.getcwd())
    
    bugs_in_one_repo = json.loads(bug_file)
    with Pool(n_cpus) as p:
        p.map(do_commit, bugs_in_one_repo)
    
    output = {}
    while True:
        if q.empty():
            break
        else:
            bug_id, commit = q.get()
            output[bug_id] = commit

    output_file.write(json.dumps(output, indent=4, sort_keys=True))
    output_file.close()

def do_parallel(repos, n_cpus=8):
    args = [[repo.split('\n')[0]] for repo in repos]
    for arg in args:
        do_repo(''.join(arg), n_cpus)

if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument("--repo", type=str, default='', help="specify NPE-fix commits by REPO")
    parser.add_argument("--n_cpus", type=int, default=1, help="specify # of threads to use")
    parser.add_argument("-only-unit-test", type=bool, default=True, help="compile only commits with testcase")
    args = parser.parse_args()
   
    repo = args.repo
    n_cpus = args.n_cpus

    repo_file = open("repo_with_commits.txt", 'r')
    do_parallel(repo_file.readlines(), n_cpus)

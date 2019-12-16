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
logfile = open(log, 'w')

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

def is_with_unittest(bug, logfile_repo):
    files = bug['file']
    for file_data in files:
        filename = file_data['filename']
        classname = filename.split('/')[-1].split('.')[0]
        test_filename = classname + 'Test.java'
        # TODO: various test names
        
        find_cmd = 'find . -name ' + test_filename
        logfile_repo.writelines(find_cmd)
        ret = EasyProcess(find_cmd).call()
        
        if ret.stdout != '':
            return True
    return False

def testing(bug, logfile_repo):
    files = bug['file']
    #TODO: we only consider a single class to test.
    testFile = None
    nonTestFile = None
    ret = {}
    ret['buggy_class'] = '' 
    
    for file_data in files:
        filename = file_data['filename']
        classname = filename.split('/')[-1].split('.')[0]
        test_filename = classname + 'Test.java'
        find_cmd = 'find . -name ' + test_filename
        print(find_cmd)
        find_ret = EasyProcess(find_cmd).call()
        if find_ret.stdout != '':
            testFile = find_ret.stdout.split('\n')[0] # Choose first class
            nonTestFile = filename
            break

    #a) Is fixed code correct w.r.t. test-cases?
        #TODO: we do not consider package.class, but class only.
    testClass = testFile.split('/')[-1].split('.')[0] 
    project = testFile.split('/')[1] #./project/...
    
        #TODO: should we consider mvnw here?
    test_cmd = 'mvn clean test -Dtest=%s --pl %s -amd -DfailIfNoTests=false' % (testClass, project)
    logfile_repo.writelines(test_cmd)
    test_ret = EasyProcess(test_cmd).call()

    if test_ret.return_code is 0:
        ret['fixed'] = True
    else:
        ret['fixed'] = False

    #b) Is buggy code incorrect w.r.t. test-cases?
    parent_commit = bug['parent'].split('/')[-1]
    
    checkout_cmd = 'git checkout %s -- %s' % (parent_commit, nonTestFile)
    logfile_repo.writelines(checkout_cmd)
    checkout_ret = EasyProcess(checkout_cmd).call()
   
    logfile_repo.writelines(test_cmd)
    test_ret = EasyProcess(test_cmd).call()
    
    #TODO: parse error message of test_ret.stderr / .stdout
    if test_ret.return_code is 0:
        ret['buggy'] = True
    else: 
        ret['buggy'] = False
        ret['buggy_class'] = nonTestFile.split('/')[-1].split('.')[0] 

    #Test-case is poorly designed
    return ret 




def do_bug(bug):
    git_http = "https://github.com/apache/" + bug['repo']
    commit_id = bug['commit'].split('/')[-1]
    bug_id = bug['bug_id']

    git_clone_cmd = "git clone " + git_http + " " + bug['bug_id']
    git_checkout_cmd = "git checkout -f " + commit_id
    chdir_cmd = "cd %s" % bug['bug_id']
    test_cmd = ""

    #1.git clone & chdir
    ret_clone = EasyProcess(git_clone_cmd).call()
    
    print('\n' + chdir_cmd)
    os.chdir(bug['bug_id'])
    print(os.getcwd())

    logfile_repo = open("compile.log", 'w')

    #2.git checkout & check if unit-test exists
    logfile_repo.writelines(git_checkout_cmd)
    ret_checkout = EasyProcess(git_checkout_cmd).call()
   
    if not is_with_unittest(bug,logfile_repo):
    	logfile_repo.writelines('UnitTest NotFound!!')
    	os.chdir('..')
    	logfile_repo.close()
    	return
    
    #3. Compile 
    start_time = time.time()
    
    compile_option = ''
    try:
        compile_option = build_command[bug['repo']]
    except:
        compile_option = 'clean install -Dtest=Class'
        #compile_option = 'clean install -DskipTests'
    
    try: 
        logfile_repo.writelines('./mvnw %s' % compile_option)
        ret_compile = EasyProcess('./mvnw %s' % compile_option).call()
    except EasyProcessError: #FileNotFoundError 
        logfile_repo.writelines('mvn %s' % compile_option)
        ret_compile = EasyProcess('mvn %s' % compile_option).call()
    
    time_elapsed = time.time() - start_time
    logfile.writelines("Compile status of %s: %d ... %s sec\n" % \
        (bug_id, ret_compile.return_code, str(time_elapsed)[0:3]))
   
    #4. Testing
    start_time = time.time()
    ret_testing = testing(bug, logfile_repo) 
    time_elapsed = time.time() - start_time

    logfile.writelines("Testing status of %s: (%s, %s, %s) ... %s sec\n" % \
        (bug_id, ret_testing['fixed'], ret_testing['buggy'], ret_testing['buggy_class'], str(time_elapsed)[0:3]))
    logfile.flush()
   
    logfile_repo.close() 
    os.chdir('..')

def find_bugs(repo, bug_id, bug_file):
    bugs = []
    
    for bugs_in_one_repo in bug_file.readlines():
        bugs_in_one_repo = json.loads(bugs_in_one_repo.split('\n')[0])
        for bug_commit in bugs_in_one_repo:
            if bug_commit['repo'] != repo:
                break
            if bug_commit['bug_id'].split('_')[1] == bug_id or bug_id == 0:
                bugs.append(bug_commit)
        #if bugs: 
        #    break

    return bugs

def do_bug_in_parallel(bugs, n_cpus):
    p = Pool(n_cpus)
    args = [[bug] for bug in bugs]
    
    p.starmap(do_bug, args)

def do_repo(repo, bug_id):
    bug_file = None
    try:
        bug_file = open("data/%s_data.json" % repo, 'r')
    except:
        logfile.writelines("%s has no commit data\n" % repo)
    else: 
        bug_file = open("data/%s_data.json" % repo, 'r')
       
        for bugs_in_one_repo in bug_file.readlines():
            bugs_in_one_repo = json.loads(bugs_in_one_repo.split('\n')[0])
            for bug_commit in bugs_in_one_repo:
                logfile.writelines("%s: %s\n" % (bug_commit['bug_id'], bug_commit['commit']))  

        bug_file.close()


if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument("--repo", type=str, default='', help="specify NPE-fix commits by REPO")
    parser.add_argument("--bug_id", type=str, default=0, help="specify NPE-fix ID in repo")
    parser.add_argument("--n_cpus", type=int, default=1, help="specify # of threads to use")
    parser.add_argument("-only-unit-test", type=bool, default=True, help="compile only commits with testcase")
    args = parser.parse_args()
   
    repo = args.repo
    bug_id = args.bug_id
    n_cpus = args.n_cpus

    if repo == '':
        repo_file = open("repo.txt", 'r')
        for repo in repo_file.readlines():
            repo = repo.split('\n')[0]
            do_repo(repo, bug_id)
    else:
        do_repo(repo, bug_id)

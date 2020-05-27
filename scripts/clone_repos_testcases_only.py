import os, sys, glob
import time
import argparse
import re
import requests
import json
from easyprocess import EasyProcess # type: ignore
from easyprocess import EasyProcessError
from multiprocessing import Process
from multiprocessing import Pool
from multiprocessing import Manager
from functools import partial
from itertools import repeat
from typing import List, Set, Dict, Tuple, Optional


starttime = time.strftime("%m%d_%I%M", time.localtime())
log = "%s.log" % starttime
logfile = open("logs/" + log, 'w')

PATH = os.path.abspath(os.getcwd())

def execute(cmd : str, dir: str):
    os.chdir(dir)
    ret = EasyProcess(cmd).call()
    err_msg = "=== Execute %s ===\n  * return_code : %d\n  * stdout : %s\n  * stderr : %s\n" % (cmd, ret.return_code, ret.stdout, ret.stderr)
    logfile.write(err_msg)
    logfile.flush()
    return ret

def do_commit(commit : Dict):
    repo = commit['repo']
    git_http = "git://github.com/apache/%s" % repo
    commit_id = commit['commit'].split('/')[-1][:6]
    
    repo_dir = "%s/benchmarks/%s" % (PATH, repo)
    commit_dir = "%s/%s" % (repo_dir, commit_id)
    bug_id = "%s_%s" % (repo, commit_id)
    print('doing %s...' % bug_id)
    
    if os.path.exists ("%s/.git" % commit_dir):
        return

    #1. Copy
    execute("cp -r %s/%s %s" % (repo_dir, repo, commit_dir), repo_dir)

    #2. Checkout 
    git_checkout_command = "git checkout -f %s" % commit_id
    execute(git_checkout_command, commit_dir)

def do_repo(repo, n_cpus):
    os.chdir(PATH)
    #1. Find commit data of repo
    bug_jsonstr = None
    try:
        bug_jsonstr = open("data/%s_test.json" % repo, 'r').read()
        if bug_jsonstr == '{}' or bug_jsonstr == '':
            return
    except:
        print ("%s has no test.json" % repo)
        return
    os.system("mkdir benchmarks/%s" % repo)
    os.chdir("benchmarks/%s" % repo)
    print(os.getcwd())
   

    git_http = "git://github.com/apache/%s" % repo
    git_clone_cmd = "git clone %s" % git_http
    ret = execute(git_clone_cmd, '.')
    if ret.return_code == 128:
        return
    
    bugs_in_one_repo = json.loads(bug_jsonstr)
    args = [ bugs_in_one_repo[commit] for commit in bugs_in_one_repo.keys() ]

    with Pool(n_cpus) as p:
        p.map(do_commit, args)

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

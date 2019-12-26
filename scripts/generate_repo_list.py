import os, sys, glob
import time
import argparse
import re
import json
from easyprocess import EasyProcess
from easyprocess import EasyProcessError
from multiprocessing import Process
from multiprocessing import Pool
from functools import partial

starttime = time.strftime("%m%d_%I%M", time.localtime())
log = "logs/%s.log" % starttime
logfile = open(log, 'w')

def do_repo(repo):
    if os.path.isfile('%s/%s/pom.xml' % (repo, repo)):
        logfile.writelines("%s\n" % repo)
        print("%s" % repo)
        
def do_parallel(repos, n_cpus=8):
    p = Pool(n_cpus)
    args = [[repo.split('\n')[0]] for repo in repos]
    p.starmap(do_repo, args)

if __name__ == '__main__':
    repo_file = open("repo.txt", 'r')
    os.chdir("benchmarks") 
    for repo in repo_file.readlines():
        repo = repo.split('\n')[0]
        do_repo(repo)

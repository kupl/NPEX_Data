import os, sys, glob
import time
import argparse
import re
import json

starttime = time.strftime("%m%d_%I%M", time.localtime())
log = "logs/%s.log" % starttime
logfile = open(log, 'w')

def do_repo(repo):
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
    repo_file = open("repo.txt", 'r')
    for repo in repo_file.readlines():
        repo = repo.split('\n')[0]
        do_repo(repo)

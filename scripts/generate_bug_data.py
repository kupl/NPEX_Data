import os, sys, glob
import time
import argparse
import re
import requests
import json
from easyprocess import EasyProcess
from multiprocessing import Process
from multiprocessing import Pool
from functools import partial

source = "https://github.com/apache?language=java&page="

APACHE_SOURCE = "https://github.com/apache?language=java&page="
APACHE_PROJECT_SOURCE = "https://github.com/apache/"

username = 'SeongjoonHong'
token = '5fea79434dc2c3d0e434f3afb0e7c2bb4beba95d'
headers = \
            {   'Accept': 'application/vnd.github.cloak-preview', \
                    'Authorization': 'token %s' % token }

def is_empty(repo):
    try:
        file_to_write = open("data/%s_data.json" % repo, 'r')
    except FileNotFoundError:
        return True
    else:
        for line in file_to_write.readlines():
            if line == '':
                return True
            if line == '[]':
                return True
        return False

def do_repo(repo):
    if not is_empty(repo):
        print ("%s is already done!" % repo)
        return
    
    jsonfile = open("data/%s" % repo, 'r')
    repo_commits = jsonfile.readlines()

    outputs = []
    output_file = open("data/%s_data.json" % repo, 'w')
    i = 1
    for commits in repo_commits:
        commits = json.loads(commits.split('\n')[0])
        for commit in commits:
            data = {}
            data['commit'] = commit['html_url']
            data['repo'] = commit['html_url'].split('/')[-3]
            data['parent'] = commit['parents'][0]['html_url']
            data['message'] = commit['commit']['message']
            data['bug_id'] = data['repo'] + "_" + str(i)
           
            link = 'https://api.github.com/repos/apache/%s/commits/%s' % (data['repo'], data['commit'].split('/')[-1])
            res = requests.get(link, auth=(username, token), headers=headers)
         
            # End of page
            if res.status_code == 500:
                continue
            if res.status_code == 404:
                continue

            # Should not fail
            if res.status_code == 429:
                print('backoff!')
            if res.status_code != 200:
                print(res.headers)

            data['file'] = json.loads(res.content.decode("utf-8"))['files']
            print(data['repo'] + str(i))
            outputs = outputs + [data] 
            i = i + 1

        output_file.write(json.dumps(outputs) + '\n')
        outputs = []
        output_file.flush()

        # sleep for limit 5000/hour
        time.sleep(len(commits))
    return
        


if __name__ == '__main__':
    repo_file = open("repo.txt", 'r')
    repos = repo_file.readlines()

    for repo in repos:
        do_repo(repo.split('\n')[0])



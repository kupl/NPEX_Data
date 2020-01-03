import os, sys, glob
import time
import argparse
import re
import requests
from bs4 import BeautifulSoup
from easyprocess import EasyProcess
from multiprocessing import Process
from multiprocessing import Pool
from functools import partial
import json

source = "https://github.com/apache?language=java&page="

APACHE_SOURCE = "https://github.com/apache?language=java&page="
APACHE_PROJECT_SOURCE = "https://github.com/apache/"

username = 'SeongjoonHong'
token = '5fea79434dc2c3d0e434f3afb0e7c2bb4beba95d'
headers = \
            {   'Accept': 'application/vnd.github.cloak-preview', \
                    'Authorization': 'token %s' % token }

if __name__ == '__main__':
    commits = []
    commitfile = open("commits.txt", 'w')

    repofile = open("repo.txt", 'r')
    new_repofile = open("repo_with_commits.txt", 'w')
    repos = repofile.readlines()
    for repo in repos:
        i = 1
        backoff = 2.05
        repo = repo.split('\n')[0]
        jsonfile = open("data/%s.json" % repo, 'w')
        while True:
            time.sleep(backoff)
            commit_page_link = "https://api.github.com/search/commits?q=repo:apache/%s+NPE+OR+NullPointerException&page=%d&per_page=100" % (repo, i)

            res = requests.get(commit_page_link, auth=(username,token), headers=headers)
            print("%s request's status : %d, page: %d" % (repo, res.status_code, i))
            
            if res.status_code == 500:
                break
            if res.status_code == 404:
                break
            if res.status_code == 422:
                break
            if res.status_code == 429:
                time.sleep(backoff)
                continue
           
            contents = json.loads(res.content.decode("utf-8"))
            
            try: 
                items = contents['items']
            except:
                time.sleep(backoff)
                continue

            if not items: 
                break
            
            new_repofile.write(repo + '\n')
            jsonfile.write(json.dumps(items, indent=4) + '\n')
            jsonfile.flush()
            print("done")
            i = i + 1

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

class generate_bug_data:

    def __init__(self, repo):
        self.repo = repo
        print(self.repo)
        self.jsonfile = open("data/%s.json" % self.repo).read()
        self.repo_commits = json.loads(self.jsonfile)

    def is_done(self):
        try:
            file_to_write = open("data/%s_data.json" % self.repo).read()
        except FileNotFoundError:
            return False
        else:
            return len(json.loads(file_to_write)) == len(self.repo_commits)

    def do_repo(self):
        if self.is_done():
            print ("%s is already done!" % self.repo)
            return

        outputs = []
        output_file = open("data/%s_data.json" % self.repo, 'w')
        i = 1
        for commit in self.repo_commits:
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
                print(res.status_code)
                print(res.headers)

            data['file'] = json.loads(res.content.decode("utf-8"))['files']
            print(data['repo'] + str(i))
            outputs.append(data)
            i = i + 1

        output_file.write(json.dumps(outputs, indent=4))
        outputs = []
        output_file.flush()
        output_file.close()

        # sleep for limit 5000/hour
        time.sleep(len(self.repo_commits))
        return


if __name__ == '__main__':
    repo_file = open("repo_with_commits.txt", 'r')
    repos = repo_file.readlines()

    for repo in repos:
        gbd = generate_bug_data(repo.split('\n')[0])
        gbd.do_repo()

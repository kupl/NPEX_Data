import os, sys, glob
import time
import argparse
import re
import requests
import json
import utils
from pprint import pprint
from typing import List, Set, Dict, Tuple, Optional
from dataclasses import asdict, dataclass, field, fields, is_dataclass
from benchmarks import *
from config import *

source = "https://github.com/apache?language=java&page="

APACHE_SOURCE = "https://github.com/apache?language=java&page="
APACHE_PROJECT_SOURCE = "https://github.com/apache/"

username = 'SeongjoonHong'
token = '5fea79434dc2c3d0e434f3afb0e7c2bb4beba95d'
headers = \
            {   'Accept': 'application/vnd.github.cloak-preview', \
                    'Authorization': 'token %s' % token }

ROOT_DIR = os.getcwd()

@dataclass
class Statistics:
  ratio_of_compiled_patches: str
  reliability: str 
  fix_rate: str
  bugs: int = 0
  compiled: int = 0 
  has_validating_tc: int = 0
  fixed: int = 0 
  has_plasible_patches: List[str] = field(default_factory=list)
  no_validating_testcases: List[str] = field(default_factory=list)
  no_plausible_patches: List[str] = field(default_factory=list)
  no_patch_bugs: List[str] = field(default_factory=list)
  not_compled_bugs: List[str] = field(default_factory=list)

  def __init__(self, target_branches):
    patch_not_compiled = 0
    patch_compiled = 0
    patch_passed = 0
    self.has_plasible_patches: List[str] = [] 
    self.no_plausible_patches: List[str] = [] 
    self.no_patch_bugs: List[str] =        [] 
    self.not_compled_bugs: List[str] =     []
    self.no_validating_testcases = []
  
    for target_branch in target_branches:
      print(f"{PROGRESS}: reading {target_branch}...")
      self.bugs = self.bugs + 1
      bug = Bug.from_branch(target_branch)
      
      if bug.build_info.compiled:
        self.compiled = self.compiled + 1
        
      if bug.test_info and bug.test_info.testcases != []:
        self.has_validating_tc = self.has_validating_tc + 1
      elif bug.build_info.compiled:
        self.no_validating_testcases.append(bug.bug_id)
         
      for patch in bug.patch_results:
        if patch.compiled:
          patch_compiled = patch_compiled + 1
        else:
          patch_not_compiled = patch_not_compiled + 1
        if patch.pass_testcase:
          patch_passed = patch_passed + 1
      
      if any([patch.pass_testcase for patch in bug.patch_results]):
        self.fixed = self.fixed + 1
        self.has_plasible_patches.append(bug.bug_id)
      elif bug.patch_results != []:
        self.no_plausible_patches.append(bug.bug_id)
      elif bug.build_info.compiled:
        self.no_patch_bugs.append(bug.bug_id)
      else:
        self.not_compled_bugs.append(bug.bug_id)
  
    self.ratio_of_compiled_patches = f"{patch_compiled}/{patch_compiled + patch_not_compiled}"    
    self.reliability = f"{patch_passed}/{patch_compiled}"
    self.fix_rate = f"{self.fixed}/{self.has_validating_tc}"

  def to_json(self):
      utils.save_dict_to_jsonfile(f"{ROOT_DIR}/statistics.json", asdict(self))
   


def get_repo_info (url):
  url = args.url
  repo = url.split('/')[-3]
  commit_id = url.split('/')[-1]
  link = 'https://api.github.com/repos/apache/%s/commits/%s' % (repo, commit_id)
  res = requests.get(link, auth=(username, token), headers=headers)
  content = json.loads(res.content.decode("utf-8"))

  changed_files : List[str] = [ file["filename"] for file in content["files"]]
  test_files = [file for file in changed_files if file.endswith("Test.java")]
  patch_files = [file for file in list(set(changed_files) - set(test_files)) if file.endswith(".java")]

  ret = {
      "repo": repo,
      "commit_url": args.url,
      "parent_url": content["parents"][0]["html_url"],
      "changed_files": changed_files,
      "patch_files": patch_files,
      "test_files": test_files
  }

  utils.save_dict_to_jsonfile("repo.json", ret)

parser = argparse.ArgumentParser()
parser.add_argument("--url", help="url")
parser.add_argument("--all", help="do all")
parser.add_argument("--statistics", help="statictics")
args = parser.parse_args()

target_branches = [
    os.path.basename(br)
    for br in glob.glob(".git/refs/remotes/origin/benchmarks/*-buggy")
]

if os.path.isdir(f"{ROOT_DIR}/seed") is False:
  utils.execute (f"git config credential.helper store --global", ROOT_DIR, verbosty=1)
  utils.execute (f"mkdir seed", ROOT_DIR)
  utils.execute (f"cp -r .git seed", ROOT_DIR)

if args.all:
  # for target_branch in target_branches:
  #     Bug.configure(target_branch)
  utils.multiprocess (Bug.configure, target_branches, n_cpus=10)
    
if args.statistics:
  Statistics(target_branches).to_json()

  
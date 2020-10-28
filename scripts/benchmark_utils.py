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
  org = url.split('/')[-4]
  repo = url.split('/')[-3]
  commit_id = url.split('/')[-1]
  link = 'https://api.github.com/repos/%s/%s/commits/%s' % (org, repo, commit_id)
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
  execute(f"git add repo.json", ROOT_DIR)
  execute(f"git commit -m \"add repo.json\"", ROOT_DIR)
  execute(f"git push", ROOT_DIR)

def generate_trace(target_branch):
  bug_dir = f"{ROOT_DIR}/{target_branch}"
  try:
    bug = Bug.from_json(f"{bug_dir}/bug.json")
    bug.generate_trace(bug_dir)
    bug.to_json(bug_dir)
  except: 
    pass

parser = argparse.ArgumentParser()
parser.add_argument("--url", help="url")
parser.add_argument("--all",        action='store_true', default=False, help="do all")
parser.add_argument("--statistics", action='store_true', default=False, help="statictics")
parser.add_argument("--do_all", help="do cmd for all branches" )
parser.add_argument("--trace", action='store_true', default=False, help="trace")
parser.add_argument("--get_repo", action='store_true', default=False, help="get repository info from commit url")
parser.add_argument("--bug_id", help="get repository info from commit url")
args = parser.parse_args()

if args.bug_id:
  target_branches = [args.bug_id]
else:
  target_branches = [
      os.path.basename(br)
      for br in glob.glob(".git/refs/remotes/origin/benchmarks/*-buggy")
  ]

if args.all:
  # for target_branch in target_branches:
  #     Bug.configure(target_branch)
  utils.multiprocess (Bug.configure, target_branches, n_cpus=10)
    
if args.statistics:
  Statistics(target_branches).to_json()

if args.trace:
  utils.multiprocess (generate_trace, target_branches, n_cpus=20)
  # for target_branch in target_branches:
  #   generate_trace(target_branch
  
if args.do_all:
  def execute (dir):
    cmd = args.do_all
    utils.execute(cmd, dir=dir, verbosity=1)
  utils.multiprocess (execute, target_branches, n_cpus=1)
 
if args.url:
  get_repo_info(args.url)
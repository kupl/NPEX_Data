import os, sys, glob
import utils
import argparse
import pprint
import re
import time
from typing import List, Set, Dict, Tuple, Optional
from config import *
from multiprocessing import Pool

import xml.etree.ElementTree as ET

ROOT_DIR = os.getcwd()
LEARNING_DIR = f"{ROOT_DIR}/learning_data"
BENCH_DIR = f"{ROOT_DIR}/benchmarks"

def get_spoon_cmd(repo_dir):
    return f"java -cp {SYNTHESIZER} npex.Main -extract {repo_dir}/ {LEARNING_DIR}/" 

def modify_npe(bug_dir):
    lines = open(f"{bug_dir}/buggy.java", 'r')
    i = 1
    line_number = None
    for line in lines:
        if "NPEX_NULL_EXP" in line:
            npe_line_number = i + 1
            npe_json = utils.read_json_from_file(f"{bug_dir}/npe.json")
            npe_json["line"] = npe_line_number
            utils.save_dict_to_jsonfile(f"{bug_dir}/npe.json", npe_json)
            return True
        i = i + 1
    return False

def find_alarm(repo, bug_dir):
   # apply bug file to original
    original_dir = f"{BECHMARKS_DIR}/{repo}"
    buggy_file = f"{bug_dir}/buggy.java"
    original_filepath = utils.read_json_from_file(f"{bug_dir}/npe.json")["filepath"]
    #utils.execute (f"cp {original_dir}/{original_filepath} {bug_dir}/original.java")
    utils.execute (f"git checkout -f HEAD", original_dir) 
    utils.execute (f"cp {buggy_file} {original_dir}/{original_filepath}", original_dir)
    # analyze and try to find it
    utils.execute (f"python /home/junhee/npex/scripts/generate_alarm_from_npe.py --dir {original_dir} --json {bug_dir}/npe.json", original_dir)
    utils.execute (f"git checkout -f HEAD", original_dir) 
    if os.path.isfile(f"{original_dir}/infer-out/report.json") is False:
        print (f"{WARNING}: no report.json found for {bug_dir}")
        return False
    # if alarm.json exists, return true and move it to bug folder 
    if os.path.isfile(f"{original_dir}/alarm.json") is True:
        utils.execute (f"mv {original_dir}/alarm.json {bug_dir}/alarm.json", original_dir)
        return True
    return False

def do_repo(repo):
    repo_dir = f"{BECHMARKS_DIR}/{repo}"
    repo_data_dir = f"{LEARNING_DIR}/{repo}"

    repo_data = {"repo": repo, "bugs":[]}

    # TODO: remove
    if os.path.isdir(f"{LEARNING_DIR}/{repo}/bugs"):
        utils.execute (f"rm -rf {LEARNING_DIR}/{repo}/bugs", dir=repo_data_dir)
        
    spoon_cmd = get_spoon_cmd(repo_dir)
   
    utils.execute(spoon_cmd, dir=repo_dir, env=env, timeout=120)

    bug_dirs = [dir for dir in glob.glob(f"{LEARNING_DIR}/{repo}/bugs/*") if os.path.isdir(dir)]
    for bug_dir in bug_dirs:
        if os.path.isfile(f"{bug_dir}/npe.json") is False:
            continue
        bug_id = os.path.basename(bug_dir)
        filepath = utils.read_json_from_file(f"{bug_dir}/npe.json")["filepath"] 
        bug_data = {"bug_id": bug_id, "repo": repo, "filepath": filepath}
        repo_data["bugs"].append(bug_data)

        if modify_npe(bug_dir) is False:
            print(f"{WARNING}: no NPEX_NULL_EXP found for {bug_dir}")
            bug_data["has_alarm"] = False
            continue
        if os.path.isfile(f"{bug_dir}/npe.json") is False:
            print(f"{WARNING}: no npe.json for {bug_dir}")
            bug_data["has_alarm"] = False
            continue
        if os.path.isfile(f"{bug_dir}/alarm.json"):
            bug_data["has_alarm"] = True
        elif find_alarm(repo, bug_dir) is True:
            print(f"{SUCCESS}: found NPE benchmarks for {repo}-{bug_id}")
            bug_data["has_alarm"] = True
        else:
            print(f"{FAIL}: failed to find NPE benchmarks for {repo}-{bug_id}")
            bug_data["has_alarm"] = False
            
metadata = utils.read_json_from_file(f"{ROOT_DIR}/metadata.json")
repo_list = [repo for repo in metadata if "is_compiled" in metadata[repo] and metadata[repo]["is_compiled"]]
 
env = utils.set_java_version(8)

p = Pool(8)
p.map(do_repo, repo_list)
           
            
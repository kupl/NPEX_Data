import os, sys, glob
ROOT_DIR = os.getcwd()
sys.path.append(ROOT_DIR)
import utils
import time
import argparse
import re
import requests
import json
import subprocess
import shutil
from easyprocess import EasyProcess  #type: ignore
from multiprocessing import Pool
from multiprocessing import Manager
from itertools import repeat

logfile = open("logs/%s.log" % (time.strftime("%m%d_%I%M", time.localtime())),
               'w')

DATA_DIR = f"{ROOT_DIR}/data"
METADATA = f"{ROOT_DIR}/metadata.json"
BENCH_DIR = f"{ROOT_DIR}/benchmarks"
APACHE = "https://github.com/apache"


def is_done(repodata):
    return "LoC" in repodata



def do_repo(repo, metadata):
    if repo not in metadata:
        metadata[repo] = {}
    repodata = metadata[repo]
    repodata['repo'] = repo

    repo_dir = f"{BENCH_DIR}/{repo}"
    if is_done(repodata):
        print(f"{repo} is done!")
        return None

    if not os.path.isdir(repo_dir) or not os.path.isdir(f"{repo_dir}/.git"):
        ret_clone = utils.execute(f"git clone {APACHE}/{repo}", BENCH_DIR)
        if ret_clone.return_code is 128:
            repodata["is_invalid_repo"] = True
            print(f"{repo} is invalid")
            metadata[repo] = repodata
            return

    repodata["size"] = subprocess.check_output(['du', '-sh', repo_dir
                                                ]).split()[0].decode('utf-8')
    repo_loc = utils.size_of(repo_dir)
    if repo_loc is not None:
        repodata["LoC"] = repo_loc 
    repodata["is_maven2"] = os.path.isfile(f"{repo_dir}/pom.xml")
    repodata["is_gradle"] = os.path.isfile(f"{repo_dir}/build.gradle")

    metadata[repo] = repodata

    utils.save_dict_to_jsonfile(METADATA, metadata.copy())


if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument("--n_cpus",
                        type=int,
                        default=1,
                        help="specify # of threads to use")
    args = parser.parse_args()
    n_cpus = args.n_cpus

    repo_file = open("repo.txt", 'r')

    if os.path.isfile(f"{ROOT_DIR}/metadata.json"):
        metadata = utils.read_json_from_file(f"{ROOT_DIR}/metadata.json")
    else:
        metadata = {}

    repos = [repo.split('\n')[0] for repo in repo_file.readlines()]

    metadata = Manager().dict(metadata)
    with Pool(n_cpus) as p:
        p.starmap(do_repo, zip(repos, repeat(metadata)))
    metadata = metadata.copy()
    print(metadata)
    utils.save_dict_to_jsonfile(METADATA, metadata)

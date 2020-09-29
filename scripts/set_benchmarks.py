import os, sys, glob
import utils
import argparse
import pprint

ROOT_DIR = os.getcwd()
JAVA_VERSIONS = [6, 7, 8, 11]

parser = argparse.ArgumentParser()
parser.add_argument("--json", help="json file for benchmarks info")
parser.add_argument("--directory", help="benchmarks directory")

args = parser.parse_args()

benchmarks = utils.read_json_from_file(args.json)
directory = f"{ROOT_DIR}/{args.directory}"

for bug_data in benchmarks:
    bug_id = bug_data["bug_id"]
    bug_directory = f"{directory}/{bug_id}"
    parent_id = bug_data["repository_info"]["parent_id"] 
    patch_files = ' '.join(bug_data["repository_info"]["patch_files"])

    buggy_dir = f"{directory}/{bug_id}-buggy"

    utils.execute (f"cp -r {bug_directory} {buggy_dir}", directory, verbosity=1)
    utils.execute (f"git checkout -b \"fixed\"", buggy_dir, verbosity=1) 
    utils.execute (f"git commit -m \"fixed\"", buggy_dir, verbosity=1) 
    utils.execute (f"git checkout {parent_id} -- {patch_files}", buggy_dir, verbosity=1 )   
    utils.execute (f"git checkout -b \"buggy\"", buggy_dir, verbosity=1) 
    utils.execute (f"git add {patch_files}", buggy_dir, verbosity=1)   
    utils.execute (f"git commit -m \"buggy\"", buggy_dir, verbosity=1)



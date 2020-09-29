import os, sys, glob
import utils
import argparse
import pprint

ROOT_DIR = os.getcwd()

parser = argparse.ArgumentParser()
parser.add_argument("--json", help="json file for benchmarks info")
parser.add_argument("--dir", help="directory of benchmarks")

args = parser.parse_args()

benchmarks = utils.read_json_from_file(args.json)
output_directory = f"{ROOT_DIR}/{args.output_directory}"

if os.path.isdir(output_directory) is False:
    os.mkdir(output_directory)

ret = []

for bug_data in benchmarks:
    bug_id = bug_data["Id"]
    commit_url = bug_data["Commits"]
    repo_url = '/'.join(commit_url.split('/')[:-2])
    commit_id = commit_url.split('/')[-1][:7]
    repo = commit_url.split('/')[-3]
    bug_directory = f"{output_directory}/{bug_id}"

    utils.execute(f"git clone {repo_url} {bug_id}", output_directory)
    ret_checkout = utils.execute(f"git checkout {commit_id}", bug_directory)

    parent_id = utils.execute(f"git rev-parse --short HEAD~1",
                              bug_directory).stdout
    changed_files = utils.execute(f"git log --name-only --pretty=format: -1",
                                  bug_directory).stdout.split('\n')

    java_files = [file for file in changed_files if file.endswith("java")]

    test_files = [
        file for file in java_files if "test" in file or "Tests" in file
    ]
    patch_files = list(set(java_files) - set(test_files))

    repository_info = {
        "bug_id": bug_id,
        "repo": repo,
        "commit_id": commit_id,
        "parent_id": parent_id,
        "changed_files": changed_files,
        "patch_files": patch_files,
        "test_files": test_files,
        "is_correctly_checkout": ret_checkout.return_code == 0
    }
    pprint.pprint(repository_info)
    ret.append({
        "bug_id": bug_id,
        "repository_info": repository_info,
        "build_info": {},
        "test_info": {},
        "debug_info": {}
    })

utils.save_dict_to_jsonfile(f"{output_directory}/benchmarks.json", ret)

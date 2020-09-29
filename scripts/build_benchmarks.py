import os, sys, glob
import utils
import argparse
import pprint
import subprocess

ROOT_DIR = os.getcwd()
JAVA_VERSIONS = [11, 8, 7, 6]

parser = argparse.ArgumentParser()
parser.add_argument("--json", help="json file for benchmarks info")
parser.add_argument("--directory", help="benchmarks directory")

args = parser.parse_args()

benchmarks = utils.read_json_from_file(args.json)
directory = f"{ROOT_DIR}/{args.directory}"

for bug_data in benchmarks:
    bug_id = bug_data["bug_id"]
    bug_directory = f"{directory}/{bug_id}-buggy"

    if utils.has_field_and_true(bug_data["build_info"], "compiled"):
        print(f" - already done for {bug_id}")
        continue

    bug_data["repository_info"]["LoC"] = utils.size_of(bug_directory)
    bug_data["repository_info"]["size"] = subprocess.check_output(
        ['du', '-sh', bug_directory]).split()[0].decode('utf-8')

    build_dir = f"{bug_directory}/ant" if os.path.isdir(
        f"{bug_directory}/ant") else bug_directory

    for java_version in JAVA_VERSIONS:
        print(f" - try to compile {bug_id} by java {java_version}")
        compile_cmd = utils.get_compile_command(build_dir,
                                                java_version=java_version)
        ret_compile = utils.execute(
            cmd=compile_cmd,
            dir=build_dir,
            env=utils.set_java_version(java_version=java_version))
        if ret_compile.return_code == 0:
            bug_data["build_info"]["build_command"] = compile_cmd
            bug_data["build_info"]["java_version"] = java_version
            bug_data["build_info"]["compiled"] = True
            bug_data["build_info"]["time"] = ret_compile.time
            print(f" - successfully compiled {bug_id} by java {java_version}")
            break
        else:
            continue

    if ret_compile.return_code != 0:
        print(f" - failed to compile {bug_id}")
        bug_data["build_info"]["compiled"] = False
        bug_data["debug_info"]["compile-failure"] = utils.parse_error(
            ret_compile.stdout, {})

    utils.save_dict_to_jsonfile(f"{directory}/benchmarks.json", benchmarks)

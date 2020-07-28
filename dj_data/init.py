import os, sys
ROOT_DIR = os.getcwd()

sys.path.append(f"{ROOT_DIR}/..")
import utils  #type:ignore

DEFECTS4J = "/home/junhee/benchmarks/defects4j/framework/bin/defects4j"

with open("bugs.txt", 'r') as bug_file:
    bug_list = bug_file.read().split('\n')[:-1]

for bug_id in bug_list:
    [repo, version] = bug_id.split('-')
    print(
        f"{DEFECTS4J} checkout -p {repo} -v {version}b -w {ROOT_DIR}/{bug_id}")
    os.system(
        f"{DEFECTS4J} checkout -p {repo} -v {version}b -w {ROOT_DIR}/{bug_id}")

for bug_id in bug_list:
    ret_compile = utils.execute(f"{DEFECTS4J} compile", f"{ROOT_DIR}/{bug_id}")
    if ret_compile.return_code is 1:
        print(f"{bug_id} is not compiled")
    ret_test = utils.execute(f"{DEFECTS4J} test", f"{ROOT_DIR}/{bug_id}")
    if ret_test.return_code is 1:
        print(f"{bug_id} is not tested")

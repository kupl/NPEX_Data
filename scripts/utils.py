import json
import time
import os, sys, glob
import re
import subprocess
import signal
from subprocess import Popen, PIPE, TimeoutExpired
from multiprocessing import Pool
from time import monotonic as timer

from typing import List, Set, Dict, Tuple, Optional
import xml.etree.ElementTree as ET
from config import *

ENV = os.environ

if os.path.isdir("logs") is False:
    os.mkdir("logs")

logfile = open(
    "logs/execute_log_%s.log" %
    str(time.strftime("%m%d_%I%M", time.localtime())), 'w')


def has_field_and_true(dict, field):
    field in dict and dict[field] is True


def find_file(glob_pattern):
    found = []
    for file in glob.glob(glob_pattern, recursive=True):
        found.append(file)

    if len(found) > 1:
        return found
    elif len(found) == 1:
        return found
    else:
        raise FileNotFoundError()


def size_of(repo_dir):
    ret_cloc = execute("cloc . --match-f=.java --json", repo_dir)
    if ret_cloc.stdout == "":
        print(f"[WARNING]: {repo_dir} is not measured by cloc")
        return None
    data = json.loads(ret_cloc.stdout)
    return data["Java"]["code"]


def parse_error(error_message):
    if MSG_COMPILE_FAIL in error_message:
        return MSG_COMPILE_FAIL
    elif MSG_ASSERT_FAIL in error_message:
        return MSG_ASSERT_FAIL
    elif MSG_NPE in error_message:
        return MSG_NPE
    elif MSG_TEST_FAIL in error_message:
        return MSG_TEST_FAIL
    else:
        return "UNKNOWN_ERROR"


def find_java_version(poms):
    for pom in poms:
        print(f" - parsing {pom}")
        root = ET.parse(pom).getroot()
        nsmap = {"m": root.tag.rstrip("project").lstrip('{').rstrip('}')}
        if root.find("m:properties/m:java.src.version", nsmap):
            return root.find("m:properties/m:java.src.version",
                             nsmap).text.split('.')[-1]  # 1.7, 1.8
        else:
            plugins = root.findall(
                "m:build/m:plugins/m:plugin", nsmap) + root.findall(
                    "m:build/m:pluginManagement/m:plugins/m:plugin", nsmap)
            for plugin in plugins:
                art = plugin.find("m:artifactId", nsmap)
                if "compiler" in art.text and plugin.find(
                        "m:configuration/m:source", nsmap):
                    return plugin.find("m:configuration/m:source",
                                       nsmap).text.split('.')[-1]

            # Not found
            jdk = root.find("m:profiles/m:profile/m:activation/m:jdk", nsmap)
            if jdk is None:
                continue  # default
            else:
                return jdk.text[1:].split(',')[0].split('.')[-1]
    return None


def set_detailed_npe(java_version, env=ENV):
    if java_version == 6:
        detailed_npe = DETAILED_NPE6
    elif java_version == 7:
        detailed_npe = DETAILED_NPE7
    elif java_version == 8:
        detailed_npe = DETAILED_NPE8
    elif java_version == 11:
        detailed_npe = DETAILED_NPE11

    env["_JAVA_OPTIONS"] = detailed_npe
    return env


def set_java_version(java_version, env=ENV):
    try:
        java_version = int(java_version)
        if java_version == 6:
            java_home = JDK_6
        elif java_version == 7:
            java_home = JDK_7
        elif java_version == 8:
            java_home = JDK_8
        else:
            java_home = JDK_11
    except:
        java_home = JDK_8
    env["JAVA_HOME"] = java_home
    return env


def get_mvn_command(java_version):
    if java_version <= 6:
        return MVN_OLD
    else:
        return "mvn"


def get_compile_command(cwd, project=None, java_version=None):
    #skip_tests = "-DskipTests"
    if os.path.isfile(f'{cwd}/pom.xml'):
        return f"{get_mvn_command(java_version)} clean test-compile {MVN_OPTION}"
    elif os.path.isfile(f'{cwd}/main.java'):
        return "javac main.java"  # for test
    elif os.path.isfile(f'{cwd}/gradlew'):
        return "./gradlew assemble"
    elif os.path.isfile(f'{cwd}/build.xml'):
        return "ant compile"
    else:
        return None


def remove_terminal(str):
    ansi_escape = re.compile(r'\x1B(?:[@-Z\\-_]|\[[0-?]*[ -/]*[@-~])')
    return ansi_escape.sub('', str)


class Ret:
    def __init__(self, stdout, stderr, return_code, time):
        self.stdout = stdout.decode()
        self.stderr = stderr.decode()
        self.return_code = return_code
        self.time = time


def execute(cmd, dir=None, env=None, timeout=1800, verbosity=0):
    if verbosity >= 1:
        print(f"EXECUTE {cmd} AT {os.path.basename(dir)}")

    start = timer()
    process = Popen(cmd,
                    shell=True,
                    stdout=PIPE,
                    stderr=PIPE,
                    cwd=dir,
                    env=env,
                    preexec_fn=os.setsid)
    try:
        stdout, stderr = process.communicate(timeout=timeout)
    except TimeoutExpired:
        os.killpg(process.pid,
                  signal.SIGINT)  # send signal to the process group
        print(f"{TIMEOUT} occurs during executing {cmd[:20]} at {dir}")
        stdout, stderr = process.communicate()

    ret = Ret(stdout, stderr, process.returncode, timer() - start)
    err_msg = "=== Execute %s ===\n  * return_code : %d\n  * stdout : %s\n  * stderr : %s\n  * dir : %s\n" \
            % (cmd, ret.return_code, ret.stdout, ret.stderr, dir)
    if ret.return_code != 0:
        if verbosity >= 1:
            print(
                f"{ERROR} - FAILED TO EXECUTE {cmd} AT {os.path.basename(dir)}"
            )
        logfile.write(err_msg)
        logfile.flush()
    return ret


def get_test_command(dir, test_classes=[], project=None, java_version=8):
    if os.path.isfile(f'{dir}/pom.xml'):
        if test_classes:
            test_classes = ','.join(test_classes)
            return f'{get_mvn_command(java_version)} clean test -Dtest={test_classes} -DfailIfNoTests=false {MVN_OPTION}'
            # stable test command:
            #return f'{get_mvn_command(java_version)} clean install -Dtest={testClass} -DfailIfNoTests=false {MVN_OPTION}'
            # unstable test command:
        else:
            return f'{get_mvn_command(java_version)} clean test {MVN_OPTION}'
    # elif os.path.isfile('maven.xml'):
    #     return 'maven clean test -Dtest=%s -DfailIfNoTests=false' % testClass
    elif os.path.isfile(f"{dir}/build.xml"):
        return "ant test -logfile \"results.txt\""
    elif os.path.isfile(f"{dir}/gradlew"):  # build.gradle
        return "./gradlew test"
    else:
        print(f" - {os.path.basename(dir)} has no pom.xml, build.xml, gradlew")
        return None


def read_json_from_file(json_filename: str):
    json_file = open(json_filename, 'r')
    json_str = json_file.read()
    return json.loads(json_str)


def save_dict_to_jsonfile(json_filename: str, dict: Dict):
    json_file = open(json_filename, 'w')
    json_file.write(json.dumps(dict, indent=4))

def multiprocess (fun, arg_list, n_cpus=4):
    p = Pool(n_cpus)
    p.map(fun, arg_list)
import os, sys, glob
import utils
import argparse
import pprint
import re
import time
from typing import List, Set, Dict, Tuple, Optional
from config import *

import xml.etree.ElementTree as ET

ROOT_DIR = os.getcwd()

parser = argparse.ArgumentParser()
parser.add_argument("--dir", default=ROOT_DIR, help="patch to apply")
parser.add_argument("--json",
                    default=f"{ROOT_DIR}/npe.json",
                    help="patch to apply")

args = parser.parse_args()

npe = utils.read_json_from_file(args.json)
npe_filepath = npe["filepath"]
npe_line = npe["line"]

reports = utils.read_json_from_file(f"{args.dir}/infer-out/report.json")

ret = []
for report in reports:
    if report["bug_type"] != "NULL_DEREFERENCE":
        continue
    for trace in report["bug_trace"]:
        filepath = trace["filename"]
        line = trace["line_number"]

        #print(f" - comparing {npe_filepath} and {filepath}")
        #print(f" - comparing {npe_line} and {line}")
        if filepath == npe_filepath and (npe_line == line or npe_line - 1 == line):
            print(f"found npe alarm!")
            ret.append(report)

if ret != []:
    utils.save_dict_to_jsonfile(f"{args.dir}/alarm.json", ret)
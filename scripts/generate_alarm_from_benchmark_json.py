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
GENERATE_ALARM_PY = "/home/junhee/npex/scripts/generate_alarm_from_npe.py"

parser = argparse.ArgumentParser()
parser.add_argument("--dir", help="benchmark dir")

args = parser.parse_args()

benchmarks = utils.read_json_from_file(f"{args.dir}/benchmarks.json")
for bug in benchmarks:
    bug_id = bug["bug_id"]
    bug_dir = f"{args.dir}/{bug_id}-buggy"
    utils.execute(f"python {GENERATE_ALARM_PY} --dir {bug_dir}",
                  dir=bug_dir,
                  verbosity=1)

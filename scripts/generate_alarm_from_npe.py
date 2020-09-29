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

compile_cmd = utils.get_compile_command(args.dir, java_version=8)
utils.execute(f"/home/junhee/projects/saver/infer/bin/infer run --biabduction-only --headers -- {compile_cmd}",
              args.dir,
              verbosity=1)

utils.execute(
    f"python /home/junhee/npex/scripts/generate_alarm_from_npe_and_report.py --json {args.json}",
    dir=args.dir,
    verbosity=1)

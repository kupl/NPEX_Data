# /usr/bin/python3.8
from dataclasses import asdict, dataclass
from subprocess import PIPE
from typing import List
import sys
import re
import json
import os
import typing
import subprocess
import benchmarks

JAVA_PATH = '/usr/lib/jvm/java-8-openjdk-amd64/bin/java'
NPEX_SYNTHESIZER_JAR_PATH = '/home/june/project/npex-synthesizer/target/npex-synthesizer-1.0-SNAPSHOT-jar-with-dependencies.jar'
'/usr/lib/jvm/java-8-openjdk-amd64/bin/java -cp /home/june/project/npex-synthesizer/target/npex-synthesizer-1.0-SNAPSHOT-jar-with-dependencies.jar npex.Main'

f = open ("1", 'r')
benchmarks.TraceEntry.generate_trace_json(f.readlines(), os.getcwd())

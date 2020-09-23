# /usr/bin/python3.8
from dataclasses import asdict, dataclass
from os import pipe
from subprocess import PIPE
from typing import List
import re
import json
import os
import typing
import subprocess

JAVA_PATH = '/usr/lib/jvm/java-8-openjdk-amd64/bin/java'
NPEX_SYNTHESIZER_JAR_PATH = '/home/june/project/npex-synthesizer/target/npex-synthesizer-1.0-SNAPSHOT-jar-with-dependencies.jar'
'/usr/lib/jvm/java-8-openjdk-amd64/bin/java -cp /home/june/project/npex-synthesizer/target/npex-synthesizer-1.0-SNAPSHOT-jar-with-dependencies.jar npex.Main'

Testcase = typing.NamedTuple(
    'Testcase', [('klass', str), ('method', str), ('failure_type', str)])


@dataclass
class TraceEntry:
    tag: str
    filepath: str
    line_number: int
    description: str

    @classmethod
    def parse_from_line(cls, ln):
        pattern = r'\[(?P<tag>.*)\] Filepath: (?P<filepath>.*), Line: (?P<lineno>\d+), Element: (?P<desc>.*)'
        if (m := re.search(pattern, ln)):
            return TraceEntry(m.group('tag'), m.group('filepath'), int(m.group('lineno')), m.group('desc'))
        else:
            return None


@dataclass
class Bug:
    id: str
    root: str
    commit: str
    parent: str
    build_command: str
    test_command: str
    testcases: List[Testcase]

    @classmethod
    def generate_from_path(cls, meta_json_path, project_root_path):
        with open(meta_json_path, 'r') as f:
            meta_json = json.load(f)
            id = os.path.basename(project_root_path).strip('-buggy')
            d = next(bug for bug in meta_json if bug['bug_id'] == id)
            commit, parent = map(d['repository_info'].get, [
                                 'commit_id', 'parent_id'])
            build_command, test_command = d['build_info']['build_command'], d['test_info']['test_command']
            testcases = [Testcase(klass=t['test_info']['class'], method=t['test_info']['method'], failure_type=t['failure_info']['type'])
                         for t in d['test_info']['testcases']]
            return Bug(id, project_root_path, commit, parent, build_command, test_command, testcases)

    def get_npe_triggering_test_command(self):
        npe_test = next(t for t in self.testcases if t.failure_type ==
                        'java.lang.NullPointerException')
        if (m := re.search(r'-Dtest=([\S]+)', self.test_command)):
            return (re.sub(m.group(1), f'{npe_test.klass}#{npe_test.method}', self.test_command))
        else:
            return (self.test_command + f' -Dtest={npe_test.klass}#{npe_test.method}')

    def clean_dir(self):
        subprocess.check_output('git checkout -f', shell=True, cwd=self.root)

    def generate_trace(self):
        self.clean_dir()
        cmd_instrument = [
            JAVA_PATH, "-cp", NPEX_SYNTHESIZER_JAR_PATH, "npex.Main", "-trace", self.root]
        subprocess.check_output(" ".join(cmd_instrument),
                                shell=True, cwd=self.root)
        cmd_test = self.get_npe_triggering_test_command()
        output = subprocess.run(cmd_test, shell=True, stdout=PIPE,
                                cwd=self.root).stdout.decode("utf8").split("\n")

        trace = [
            asdict(entry) for ln in output if (entry := TraceEntry.parse_from_line(ln))
        ]

        os.makedirs(dir := f"{self.root}/traces", exist_ok=True)
        with open(f"{dir}/trace.json", "w") as f:
            f.write(json.dumps(trace, indent=4))


def do(meta_json_path, bug_project_path):
    bug = Bug.generate_from_path(meta_json_path, bug_project_path)
    try:
        bug.generate_trace()
    finally:
        bug.clean_dir()

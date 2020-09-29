import os, sys, glob
import pickle
import json
import time
import argparse
import pprint
import shutil
import copy

from typing import List, Set, Dict, Tuple, Optional
from easyprocess import EasyProcess  # type: ignore
from easyprocess import EasyProcessError
from collections import defaultdict
import xml.etree.ElementTree as ET

# Multi-processing
from itertools import repeat
from multiprocessing import Process
from multiprocessing import Manager
from multiprocessing import Pool

# Learning
from sklearn.ensemble import RandomForestClassifier  # type: ignore
from sklearn import tree  # type: ignore
from sklearn.datasets import load_iris  #type:ignore
# from apyori import apriori
from efficient_apriori import apriori  #type: ignore

#Visualization
import graphviz  #type:ignore

#Helper functions
ROOT_DIR = os.getcwd()
sys.path.append(ROOT_DIR)
import utils

model = tree.DecisionTreeRegressor()
model_filename = "model.pkl"
log = "%s.log" % time.strftime("%m%d_%I%M", time.localtime())
if os.path.isdir("logs"):
    logfile = open("logs/" + log, 'w')
else:
    logfile = open(log, 'w')

JAVA_VERSION = 8
FEATURE_PATH = "generated_features.json"
METADATA = f"{ROOT_DIR}/metadata.json"
BUGDATA = f"{ROOT_DIR}/bugdata.json"
BENCH_DIR = f"{ROOT_DIR}/benchmarks"
LEARNING_DIR = f"{ROOT_DIR}/learning_data"
SYNTHESIZER = f"{ROOT_DIR}/npex-synthesizer"
MARSHAL = ".rawdata_marshalled"

MAXLOC = 100000

incremental = True


def is_true(field, data):
    return field in data and data[field] is True


target_features = [
    #"Has_store_instr",
    #"Has_call_instr",
    "Does_assign_null",
    "Does_assign_default",
    "Does_assign_non_default",
    "Has_default_constructor",
    "Has_non_default_constructor",
    "Has_non_constructor",
    "Has_throw_exn",
    #"Does_new"
    # "Has_return_instr"
]


def is_target_feature(feature):
    for target_feature in target_features:
        if target_feature in feature:
            return True

    return False


def bool2int(x):
    y = 0
    for i, j in enumerate(x):
        y += j << i
    return y


class Data:
    def __init__(self, bugdata, patches):
        self.rawdata = {}
        self.transactions = []
        for patch_id in patches:
            repo, bug_name, patch_name = patch_id.split('/')
            bug_id = f"{repo}/{bug_name}"
            patch_data = bugdata[bug_id]["patches"][patch_id]
            patch_dir = patch_data["patch_dir"]
            feature = utils.read_json_from_file(f"{patch_dir}/{FEATURE_PATH}")
            self.rawdata[patch_id] = {
                **feature, "correctness": patch_data["correctness"]
            }
            transaction = [f for f in feature if feature[f]]
            self.transactions.append(tuple(transaction))

    def process(self):
        self.data = []
        self.features = []
        self.target = []
        self.classes = []

        features = self.rawdata[list(self.rawdata)[0]]
        patch_features = [f for f in features if "Patch-blocks" in f]
        non_patch_features = [f for f in features if "Patch-blocks" not in f]
        target_features = [f for f in patch_features if is_target_feature(f)]

        self.features = non_patch_features
        self.classes = patch_features

        for patch_id in self.rawdata:
            patch_data = self.rawdata[patch_id]
            input_value = [int(patch_data[f]) for f in non_patch_features]
            target_value = [int(patch_data[f]) for f in target_features]
            # target_value = bool2int ([int(patch_data[f]) for f in target_features])
            self.data.append(input_value)
            self.target.append(target_value)

    def assiciation_rule_mining(self):
        features = self.rawdata[list(self.rawdata)[0]]
        patch_features = [f for f in features if "Patch-blocks" in f]
        non_patch_features = [f for f in features if "Patch-blocks" not in f]
        itemsets, rules = apriori(self.transactions,
                                  min_support=0.01,
                                  min_confidence=0.5,
                                  max_length=2,
                                  x_features=non_patch_features,
                                  y_features=patch_features,
                                  verbosity=1)

        result = {}
        for rule in rules:
            support = rule.count_full / rule.num_transactions
            confidence = rule.count_full / rule.count_lhs
            lhs = rule.lhs
            rhs = rule.rhs
            lift = confidence / (rule.count_rhs / rule.num_transactions)
            rule_str = f"{lhs} -> {rhs}"
            if lift > 1.0:
                result[rule_str] = {
                    "lhs": lhs,
                    "rhs": rhs,
                    "support": support,
                    "confidence": confidence,
                    "lift": lift
                }
        utils.save_dict_to_jsonfile(f"{ROOT_DIR}/results.json", result)

    def statistics(self):
        statistics = {
            f: 0
            for f in self.features + self.classes + target_features
        }
        statistics["useless_data"] = []
        statistics["useless_features"] = []
        statistics["Skip"] = 0
        statistics["Init-pointer"] = 0
        statistics["Dummy"] = 0

        skip_features = [f for f in self.features if "Skip-block" in f]
        print (f"Skip-features : {skip_features}")

        for patch_id in self.rawdata:
            patch_data = self.rawdata[patch_id]
            for f in patch_data:
                if patch_data[f]:
                    statistics[f] = statistics[f] + 1
                    for target_feature in target_features:
                        if "Patch-block" in f and target_feature in f:
                            statistics[target_feature] = statistics[
                                target_feature] + 1

            if all([not (patch_data[f]) for f in patch_data]):
                statistics["useless_data"].append(patch_id)

            if all([not (patch_data[f]) for f in self.classes]):
                statistics["Skip"] = statistics["Skip"] + 1

            if all([not (patch_data[f]) for f in skip_features]):
                statistics["Init-pointer"] = statistics["Init-pointer"] + 1
        
            if all([not (patch_data[f]) for f in skip_features]) and all([not (patch_data[f]) for f in self.classes]):
                statistics["Dummy"] = statistics["Dummy"] + 1
        
        for f in self.features + self.classes:
            if statistics[f] == 0:
                statistics["useless_features"].append(f)

        utils.save_dict_to_jsonfile(f"{ROOT_DIR}/statistics.json", statistics)

    def score(self):
        print(self.model.score(self.data, self.target))

    def learn(self, model):
        model.fit(self.data, self.target)
        self.model = model

    def learn_and_print_tree(self):
        model = tree.DecisionTreeClassifier()
        model.fit(self.data, self.target)
        self.model = model

        dot_data = tree.export_graphviz(model,
                                        filled=True,
                                        out_file="model.dot",
                                        feature_names=self.features)
        # print(tree.export_text(model, feature_names=self.features))
        pprint.pprint(self.classes)


def save_model_to_file(model, model_filename: str):
    model_file = open(model_filename, 'wb')
    pickle.dump(model, model_file)


def get_model_from_file(model_filename):
    model_file = open(model_filename, 'rb')
    return pickle.load(model_file)


def is_done(data: Dict, field: str):
    if incremental and field in data and data[field] is True:
        return data
    return False


def parse_error(error_messages, target_message):
    for error_message in error_messages:
        if target_message in error_message:
            return True
    return False

def check_error_in_test(repo_dir, bug_id):
    reports = utils.find_file( f"{repo_dir}/target/surefire-reports/TEST-*.xml")
    if reports is None:
        print (f" - no TEST.xml found at {repo_dir}")
        return False
    
    for report in reports:
        root = ET.parse(report).getroot()
        failures = root.findall('testcase/failure')
        for failure in failures:
            if f"({bug_id}.java" in failure:
                return True
    return False

def learning_classifier(data: List[Dict], model):
    input_data = []
    labels = []
    for patch in data:
        input_data.append(patch["Encoding"])
        labels.append(patch["correctness"])

    model = model.fit(input_data, labels)
    return model


def print_model(model):
    dot_data = tree.export_graphviz(model, out_file=None)
    graph = graphviz.Source(dot_data)
    graph.render("iris")


def objective_function(embedded_data):
    # Label: BinaryVector(str) -> (Correct PatchID List, Incorrect PatchID List)
    label = defaultdict(lambda: ([], []))
    for patch in embedded_data:
        patch_id = str(patch["id"])
        patch_vector = str([int(x == True) for x in patch["Encoding"]])
        (correct_patches, incorrect_patches) = label[patch_vector]
        if "correctness" not in patch:
            raise Exception(f"Correctness is not labeled for {patch_id}")
        if patch["correctness"] is 1:
            label[patch_vector] = (correct_patches + [patch_id],
                                   incorrect_patches)
        else:
            label[patch_vector] = (correct_patches,
                                   incorrect_patches + [patch_id])
    # Calculate objective function
    number_of_all_data = 0
    score: float = 0
    score1 = 0
    score2 = 0
    for k in label.keys():
        (correct_patches, incorrect_patches) = label[k]
        (number_of_correct,
         number_of_incorrect) = len(correct_patches), len(incorrect_patches)
        #    print("%s -> [%d, %d]" % (k, number_of_correct, number_of_incorrect))
        number_of_all_data = number_of_all_data + number_of_correct + number_of_incorrect
        score = abs(number_of_correct - number_of_incorrect) + score
        score1 = min(number_of_correct, number_of_incorrect)**2 + score1
    score = float(score / number_of_all_data) - float(score1 /
                                                      (number_of_all_data**2))
    #pprint.pprint(dict(label))
    #print("Iteration of: %f" % score)
    return label, score


def embed_data(patch, key_features: List[str]):
    for k_feature in key_features:
        if k_feature not in patch["Features"]:
            print("%s - has no %s" % (patch["id"], k_feature))
            exit(1)

    patch["Encoding"] = [
        patch["OriginalFeatures"][k_feature] for k_feature in key_features
    ] + [patch["Features"][k_feature] for k_feature in key_features]

    return patch


#def find_best_feature(data: Dict, features_acc: List[str], features_cand: List):
#    best_feature = None
#    best_label, best_score = objective_function(
#        [embed_data(p, features_acc) for p in data])
#    for feature in features_cand:
#        feature_to_test = features_acc + [feature]
#        feature_embed_data = [embed_data(p, feature_to_test) for p in data]
#        label, score = objective_function(feature_embed_data)
#        if score > best_score:
#            best_feature = feature
#            best_score = score
#            best_label = label
#    return best_feature, best_score, best_label
#
#
#def find_embedding(data: List):
#    key_features: List[str] = []
#    label = {}
#
#    if "Features" not in data[0]:
#        print("%s has no features?!" % data[0]["patch_id"])
#    features = data[0]["Features"].keys()
#    print(' - finding encoding ...')
#
#    features_acc : List[str] = []
#    features_cand = list(features)
#    while True:
#        next_feature, score, label = find_best_feature(data, features_acc,
#                                                       features_cand)
#        if next_feature is None:
#            break
#        features_acc.append(next_feature)
#        features_cand.remove(next_feature)
#        print(next_feature)
#
#    key_features = features_acc
#
#    with open("%s/learning/key_feautures" % ROOT_DIR, 'w') as file:
#        file.write('\n'.join(key_features))
#    pprint.pprint(dict(label))
#    print('\n'.join(key_features))
#    print("Score : %s" % score)
#
#    return key_features


def setup_benchmark(project_dir):
    utils.execute("git clean -df", project_dir)
    utils.execute("git checkout -f", project_dir)


def scoring(learning_data, model):
    score = 0
    score2 = 0
    input_data = [patch["Encoding"] for patch in learning_data]
    result = model.predict(input_data)
    for i in range(len(input_data)):
        learning_data[i]["score"] = 1 - abs(result[i] -
                                            learning_data[i]["correctness"])
        score2 = score2 + learning_data[i]["score"]
        if learning_data[i]["score"] > 0.5:
            score = score + 1

    print("Score (classification) on learning data : %f" %
          float(score / len(learning_data)))
    print("Score (confidence)     on learning data : %f" %
          float(score2 / len(learning_data)))
    return learning_data


def capture(repo, metadata):
    repo_dir = f"{BENCH_DIR}/{repo}"
    data_dir = f"{LEARNING_DIR}/{repo}"

    repodata = metadata[repo]

    print(f" - compiling {repo}...")
    compile_cmd = utils.get_compile_command(repo_dir)
    ret_compile = utils.execute(
        f"infer capture --java-version {JAVA_VERSION} -- {compile_cmd}",
        repo_dir)

    if ret_compile.return_code is 0:
        repodata["infer-compiled"] = True
        shutil.move(f"{repo_dir}/infer-out", f"{data_dir}/infer-out")
    else:
        repodata["infer-compiled"] = False

    metadata[repo] = repodata
    utils.save_dict_to_jsonfile(METADATA, metadata.copy())


def preanal(repo, metadata):
    data_dir = f"{LEARNING_DIR}/{repo}"
    global_data = f"{data_dir}/infer-out/program.data"
    repodata = metadata[repo]

    if repodata["infer-compiled"] is False:
        return

    if is_done(repodata, "pre-analysis") and os.path.isfile(global_data):
        print(f" - found pre-analysis data for {repo}")
        return

    if repodata["LoC"] > MAXLOC:
        print(" - %s is too large ... %d" % (repo, repodata["LoC"]))
        return

    if os.path.isfile(global_data):
        os.remove(global_data)
        # os.remove(f"{data_dir}/infer-out/.preanalysis")

    print(f" - pre-analyze {repo}...")
    ret_compile = utils.execute(f"infer npex --pre-analysis-only", data_dir)
    # save LEARNING_DIR/REPO/infer-out/global.data

    if ret_compile.return_code is 0:
        repodata["pre-analysis"] = True
    else:
        repodata["pre-analysis"] = False

    metadata[repo] = repodata
    utils.save_dict_to_jsonfile(METADATA, metadata.copy())


def simple_analysis(repo):
    repo_dir = f"{BENCH_DIR}/{repo}"
    data_dir = f"{LEARNING_DIR}/{repo}"

    

def generate_marshal(patch: Dict):
    patch_dir = patch["patch_dir"]
    patch_id = patch["id"]
    marhsal_path = f"{patch_dir}/{FEATURE_PATH}"

    if is_done(patch, "marshalled") and os.path.isfile(marhsal_path):
        print(f" - found marshalled data for {patch_id}")
        return

    print(f" - generate marshalled data for {patch_id}")
    if os.path.isfile(marhsal_path):
        os.remove(f"{patch_dir}/infer-out/.preanalysis")
        os.remove(marhsal_path)

    if "deref_field" not in utils.read_json_from_file(f"{patch_dir}/npe.json"):
        print(f"   - No deref_field for {patch_id}")
        patch["marshalled"] = False
        patch["Features"] = False
        utils.save_dict_to_jsonfile(f"{patch_dir}/data.json", patch)
        return

    ret = utils.execute(
        "infer npex --key-features %s/empty_features" % ROOT_DIR, patch_dir)
    patch["marshalled"] = True if ret.return_code is 0 else False
    patch["Features"] = False
    utils.save_dict_to_jsonfile(f"{patch_dir}/data.json", patch)
    if patch['marshalled'] is False:
        print(f"   - Failed to generate marshalled data for {patch_id}")
    else:
        print(f"   - Successfully generate marshalled data for {patch_id}")


def extract_feature(patch_id: str, bugdata: Dict):
    repo, bug_name, patch_name = patch_id.split('/')
    bug_id = f"{repo}/{bug_name}"
    bug_data = bugdata[bug_id]
    patch_data = bug_data["patches"][patch_id]
    patch_dir = patch_data["patch_dir"]

    # if is_done(patch_data, "Features"):
    #     print(f" - found generated features for {patch_id}")
    #     return

    if os.path.isdir(f"{patch_dir}/program.data") is False:
        utils.execute(
            f"cp {LEARNING_DIR}/{repo}/infer-out/program.data {patch_dir}/program.data"
        )

    print(f" - extract features for {patch_id}")

    ret = utils.execute(f"infer npex -o {patch_dir}", patch_dir)
    if ret.return_code is 0:
        patch_data["Features"] = True
        print(f"   - Successfully extract features for {patch_id}")
    else:
        patch_data["Features"] = False
        print(f"   - Failed to extract features for {patch_id}")

    bugdata[bug_id] = bug_data
    #utils.save_dict_to_jsonfile(BUGDATA, bugdata.copy())


def generate_data(repo: str, metadata):
    repodata = metadata[repo]

    repo_dir = f"{BENCH_DIR}/{repo}"
    data_dir = f"{LEARNING_DIR}/{repo}"

    if not repodata["pass_testcase"] or not is_true("pre-analysis", repodata):
        print(f" - {repo} failed to pass testcase")
        return {}

    if os.path.isdir(f"{data_dir}/bugs"):
        utils.execute(f"rm -rf {data_dir}/bugs")
    
    spoon_cmd = f"java -cp {SYNTHESIZER} npex.Main -extbuggy {repo_dir}/ {LEARNING_DIR} -ternary"
    utils.execute(f"git checkout -f", repo_dir)
    ret_spoon = utils.execute(spoon_cmd, ROOT_DIR)
    ret = {}

    if ret_spoon.return_code is 0:
        print(f" - successfully generate buggy data for {repo}")
        repodata["generate_data"] = True
        bugdata = utils.read_json_from_file(BUGDATA) if os.path.isfile(
            BUGDATA) else {}

        
        bug_dirs = [
            dir for dir in glob.glob(f"{data_dir}/bugs/*")
            if os.path.isdir(dir)
        ]

        repodata["number_of_data"] = 0
        for bug_dir in bug_dirs:
            patch_dirs = [
                dir for dir in glob.glob(f"{bug_dir}/patches/*")
                if os.path.isdir(dir)
            ]  # bug_id/patch

            bug_id = f"{repo}/{os.path.basename(bug_dir)}"
            prev = bugdata[bug_id] if bug_id in bugdata else {"patches": {}}
            patches = prev["patches"]
            for patch_dir in patch_dirs:
                patch_id = f"{bug_id}/{os.path.basename(patch_dir)}"
                patches[patch_id] = {
                    "patch_id": patch_id,
                    "patch_dir": patch_dir,
                }
            ret[bug_id] = {
                **prev, "repo": repo,
                "bug_id": bug_id,
                "patches": patches
            }

            repodata["number_of_data"] = repodata["number_of_data"] + len(
                patch_dirs)
    else:
        repodata["generate_data"] = False
        print(f" - failed to generate {repo}")

    metadata[repo] = repodata
    utils.save_dict_to_jsonfile(METADATA, metadata.copy())
    return ret


def apply_and_test(original_filepath, patch_filepath, repo_dir):
    utils.execute(f"git checkout -f", repo_dir)
    utils.execute(f"cp {patch_filepath} {original_filepath}")
    return utils.execute("mvn test -Drat.skip", repo_dir, timeout=300)


def merge_jsonlist_and_save(filepath, jsonlist):
    data = {}
    for j in jsonlist:
        data = {**data, **j}
    utils.save_dict_to_jsonfile(filepath, data)


def find_test(bug_id, bugdata):
    bug = bugdata[bug_id]
    repo = bug["repo"]
    repo_dir = f"{BENCH_DIR}/{repo}"
    bug_dir = f"{LEARNING_DIR}/{repo}/bugs/" + bug_id.split('/')[-1]

    if os.path.isfile(f"{bug_dir}/patches/devel_patch/patch.json") is False:
        print(f" - no patch for {bug_id}")
        return

    if "has_testcase" in bug:
        print(f" - skip {bug_id}")
        return

    print(f" - test {bug_id}")

    original_filepath = utils.read_json_from_file(
        f"{bug_dir}/patches/devel_patch/patch.json")["original_filepath"]
    buggy_filepath = f"{bug_dir}/buggy.java"
    
    utils.execute(f"git checkout -f", repo_dir)
    ret_test = apply_and_test(f"{repo_dir}/{original_filepath}",
                              buggy_filepath, repo_dir)
    utils.execute(f"git checkout -f", repo_dir)
    
    bug["has_testcase"] = parse_error(ret_test.stdout.splitlines(), "test failures")
    bug["time_to_test"] = ret_test.time
    bugdata[bug_id] = bug

    utils.save_dict_to_jsonfile(BUGDATA, bugdata.copy())

    print(f" - finish {bug_id}")

def test_patch(repo, bugdata):
    repo_dir = f"{BENCH_DIR}/{repo}"
    for bug_id in bugdata.keys():
        if bugdata[bug_id]["repo"] != repo:
            continue

        bug_data = bugdata[bug_id]

        if is_true("has_testcase", bug_data) is False:
            print(f" - no test for {bug_id}")
            continue    

        patch_ids = list(bug_data["patches"].keys())

        for patch_id in patch_ids:
            patch_data = bug_data["patches"][patch_id]
            patch_dir = patch_data["patch_dir"]

            if patch_id.split('/')[-1] == "devel_patch":
                if os.path.isdir("{patch_dir}/{repo}"):
                    utils.execute("rm -rf {patch_dir}{repo}")
                patch_data["correctness"] = True
                bug_data["patches"][patch_id] = patch_data
                continue 

            print(f" - testing {patch_id}")

            original_filepath = utils.read_json_from_file(
                f"{patch_dir}/patch.json")["original_filepath"]
            buggy_filepath = f"{patch_dir}/patch.java"

            ret_test = apply_and_test(f"{repo_dir}/{original_filepath}",
                                buggy_filepath, repo_dir)
        
            if ret_test.return_code is 0:
                patch_data["correctness"] = True
            elif parse_error(ret_test.stdout.splitlines(), "AssertionError"):
                patch_data["ErrorType"] = "Assertion"
            elif parse_error(ret_test.stdout.splitlines(), "Compilation failure"):
                patch_data["ErrorType"] = "Compile"
            else: #TODO: error in test? code?
                patch_data["ErrorType"] = "RunTimeError"

            patch_data["ErrorInTest"] = check_error_in_test(repo_dir, bug_id.split('/')[-1])

            bug_data["patches"][patch_id] = patch_data
        bugdata[bug_id] = bug_data

    utils.save_dict_to_jsonfile(BUGDATA, bugdata.copy())



def get_patches(field: str, bugdata):
    patches = []
    for bug in bugdata:
        for patch_id in bugdata[bug]["patches"]:
            patch_data = bugdata[bug]["patches"][patch_id]
            # if field in patch_data: patches.append(patch_id)
            if field is None: patches.append(patch_id)
            elif is_true(field, patch_data): patches.append(patch_id)

    return patches


def read_features(patch: Dict):
    print(" - read features of %s" % patch["id"])
    patch_dir = patch["patch_dir"]
    patch["Features"] = utils.read_json_from_file(
        f"{patch_dir}/{FEATURE_PATH}")
    return patch


def get_repo_list(field, metadata):
    return [repo for repo in metadata if is_true(field, metadata[repo])]


if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument("--capture",
                        action='store_true',
                        default=False,
                        help="compile and capture benchmarks")
    parser.add_argument(
        "--buggy_data",
        action='store_true',
        default=False,
        help="generate buggy data by deleting existing null handling code")
    parser.add_argument("--find_test",
                        action='store_true',
                        default=False,
                        help="find oracle testcase for each bug")
    parser.add_argument("--test_patch",
                        action='store_true',
                        default=False,
                        help="test each patch")
    parser.add_argument("--pre",
                        action='store_true',
                        default=False,
                        help="perform pre-analysis for each projects")
    parser.add_argument("--marshal",
                        action='store_true',
                        default=False,
                        help="generate marshalling data for each patch")
    parser.add_argument("--feature",
                        action='store_true',
                        default=False,
                        help="extract features")
    parser.add_argument("--learning",
                        action='store_true',
                        default=False,
                        help="learning encoding and model")
    parser.add_argument("--n_cpus",
                        type=int,
                        default=20,
                        help="number of cpus")
    parser.add_argument("--validation_list",
                        nargs='+',
                        default=[],
                        help="list of validation")
    parser.add_argument("--repo_list",
                        nargs='+',
                        default=[],
                        help="list of repositories to learn")
    parser.add_argument("--re_analyze",
                        action='store_false',
                        default=True,
                        help="re-analyze")
    parser.add_argument("--print_graph",
                        action='store_true',
                        default=False,
                        help="print model")
    args = parser.parse_args()

    metadata = utils.read_json_from_file(METADATA)
    incremental = args.re_analyze

    p = Pool(args.n_cpus)

    repo_list = [repo for repo in args.repo_list]
    if repo_list == []:
        repo_list = get_repo_list("is_compiled", metadata)

    metadata = Manager().dict(metadata)

    if args.capture:
        p.starmap(capture, zip(repo_list, repeat(metadata)))

    if args.pre:
        p.starmap(preanal, zip(repo_list, repeat(metadata)))

    if args.buggy_data:
        bug_data_list = p.starmap(generate_data,
                                  zip(repo_list, repeat(metadata)))
        merge_jsonlist_and_save(BUGDATA, bug_data_list)

    bugdata = utils.read_json_from_file(BUGDATA)
    
    if args.find_test:
        bug_data = Manager().dict(bugdata)
        p.starmap(find_test, zip(bugdata.keys(), repeat(bug_data)))
        utils.save_dict_to_jsonfile(BUGDATA, bug_data.copy())

    if args.test_patch:
        bug_data = Manager().dict(bugdata)
        repo_list = get_repo_list("generate_data", metadata)
        p.starmap(test_patch, zip(repo_list, repeat(bug_data)))
        utils.save_dict_to_jsonfile(BUGDATA, bug_data.copy())

    if args.marshal:  # For Semantic feature, now skip
        patches = get_patches("id", repo_list)
        p.map(generate_marshal, patches)

    if args.feature:
        bugdata = Manager().dict(bugdata)
        patches = get_patches(None, bugdata.copy())
        print(patches)
        p.starmap(extract_feature, zip(patches, repeat(bugdata)))
        utils.save_dict_to_jsonfile(BUGDATA, bugdata.copy())

    if args.learning:
        patches = get_patches("Features", bugdata)
        data = Data(bugdata, patches)
        data.process()
        data.learn_and_print_tree()
        data.statistics()
        data.assiciation_rule_mining()
        data.score()

    if not (args.capture or args.pre or args.feature or args.learning
            or args.print_graph):
        print("no argument given")

    utils.save_dict_to_jsonfile(METADATA, metadata.copy())
'''
        patches_learning = []
        patches_validate = []
        patches = p.map(read_features, patches)
        for patch in patches:
            if patch["repo"] in args.validation_list:
                patches_validate.append(patch)
            else:
                patches_learning.append(patch)
        key_features = find_embedding(patches_learning)
        learning_data = [
            embed_data(patch, key_features) for patch in patches_learning
        ]
        model = learning_classifier(learning_data, model)
        save_model_to_file(model, model_filename)
        scoring(learning_data, model)
        validation_data = [
            embed_data(patch, key_features) for patch in patches_validate
        ]
        scoring(validation_data, model)
    if args.print_graph:
        model = get_model_from_file("model.pkl")
        print_model(model)
'''

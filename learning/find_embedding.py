import os, sys, glob
from sklearn.ensemble import RandomForestClassifier # type: ignore
from sklearn import tree # type: ignore
import pickle
from typing import List, Set, Dict, Tuple, Optional
import json
from easyprocess import EasyProcess # type: ignore
from easyprocess import EasyProcessError
import time
import argparse
from collections import defaultdict 

ROOT_DIR = os.getcwd() # NPEX_Data/.
model = tree.DecisionTreeClassifier()
FILE = "model.pkl" 
starttime = time.strftime("%m%d_%I%M", time.localtime())
log = "%s.log" % starttime
logfile = open("logs/" + log, 'w')
JAVA_VERSION = 8

def execute(cmd : str, dir):
    os.chdir(dir)
    ret = EasyProcess(cmd).call()
    err_msg = "=== Execute %s ===\n  * return_code : %d\n  * stdout : %s\n  * stderr : %s\n  * dir : %s\n" \
            % (cmd, ret.return_code, ret.stdout, ret.stderr, dir)
    logfile.write(err_msg)
    logfile.flush()

def get_compile_command():
    if os.path.isfile('pom.xml'):
        return 'mvn clean install -DskipTests'
    else:
        return "javac main.java" # for test

def find_file_path(filenames):
    # TODO: how to select NPE file?
    file_paths = []
    for file_name in filenames:
        file_paths.extend(glob.glob("**/%s" % file_name, recursive=True))
        
    return file_paths

def read_json_from_file(json_filename: str):
    json_file = open(json_filename, 'r')
    json_str = json_file.read()
    return json.loads(json_str)
   
def save_model_to_file(model, model_filename: str):
    model_file = open(model_filename, 'wb')
    pickle.dump(model, model_file)

def learning_classifier (data : List[Tuple[List[int], List[List[int]], List[List[int]]]], model):
    input_data = []
    labels = []
    for (program, patches, correctness) in data:
        for i in range(len(patches)):
            input_data.append(program + patches[i])
            labels.append(correctness[i])

    model.fit(input_data, labels) 
    return model

def generate_feature (original_json: Dict, patch_json: Dict):
    # Assume: orignal program is buggy version with updated testcases
    repo, commit_id = original_json["repo"], original_json["commit_id"] # 6-digit
    original_dir = "%s/benchmarks/%s/%s" % (ROOT_DIR, repo, commit_id)
    patch_dir = "%s/learning_data/%s/%s" % (ROOT_DIR, repo, commit_id)
    os.chdir (original_dir)
    if patch_json is None:
        execute ("infer capture --java-version %d -- %s" % (JAVA_VERSION, get_compile_command()), original_dir)
        execute ("infer npex --error-report %s/%s" % (patch_dir, "original_npe.json"), original_dir) 
    else:
        patch_filepath = "%s/%s" % (patch_dir, patch_json["patch_file"]) 
        patch_filename = os.path.basename(patch_filepath)
        #1. Apply patch to program (i.e., cp patch.java ...)
        file_to_apply_patch = patch_json["path_to_apply"]
        execute ("cp %s %s.backup" % (file_to_apply_patch, patch_filepath), original_dir) # backup
        execute ("cp %s %s" % (patch_filepath, file_to_apply_patch), original_dir)
        #2. Capture patch program (i.e., infer capture ...)
        execute ("infer capture --java-version %d -- %s" % (JAVA_VERSION, get_compile_command()), original_dir)
        #3. Analyze and generate features (i.e., infer npex ...)
        execute ("infer npex --error-report %s/%s" % (patch_dir, patch_json["npe_json"]), original_dir)
        execute ("mv %s.backup %s" % (patch_filepath, file_to_apply_patch), original_dir) # apply backup

    return read_json_from_file ("infer-out/generated_features.json")

def objective_function (embedded_data):
    # Label: BinaryVector(str) -> (Correct PatchID List, Incorrect PatchID List)
    label = defaultdict(lambda: ([], []))
    for patch in embedded_data:
        patch_id = str(patch["Id"])
        patch_vector = str(patch["Concatenated"])
        (correct_patches, incorrect_patches) = label[patch_vector]
        if patch["correctness"] is 1:
            label[patch_vector] = (correct_patches + [patch_id], incorrect_patches)
        else: 
            label[patch_vector] = (correct_patches, incorrect_patches + [patch_id])
    # Calculate objective function
    number_of_all_data = 0
    score1 = 0
    score2 = 0
    for k in label.keys():
        (correct_patches, incorrect_patches) = label[k]
        (number_of_correct, number_of_incorrect) = len(correct_patches), len(incorrect_patches)
        print("%s -> [%d, %d]" % (k, number_of_correct, number_of_incorrect)) 
        number_of_all_data = number_of_all_data + number_of_correct + number_of_incorrect
        score1 = abs(number_of_correct - number_of_incorrect) + score1
        score2 = (number_of_correct + number_of_incorrect) * (number_of_correct + number_of_incorrect)
    score : float = float(score1/number_of_all_data) - float(score2/(number_of_all_data * number_of_all_data))
    print(dict(label)) 
    print("Iteration of: %f" % score)
    return score

def embed_data (patch, key_features: List[str]):
    patch["Concatenated"] = [patch["OriginalFeatures"][k_feature] for k_feature in key_features] + [patch["Features"][k_feature] for k_feature in key_features] 

    return patch

def find_embedding (data: List):
    # Output
    key_features : List[str] = []
    
    features = data[0]["Features"].keys()
    score = objective_function ([embed_data(p, key_features) for p in data])
    for feature in features:
        key_features_appended = key_features + [feature]
        score_appended = objective_function ([embed_data(p, key_features_appended) for p in data])
        if score_appended > score:
            key_features.append(feature)
            score = score_appended

    print(key_features)
    print("Score : %s" % score)

    return key_features

def data_from_DB ():
    err_info_dirs = glob.glob("%s/learning_data/*/*" % ROOT_DIR)
    ret = [] 

    #TODO: parallelize
    for err_info_dir in err_info_dirs:
        original = read_json_from_file ("%s/original.json" % err_info_dir)
        original["Features"] = generate_feature (original, None)

        #TODO: add devel patch 
        patch_json_filepaths = glob.glob("%s/patch*[0-9].json" % err_info_dir)
        print (patch_json_filepaths)
        for patch_json_filepath in patch_json_filepaths:
            patch = read_json_from_file (patch_json_filepath) 
            patch["Features"] = generate_feature (original, patch)
            patch["OriginalFeatures"] = original["Features"] 
            patch["Id"] = "%s_%s_%s" % (original["repo"], original["commit_id"], patch["patch_file"])

            ret.append(patch)
    return ret

if __name__ == '__main__':
##  Data for testing
    data = data_from_DB()
    find_embedding(data)
    #filter = find_filter (data)
    #data = apply_filter (data, filter)
    model = learning_classifier (data, model) 
    save_model_to_file (model, FILE)
    #saver filter 


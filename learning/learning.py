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
import pprint

ROOT_DIR = os.getcwd() # NPEX_Data/.
model = tree.DecisionTreeRegressor()
model_filename = "model.pkl" 
starttime = time.strftime("%m%d_%I%M", time.localtime())
log = "%s.log" % starttime
if os.path.isdir("logs"):
    logfile = open("logs/" + log, 'w')
else:
    logfile = open(log, 'w')
JAVA_VERSION = 8

def execute(cmd : str, dir):
    os.chdir(dir)
    ret = EasyProcess(cmd).call()
    err_msg = "=== Execute %s ===\n  * return_code : %d\n  * stdout : %s\n  * stderr : %s\n  * dir : %s\n" \
            % (cmd, ret.return_code, ret.stdout, ret.stderr, dir)
    logfile.write(err_msg)
    logfile.flush()

def get_compile_command(cwd, project=None):
    if os.path.isfile(f'{cwd}/pom.xml'):
        if project is None:
            return 'mvn clean install -DskipTests' 
        else:
            ### To compile only partial projects, we need to compile whole projects at first.
            # Must compile with "clean", otherwise infer would not capture it.
            # -amd is more sound, but it takes more time 
            
            #execute ("mvn clean install -DskipTests", '.')
            #return 'mvn clean install -DskipTests --pl %s' % project
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

def learning_classifier (data : List[Dict], model):
    input_data = []
    labels = []
    for patch in data:
        input_data.append(patch["Encoding"])
        labels.append(patch["correctness"])

    model.fit(input_data, labels) 
    return model

def get_original_filepath(patch):
    if "path_to_apply" in patch:
        return patch["path_to_apply"]
    elif "original_filepath" in patch:
        return patch["original_filepath"]
    else:
        raise Exception ("Original filepath is not given")

def apply_patch_and_generate_feature (original_dir, patch, key_features=None):
    patch_dir = patch["patch_dir"]
    original_filepath = get_original_filepath(patch)
    patch_filepath = "%s/patch.java" % patch_dir
    project = original_filepath.split('/')[0] 

    #1. Apply patch to program (i.e., cp patch.java ...)
    execute ("cp %s %s.backup" % (original_filepath, patch_filepath), original_dir) # backup
    execute ("cp %s %s" % (patch_filepath, original_filepath), original_dir)

    #2. Capture patched program & Generate features
    execute ("infer capture --java-version %d -- %s" % (JAVA_VERSION, get_compile_command(original_dir, project)), original_dir)
    if key_features is None:
        execute ("infer npex --defuse-only --error-report %s/npe.json --patch-json %s/patch.json" % (patch_dir, patch_dir), original_dir)
    else:
        execute ("infer npex --defuse-only --error-report %s/npe.json --patch-json %s/patch.json --key-features %s" % (patch_dir, patch_dir, key_features), original_dir)
    
    #3. Backup origianl file
    execute ("mv %s.backup %s" % (patch_filepath, original_filepath), original_dir) # apply backup



def generate_feature (repo: str, commit_id: str, patch: Dict):
    # Assume: orignal program is buggy version with updated testcases
    original_dir = "%s/benchmarks/%s/%s" % (ROOT_DIR, repo, commit_id)
    data_dir = "%s/learning_data/%s/%s" % (ROOT_DIR, repo, commit_id)
    project = read_json_from_file("%s/original_npe.json" % data_dir)["filepath"].split('/')[0]
    os.chdir (original_dir)
    
    original_marshal_path = "%s/infer-out/.rawdata.marshalled" % original_dir

    if patch is None:
        data_marshal_path = "%s/.rawdata.marshalled" % data_dir
        if os.path.isfile ("%s" % data_marshal_path):
            print("   - Found marshalled data")
            execute ("cp %s %s" % (data_marshal_path, original_marshal_path), ROOT_DIR)
            execute ("infer npex", original_dir) 
        else: 
            execute ("infer capture --java-version %d -- %s" % (JAVA_VERSION, get_compile_command(original_dir, project)), original_dir)
            execute ("infer npex --defuse-only --error-report %s/%s" % (data_dir, "original_npe.json"), original_dir) 
        execute ("mv %s %s" % (original_marshal_path, data_marshal_path), ROOT_DIR)
    else:
        data_marshal_path = "%s/.rawdata.marshalled" % patch["patch_dir"] 
        if os.path.isfile ("%s" % data_marshal_path):
            print("   - Found marshalled data")
            execute ("cp %s %s" % (data_marshal_path, original_marshal_path), ROOT_DIR)
            execute ("infer npex", original_dir) 
        else:
            apply_patch_and_generate_feature (original_dir, patch)
        execute ("mv %s %s" % (original_marshal_path, data_marshal_path), ROOT_DIR)

    return read_json_from_file ("%s/infer-out/generated_features.json" % original_dir)

def objective_function (embedded_data):
    # Label: BinaryVector(str) -> (Correct PatchID List, Incorrect PatchID List)
    label = defaultdict(lambda: ([], []))
    for patch in embedded_data:
        patch_id = str(patch["Id"])
        patch_vector = str([int(x == True) for x in patch["Encoding"]])
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
        score2 = (number_of_correct + number_of_incorrect) * (number_of_correct + number_of_incorrect) + score2
    score : float = float(score1/number_of_all_data) - float(score2/(number_of_all_data * number_of_all_data))
    pprint.pprint(dict(label)) 
    print("Iteration of: %f" % score)
    return score

def embed_data (patch, key_features: List[str]):
    patch["Encoding"] = [patch["OriginalFeatures"][k_feature] for k_feature in key_features] + [patch["Features"][k_feature] for k_feature in key_features] 

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

    with open ("%s/learning/key_feautures" % ROOT_DIR, 'w') as file:
        file.write('\n'.join(key_features))
    print('\n'.join(key_features))
    print("Score : %s" % score)

    return key_features

def setup_benchmark(project_dir):
    os.chdir(project_dir)
    [repo, commit_id] = project_dir.split('/')[-2:]
    bug_data_filepath = "%s/data/%s_%s_npe.json" % (ROOT_DIR, repo, commit_id)
    if not (os.path.isfile (bug_data_filepath)):
        return
    bug_data = read_json_from_file (bug_data_filepath)
    buggy_files = bug_data[1]["buggy_files"]
    parent_commit = bug_data[0]["parent"].split('/')[-1]
    checkout_cmd = "git checkout %s -- %s" % (parent_commit, ' '.join(buggy_files))

    execute(checkout_cmd, project_dir)


def data_from_DB (delete_marshal):
    err_info_dirs = list(filter(lambda dir: os.path.isfile("%s/original_npe.json" % dir), \
         glob.glob("%s/learning_data/*/*" % ROOT_DIR)))
    ret = [] 

    print("Learning Data Found")
    pprint.pprint (err_info_dirs)
    for err_info_dir in err_info_dirs: 
        [repo, commit_id] = err_info_dir.split("/")[-2:]
        print("Doing %s_%s ..." % (repo, commit_id))

        original_dir = "%s/benchmarks/%s/%s" % (ROOT_DIR, repo, commit_id)
        setup_benchmark(original_dir)

        if delete_marshal and os.path.isfile("%s/.rawdata.marshalled" % err_info_dir):
            os.remove("%s/.rawdata.marshalled" % err_info_dir)
                
        if delete_marshal and os.path.isfile("%s/infer-out/.rawdata.marshalled" % original_dir):
            os.remove("%s/infer-out/.rawdata.marshalled" % err_info_dir)
        
        original_features = generate_feature (repo, commit_id, None)

        #TODO: add devel patch 
        for patch_dir in [ dir for dir in glob.glob("%s/*" % err_info_dir) if os.path.isdir(dir)]:
            print(" - patch %s ..." % os.path.basename(patch_dir))
            patch = read_json_from_file ("%s/patch.json" % patch_dir)
            patch["patch_dir"] = patch_dir
            patch["OriginalFeatures"] = original_features
            patch["Id"] = "%s_%s_%s" % (repo, commit_id, os.path.basename(patch_dir)) 
            
            if delete_marshal and os.path.isfile("%s/.rawdata.marshalled" % patch_dir):
                os.remove("%s/.rawdata.marshalled" % patch_dir)
            
            patch["Features"] = generate_feature (repo, commit_id, patch)

            ret.append(patch)
    return ret

def scoring (learning_data, model):
    score = 0
    score2 = 0
    input_data = [patch["Encoding"] for patch in learning_data]
    result = model.predict(input_data)
    for i in range(len(input_data)):
        learning_data[i]["score"] = 1 - abs(result[i] - learning_data[i]["correctness"]) 
        score2 = score2 + learning_data[i]["score"]
        if learning_data[i]["score"] > 0.5:
            score = score + 1

    print ("Score on learning data : %f" % float(score/len(learning_data)))
    print ("Score2 on learning data : %f" % score2/len(learning_data))
    return learning_data

if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument("--delete-marshal", type=bool, default=False, help="delete existing marshalled data")
    args = parser.parse_args()
    
    data = data_from_DB(args.delete_marshal)
    key_features = find_embedding(data)
    learning_data = [embed_data (patch, key_features) for patch in data]
    model = learning_classifier (learning_data, model) 
    save_model_to_file (model, model_filename)
    scoring (learning_data, model)


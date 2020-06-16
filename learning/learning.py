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
from multiprocessing import Process
from multiprocessing import Pool
import shutil
import copy

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
    if ret.return_code is not 0:
        logfile.write(err_msg)
        logfile.flush()
    return ret

def get_compile_command(cwd, project=None):
    if os.path.isfile(f'{cwd}/pom.xml'):
        if project is None:
            return 'mvn clean install -DskipTests -Drat.skip=true' 
        else:
            ### To compile only partial projects, we need to compile whole projects at first.
            # Must compile with "clean", otherwise infer would not capture it.
            # -amd is more sound, but it takes more time 
            
            #execute ("mvn clean install -DskipTests", '.')
            #return 'mvn clean install -DskipTests --pl %s' % project
            return 'mvn clean install -DskipTests -Drat.skip=true' 
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

def save_dict_to_jsonfile(json_filename: str, dict: Dict):
    json_file = open(json_filename, 'w')
    json_file.write(json.dumps(dict, indent=4))

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

def objective_function (embedded_data):
    # Label: BinaryVector(str) -> (Correct PatchID List, Incorrect PatchID List)
    label = defaultdict(lambda: ([], []))
    for patch in embedded_data:
        patch_id = str(patch["id"])
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

    print ("Score (classification) on learning data : %f" % float(score/len(learning_data)))
    print ("Score (confidence)     on learning data : %f" % float(score2/len(learning_data)))
    return learning_data

def compile_and_capture (data: Dict):
    original_dir = data["original_dir"]
    data_dir = data["data_dir"]

    os.chdir (original_dir)

    ret = None
    execute ("git clean -df", original_dir)
    if os.path.isdir ("infer-out"):
        shutil.rmtree("infer-out")

    if "original_filepath" in data:
        original_filepath = data["original_filepath"]           # relative filepath from project root 
        patch_filepath = "%s/patch.java" % data_dir    # absolute filepath

        # Apply patch to program (i.e., cp patch.java ...)
        execute ("cp %s %s.backup" % (original_filepath, patch_filepath), original_dir) # backup
        execute ("cp %s %s" % (patch_filepath, original_filepath), original_dir)
        
        ret = execute ("infer capture --java-version %d -- %s" % (JAVA_VERSION, get_compile_command(original_dir)), original_dir)
        
        # Backup origianl file
        execute ("mv %s.backup %s" % (patch_filepath, original_filepath), original_dir) # apply backup
        execute ("mv %s/infer-out %s" % (original_dir, data_dir), original_dir) # apply backup
    else:
        ret = execute ("infer capture --java-version %d -- %s" % (JAVA_VERSION, get_compile_command(original_dir)), original_dir)
        execute ("mv %s/infer-out %s" % (original_dir, data_dir), original_dir) # apply backup
    
    return ret


def capture (data: Dict): 
    original_dir = data["original_dir"] # benchmarks/repo/commit 
    err_info_dir = data["data_dir"]     # learning_data/repo/commit
    repo = data["repo"]
    commit_id = data["commit_id"]
    
    original_id = f"{repo}_{commit_id}"
    original_data = {**data, "id": original_id}

    setup_benchmark(original_dir)
    
    if os.path.isdir("%s/infer-out" % err_info_dir):
        shutil.rmtree("%s/infer-out" % err_info_dir)
    print(f" - compiling original {original_id}")

    try:
        original_data["captured"] = True if compile_and_capture(data).return_code is 0 else False
    except Exception:
        print ("Unexpected Error:", sys.exc_info()[0])
        original_data["captured"] = False 
    save_dict_to_jsonfile(f"{err_info_dir}/data.json", original_data)

    if original_data["captured"] is False:
        print(f"   - could not captured {original_id}")
        return
    #else: 
    #    print(f" - successfully captured {repo}{commit_id}")

    for patch_dir in [ dir for dir in glob.glob("%s/*" % err_info_dir) \
        if os.path.isdir(dir) and os.path.basename(dir) != "infer-out" and os.path.isfile(f"{dir}/patch.json")]:
        patch_json = read_json_from_file ("%s/patch.json" % patch_dir)
        patch_id = "%s_%s_%s" % (repo, commit_id, os.path.basename(patch_dir)) 
        patch = {**patch_json, **data, "data_dir": patch_dir, "id": patch_id}
        print(f" - compiling patch {patch_id}")
        
        if os.path.isdir("%s/infer-out" % patch_dir):
            shutil.rmtree("%s/infer-out" % patch_dir)

        try:
            patch["captured"] = True if compile_and_capture(patch).return_code is 0 else False 
        except Exception:
            patch["captured"] = False
        save_dict_to_jsonfile(f"{patch_dir}/data.json", patch)

        if patch["captured"] is False:
            print(f"   - could not captured {patch_id}")
        #else:
        #    print(f" - successfully captured {patch_id}")

def data_from_DB (repo_list):
    err_info_dirs = []
    print(repo_list)
    if repo_list is None:
        err_info_dirs = glob.glob("%s/learning_data/*/*" % ROOT_DIR)
    else:
        for repo in repo_list:
            err_info_dirs = err_info_dirs + glob.glob (f"{ROOT_DIR}/learning_data/{repo}/*")

    err_info_dirs = list(filter(lambda dir: os.path.isfile("%s/npe.json" % dir), err_info_dirs))

    ret = [] 

    print("Learning Data Found")
    pprint.pprint (err_info_dirs)
    for err_info_dir in err_info_dirs: 
        [repo, commit_id] = err_info_dir.split("/")[-2:]
        original_dir = f"{ROOT_DIR}/benchmarks/{repo}/{commit_id}"
        
        data = {"repo": repo, "commit_id": commit_id, "original_dir": original_dir, "data_dir": err_info_dir} 

        ret.append(data)
    return ret

def generate_marshal(patch: Dict):
    patch_dir = patch["data_dir"]
    patch_id = patch["id"]
    print(f" - generate marshalled data for {patch_id}")
    if os.path.isfile ("%s/infer-out/.rawdata.marshalled" % patch_dir):
        os.remove ("%s/infer-out/.rawdata.marshalled" % patch_dir)
    
    ret = execute ("infer npex --key-features %s/empty_features" % ROOT_DIR, patch_dir)
    patch["marshalled"] = True if ret.return_code is 0 else False
    save_dict_to_jsonfile(f"{patch_dir}/data.json", patch)
    if patch['marshalled'] is False:
        pass
    #    print ("   - Failed to generate marshalled data")
    else:
        print (f"   - Successfully generate marshalled data for {patch_id}")

def extract_feature(patch: Dict):
    patch_dir = patch["data_dir"]
    patch_id = patch["id"]
    print(" - extract features for %s" % patch["id"])
    
    execute ("infer npex", patch_dir)
    if os.path.isfile (f"{patch_dir}/infer-out/generated_features.json"):
        patch["Features"] = read_json_from_file (f"{patch_dir}/infer-out/generated_features.json")
        print(f"   - Successfully extract features for {patch_id}")
    else:
        print(f"   - Failed to extract features for {patch_id}")
    save_dict_to_jsonfile(f"{patch_dir}/data.json", patch)

def get_patches(field: str):
    json_paths = \
        glob.glob(f"{ROOT_DIR}/learning_data/*/*/data.json") + \
        glob.glob(f"{ROOT_DIR}/learning_data/*/*/*/data.json")  

    json_list = [read_json_from_file(json_path) for json_path in json_paths]
    return [data for data in json_list if data[field] is True]

if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument("--capture", type=bool, default=False, help="compile and capture benchmarks")
    parser.add_argument("--generate_marshal", type=bool, default=False, help="generate marshalling data")
    parser.add_argument("--extract_feature", type=bool, default=False, help="extract features")
    parser.add_argument("--learning", type=bool, default=False, help="learning encoding and model")
    parser.add_argument("--n_cpus", type=int, default=1, help="number of cpus")
    parser.add_argument("--repo_list", type=str, nargs='+', help="list of repositories to learn")
    args = parser.parse_args()

    data_list = data_from_DB(args.repo_list)
    
    p = Pool(args.n_cpus)
    
    if args.capture:
        p.map(capture, data_list)            

    elif args.generate_marshal:
        patches = get_patches("captured")
        p.map(generate_marshal, patches)

    elif args.extract_feature:
        patches = get_patches("marshalled")
        p.map(extract_feature, patches)

    elif args.learning:
        patches = [patch for patch in get_patches("marshalled") if "Features" in patch and os.path.isfile("%s/../data.json" % patch["data_dir"])]
        for patch in patches: 
            print (" - learning data %s" % patch["id"]) 
            patch_dir = patch["data_dir"]
            patch["OriginalFeatures"] = read_json_from_file (f"{patch_dir}/../data.json")["Features"]
        key_features = find_embedding(patches)
        learning_data = [embed_data (patch, key_features) for patch in patches] 
        model = learning_classifier (learning_data, model) 
        save_model_to_file (model, model_filename)
        scoring (learning_data, model)
    else:
        print ("no argument given")

    
import os, glob
import argparse
from easyprocess import EasyProcess
from easyprocess import EasyProcessError
from multiprocessing import Pool
from multiprocessing import Manager
import logging
import subprocess
import json
from functools import partial
from itertools import repeat

ROOT_DIR = os.getcwd()
    
def get_test_command(testClass, project):
    if os.path.isfile('pom.xml'):
        return 'mvn clean test -Dtest=%s -DfailIfNoTests=false' % testClass if project == 'src' \
        else 'mvn clean test -Dtest=%s --pl %s -amd -DfailIfNoTests=false' % (testClass, project) 
    elif os.path.isfile('maven.xml'):
        return 'maven clean test -Dtest=%s -DfailIfNoTests=false' % testClass
    else:
        return None

def find_NPE(bug_id, test_buggy_ret):
    test_buggy = test_buggy_ret.split('\n')
    try:
        test_buggy = test_buggy[test_buggy.index(" T E S T S"):]
    except ValueError:
        test_buggy = test_buggy[test_buggy.index("[INFO] BUILD FAILURE"):]
        for error_line in test_buggy:
            if 'cannot find symbol' in error_line:
                logger.warning(" - CANNOT FIND SYMBOL")
                logger.handlers[0].flush()
        return
    result_sentence = ''
    error_sentence_lines = []
    failure_sentence_lines = []
    for i in range(len(test_buggy)):
        if 'Tests run:' in test_buggy[i] and result_sentence == '':
            result_sentence = test_buggy[i]
            continue
        if '<<< ERROR!' in test_buggy[i]:
            error_sentence_lines.append(i)
            continue
        if '<<< FAILURE!' in test_buggy[i]:
            failure_sentence_lines.append(i)
            continue

    index_of_failures = result_sentence.find('Failures:') + 10
    index_of_errors = result_sentence.find('Errors:') + 8

    num_failures = int(result_sentence[index_of_failures:].split(',')[0])
    num_errors = int(result_sentence[index_of_errors:].split(',')[0])

    if num_failures != len(failure_sentence_lines) or num_errors != len(error_sentence_lines):
        print(" - parser has something wrong1")
        logger.warning(" - parser has something wrong1")
        logger.handlers[0].flush()
        return

    # collect buggy list(filename, line)
    buggy_list = {}
    for error_line in error_sentence_lines:
        if 'NullPointerException' in test_buggy[error_line+1]:
            buggy_file_line = test_buggy[error_line+2].split('(')[-1][:-1].split(':')
            if buggy_file_line[0] not in buggy_list:
                buggy_list[buggy_file_line[0]] = []
            buggy_list[buggy_file_line[0]].append(int(buggy_file_line[1])-1)
            buggy_list[buggy_file_line[0]].sort()
    for failure_line in failure_sentence_lines:
        if ('AssertionError' not in test_buggy[failure_line+1]) or ('Expected:' not in test_buggy[failure_line+2]) or ('but:' not in test_buggy[failure_line+3]):
            print(" - parser has something wrong2")
            logger.warning(" - parser has something wrong2")
            logger.handlers[0].flush()
            return
        if 'NullPointerException' in test_buggy[failure_line+4].split(':')[1][1:]:
            buggy_file_line = test_buggy[failure_line+5].split('(')[-1][:-1].split(':')
            if buggy_file_line[0] not in buggy_list:
                buggy_list[buggy_file_line[0]] = []
            buggy_list[buggy_file_line[0]].append(int(buggy_file_line[1])-1)
            buggy_list[buggy_file_line[0]].sort()
    
    return buggy_list

def where(index, rng):
    if index < rng[0]:
        return -1
    elif rng[0] < index < rng[1]:
        return 0
    else:
        return 1

def modify_code(buggy_list, ret):
    for buggy_filename in iter(buggy_list):
        for buggy_filepath in ret['buggy_files']:
            if buggy_filename in buggy_filepath:
                buggy_file_lines = []
                with open(buggy_filepath) as buggy_file:
                    buggy_file_lines = buggy_file.readlines()
                    modified = {}
                    for buggy_line in buggy_list[buggy_filename]:
                        result_sentence = []
                        buggy_sentence = buggy_file_lines[buggy_line].split('//')[0].split('/*')[0]
                        quote_index_list = [(0,0)]
                        doublequote_index_list = [(0,0)]
                        dot_index_list = [0]
                        done = [False, False, False]
                        while True:
                            if not done[0]:
                                quote_index = buggy_sentence.find("'", quote_index_list[-1][1]+1)
                                if quote_index == -1:
                                    quote_index_list.pop(0)
                                    done[0] = True
                                else:
                                    second_quote_index = buggy_sentence.find("'", quote_index+1)
                                    if second_quote_index == -1:
                                        print(" - parsing quote has problem")
                                        logger.warning(" - parsing quote has problem")
                                        logger.handlers[0].flush()
                                    quote_index_list.append((quote_index, second_quote_index))
                            
                            if not done[1]:
                                doublequote_index = buggy_sentence.find('"', doublequote_index_list[-1][1]+1)
                                if doublequote_index == -1:
                                    doublequote_index_list.pop(0)
                                    done[1] = True
                                else:
                                    second_doublequote_index = buggy_sentence.find('"', doublequote_index+1)
                                    if second_doublequote_index == -1:
                                        logger.warning(" - parsing quote has problem")
                                        logger.handlers[0].flush()
                                    doublequote_index_list.append((doublequote_index, second_doublequote_index))
                           
                            if not done[2]:
                                dot_index = buggy_sentence.find(".", dot_index_list[-1]+1)
                                if dot_index == -1:
                                    dot_index_list.pop(0)
                                    done[2] = True
                                else:
                                    dot_index_list.append(dot_index)
                            
                            if done == [True, True, True]: break
                        
                        check_quote = 0
                        check_doublequote = 0
                        in_quote = 0
                        tmp_index_list = dot_index_list.copy()
                        i = 0
                        while check_doublequote < len(doublequote_index_list) and i < len(dot_index_list):
                            if dot_index_list[i] < doublequote_index_list[check_quote][0]:
                                i += 1
                            elif doublequote_index_list[check_doublequote][0] < dot_index_list[i] < doublequote_index_list[check_doublequote][1]:
                                tmp_index_list.remove(dot_index_list[i])
                            else:
                                check_doublequote += 1

                        dotop_index_list = tmp_index_list.copy()
                        i = 0
                        while check_quote < len(quote_index_list) and i < len(tmp_index_list):
                            if tmp_index_list[i] < quote_index_list[check_quote][0]:
                                i += 1
                            elif quote_index_list[check_quote][0] < tmp_index_list[i] < quote_index_list[check_quote][1]:
                                dotop_index_list.remove(tmp_index_list[i])
                            else:
                                check_quote += 1
                        
                        modified_buggy_sentence = []
                        dotop_index_list.insert(0, 0)
                        dotop_index_list.append(len(buggy_sentence))
                        for i in range(1, len(dotop_index_list)):
                            modified_buggy_sentence.append(buggy_sentence[dotop_index_list[i-1]:dotop_index_list[i]].rstrip() + '\n')

                        modified[buggy_line] = modified_buggy_sentence
                    
                    moved = 0
                    for modify in sorted(modified):
                        buggy_file_lines.pop(modify+moved)
                        for exp in modified[modify]:
                            buggy_file_lines.insert(modify+moved, exp)
                            moved += 1
                        moved -= 1
                    
                    print(modified)
                
                with open(buggy_filepath, 'w') as buggy_file:
                    buggy_file.writelines(buggy_file_lines)

def find_exp(NPE_list, ret):
    NPE_exp_list = {}
    for NPE_filename in iter(NPE_list):
        for buggy_filepath in ret['buggy_files']:
            if NPE_filename in buggy_filepath:
                with open(buggy_filepath) as NPE_file:
                    NPE_file_line = NPE_file.readlines()
                    for NPE_line in NPE_list[NPE_filename]:
                        if NPE_filename not in NPE_exp_list:
                            NPE_exp_list[NPE_filename] = []
                        NPE_exp_list[NPE_filename].append(NPE_file_line[NPE_line].rstrip('\n'))

    return NPE_exp_list

#TODO: How it knows line of NPE in original file
def find_column(buggy_list, NPE_exp_list, ret):
    buggy_line_column_list = {}
    for buggy_file in iter(buggy_list):
        linelist = buggy_list[buggy_file]
        explist = NPE_exp_list[buggy_file]
        if len(linelist) != len(explist):
            logger.warning(" - XX")
            logger.handlers[0].flush()
        for buggy_filepath in ret['buggy_files']:
            if buggy_file in buggy_filepath:
                buggy_line_column_list[buggy_file] = []
                with open(buggy_filepath) as buggy:
                    buggy_file_line = buggy.readlines()
                    for i in range(len(linelist)):
                        col = buggy_file_line[linelist[i]].find(explist[i])+1
                        buggy_line_column_list[buggy_file].append({'line': linelist[i]+1, 'column': -100 if (col == 1) else col})
    return buggy_line_column_list


def testing(commit_filename, output):
    bug_id = commit_filename[:-9]
    commit_sha = bug_id[-7:-1]

    os.chdir(ROOT_DIR)
    with open('data/%s' % commit_filename) as commit_file:
        commit_json = json.loads(commit_file.read())
        commit = commit_json[0]
        rets = commit_json[1:]

        os.chdir(ROOT_DIR + '/benchmarks/%s/%s' % (commit['repo'], commit_sha))
        for ret in rets:
            checkout_cmd = 'git checkout %s -- %s' % (commit_sha, ' '.join(ret['buggy_files']))
            checkout_ret = EasyProcess(checkout_cmd).call()

            testclass = ret['test_file'].split('/')[-1].split('.')[0]
            test_cmd = get_test_command(testclass, ret['test_file'].split('/')[1])
            if test_cmd is None:
                logger.warning(" - not maven project")
                logger.handlers[0].flush()
                return

            test_fixed_ret = EasyProcess(test_cmd).call()
            if test_fixed_ret.return_code is not 0:
                logger.warning(" - not fixed")
                logger.handlers[0].flush()
                return
        
            checkout_cmd = 'git checkout %s -- %s' % (commit['parent'].split('/')[-1], ' '.join(ret['buggy_files']))
            checkout_ret = EasyProcess(checkout_cmd).call()

            test_buggy_ret = EasyProcess(test_cmd).call()
            if test_buggy_ret.return_code is 0:
                logger.warning(" - not buggy")
                logger.handlers[0].flush()
                return
            
            buggy_list = find_NPE(bug_id, test_buggy_ret.stdout)
            print(buggy_list)
            modify_code(buggy_list, ret)

            test_modify_ret = EasyProcess(test_cmd).call()
            if test_buggy_ret.return_code is 0:
                logger.warning(" - wrong modify")
                logger.handlers[0].flush()
                return
            NPE_list = find_NPE(bug_id, test_modify_ret.stdout)
            NPE_exp_list = find_exp(NPE_list, ret)
            print(NPE_exp_list)

            checkout_ret = EasyProcess(checkout_cmd).call()
            NPE_line_column = find_column(buggy_list, NPE_exp_list, ret)
            print(NPE_line_column)
            output[bug_id] = NPE_line_column
            
            
if __name__ == '__main__':
    logger = logging.getLogger()
    logger.setLevel(logging.INFO)
    formatter = logging.Formatter('[%(asctime)s/%(levelname)s]%(processName)s - %(message)s')
    file_handler = logging.FileHandler("logs/check_NPE.log")
    file_handler.setFormatter(formatter)
    logger.addHandler(file_handler)

    parser = argparse.ArgumentParser()
    parser.add_argument("--n_cpus", type=int, default=12, help="specify # of threads to use")
    parser.add_argument("--commit", type=str, default=None, help="specify a commit to test, default: all commits")
    args = parser.parse_args()
    n_cpus = args.n_cpus
    commit = args.commit

    ps = subprocess.Popen(('ls', 'data/'), stdout=subprocess.PIPE)
    output = subprocess.check_output(('grep', '_npe.json'), stdin=ps.stdout, universal_newlines=True)
    ps.wait()
    npe_commits = output.split('\n')[:-1]
    print(npe_commits)

    output = Manager().dict()
    with Pool(n_cpus) as p:
        p.starmap(testing, zip(npe_commits, repeat(output)))

    with open(ROOT_DIR + '/data/NPE.json', 'w') as jsonfile:
        jsonfile.write(json.dumps(output.copy(), sort_keys=True))
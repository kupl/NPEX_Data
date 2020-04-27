WorkFlow
1. Collect Repository of Apache
   * input: ()	
   * output: repo.txt
   * crawl_repos.py

2. Collect NPE-fix commits
   * input: repo.txt
   * output: data/REPO_data.json
     * crawl_commits.py: data/REPO.json
       * get commit info
     * generate_bug_data.py: data/REPO_data.json
       * get file patch log for each commit info

3. Clone & Compile
   * input: data/REPO_data.json
   * output: data/REPO_COMMIT.json
     * fixed?
     * compiled?
     * nullPoint
   * collect commit with testcase (by searching): data/REPO_test.json
     * CLASS_test.java
     * pom.xml
   * collect commit with MAY effective testcase (by executing): data/REPO_effective.json
     * do not pass original testcases

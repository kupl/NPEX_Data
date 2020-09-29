WorkFlow
1. Collect Repository of Apache
   * input: ()	
   * output: repo.txt
   * script: crawl_repos.py
   * REQUIREMENTS:
     * Maven2 Projects
     * Not too big (e.g., hadoop, hbase)

2. Collect NPE-fix commits
   * input: repo.txt
   * output: data/REPO_data.json
     * crawl_commits.py: data/REPO.json
       * get commit info
     * generate_bug_data.py: data/REPO_data.json
       * get file patch log for each commit info
   * REQUIREMENTS:
     * Maven2 Projects
     * Testcases should be commited at the same commit

3. Clone & Compile
   * input: data/REPO_data.json
   * output: data/REPO_COMMIT_npe.json
     * An effective testcase that pass fixed & fail buggy version.
     * Changed files except testcases.

4. Find a NPE, patch file, testcase
   * input: data/REPO_COMMIT_npe.json
   * output: NPE and DEVEL patch
     * npe.json
       * filepath
       * line
       * deref_field (last null pointer field)
       * entry (method name)
     * devel_patch
       * npe.json   (* currently, it is obtained manually *)
       * patch.json
         * original_filepath (relative filepath)
         * patched_lines (line list)
         * correctness (1: fixed, 0: failed)
       * patch.java (* currently, it is selected by deleting Tests in testfile name *)

5. Generate Patches
    * input: project, npe.json
    * output: patch list
      * npe.json, patch.java, patch.json

6. Learning a encoder & verifier
  * Compile & Capture
    * input: project, patch
    * output: captured info (i.e., infer-out)
  * Generate Marshalling
    * input: captured info, npe.json, patch.json 
    * output: marshalled data
  * Extract Features
    * input: marshalled data
    * output: json (feature -> bool) 
  * Learning
    * input: feature * label
    * output: key_features * model

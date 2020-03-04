class Solution {
    /*
    Candidates should be sorted. 
    Iterate through candidates and try to create the target using the candidate and all candidates that follow. 
    If the target can be created, continue trying to use the successful combination of targets and all candidates that follow to create the target.
    If current candidate and all following candidates are exhausted, move on to the next one.
    */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        // if there are no candidates, then the target cannot be created
        if (candidates.length == 0) return res;
        
        Arrays.sort(candidates);
        
        // if the first candidate is larger than the target, the target cannot be created
        if (candidates[0] > target) return res;
        
        // outer for loop is the index of the first value in the current list of candidates
        // inner for loop is to iterate through the candidates from the outer loop's index outwards
        int i = 0, sum = 0;
        for (int j = i; j < candidates.length(); j++) {
            List<Integer> cans = new LinkedList<>();
            int k = j;
            for (l; l < candidates.length(); l++) {
                if (candidates[k] + sum < target) {
                    
                }
            }
        }
    }
}
class Solution {
    /*
    My initial thought process is we sort the array into ascending order, then iterate up the list, checking to see if the current
    difference is less than the previous difference. This makes the algorithm at least O(nlgn) b/c sort. Iterating up the array
    does not add any time complexity greater than the sort, but I'm afraid there is a better time complexity.
    */
    
    // Faster than 87.52%
    // Less than 100%
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int len = arr.length;
        List<List<Integer>> res = new LinkedList<>();
        
        // If the array is of length 2 (minimum of the problem), then automatically return the difference.
        // Integers are distinct so difference must be at least 1 - might be a good exit condition to check for
        if (len == 2) {
            res.add(Arrays.asList(Math.min(arr[0], arr[1]), Math.max(arr[0], arr[1])));
            return res;
        }
        
        // Sort the array in ascending order
        Arrays.sort(arr);
        
        // Set initial diff as the first difference in array and presumptuously add first two values to res
        int minDiff = arr[1] - arr[0], currDiff = 0;
        res.add(Arrays.asList(arr[0], arr[1]));
        
        for (int i = 2; i < len; i++) {
            currDiff = arr[i] - arr[i-1]; 
            
            // If we found a new min difference, then clear the result list, make new minDiff, and add the elements to res.
            if (currDiff < minDiff) {
                res.clear();
                minDiff = arr[i] - arr[i-1];
                res.add(Arrays.asList(arr[i-1], arr[i]));
            }
            
            // If diffs are equal, then add the elements to res.
            else if (currDiff == minDiff) {
                res.add(Arrays.asList(arr[i-1], arr[i]));
            }
        }
        return res;
    }

    // Removed the early exit condition. Sped up the algorithm considerably from 84% - 99%. 
    // Faster than 99%
    // Less than 100%
    public List<List<Integer>> minimumAbsDifference1(int[] arr) {
        int len = arr.length;
        List<List<Integer>> res = new LinkedList<>();
        
        // Sort the array in ascending order
        Arrays.sort(arr);
        
        int minDiff = Integer.MAX_VALUE, currDiff = 0;
        
        for (int i = 1; i < len; i++) {
            currDiff = arr[i] - arr[i-1]; 
            
            // If we found a new min difference, then clear the result list, make new minDiff, and add the elements to res.
            if (currDiff < minDiff) {
                res.clear();
                minDiff = arr[i] - arr[i-1];
                res.add(Arrays.asList(arr[i-1], arr[i]));
            }
            
            // If diffs are equal, then add the elements to res.
            else if (currDiff == minDiff) {
                res.add(Arrays.asList(arr[i-1], arr[i]));
            }
        }
        return res;
    }
}
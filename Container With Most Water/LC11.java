class Solution {
    /* 
    Trying to make two optimizations: height and width - trying to optimize something that is a function
    of these two components. Height is the number at the index. Width is the distance between the indices.
    Could this be an O(n^2) implementation? Keep track of a matrix where i is the current index and j is the index
    of all the other numbers and dp[i][j] = area. (this implies dp[i][i] is empty)
    */
    
    // This passes the sample code test but it exceeds the memory limit because it's storing the dp table
    public int maxArea(int[] height) {
        int len = height.length;
        if (len == 2) return Math.min(height[0],height[1]);
        
        int[][] dp = new int[len][len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = Math.abs(i-j) * Math.min(height[i], height[j]);
                if (dp[i][j] > max) max = dp[i][j];
            }
        }
        return max;
    }
}
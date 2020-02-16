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

    // Need to find a way to not store the dp table
    // Maybe store it in a temp variable to comapare?
    // Faster than 5% - 813ms
    // Less than 7.69%
    public int maxArea2(int[] height) {
        int len = height.length;
        
        int max = 0, currMax = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                currMax = Math.abs(i-j) * Math.min(height[i], height[j]);
                if (currMax > max) max = currMax;
            }
        }
        return max;
    }

    // Tried getting rid of the if statement
    // Faster than 5%  - 758ms
    // Less than 7.69%
    // Only marginal performance improvement - problem must be with one of the for loops - performance should be under O(n*n)
    public int maxArea3(int[] height) {
        int len = height.length;
        
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                max = Math.max(max, Math.abs(i-j) * Math.min(height[i], height[j]));
            }
        }
        return max;
    }

    // Set limit of i for j b/c we were doing redundant work before
    // Faster than 6.52%  - 395ms
    // Less than 5.77%
    // Again only marginal improvement - need to get rid of one of the for loops
    public int maxArea4(int[] height) {
        int len = height.length;
        
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                max = Math.max(max, Math.abs(i-j) * Math.min(height[i], height[j]));
            }
        }
        return max;
    }

    /*
    FASTEST SOLUTION
    General idea is that if a bucket of water is going to be less wide (inidices are closer to each other) then
    the only way that the volume of water can get larger is if the bucket gets taller; thus, we have to iterate
    the index that is smaller of the two edges to see if we can get an index that's taller. Leads to O(N) solution.
    */
    // Faster than 95.73% - 2ms
    // Less than 5.77%
    public int maxArea5(int[] height) {
        int i = 0, j = height.length - 1, max = 0;
        while (i < j) {
            max = Math.max(max, (j-i) * Math.min(height[i], height[j]));
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return max;
    }
}


class Solution {
    /*
    At each step, can always take at least one step unless at the top. Basically just like the rodcutting problem.
    */
    // Faster than 100%
    // Less than 5.26%
    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 1; i < n; i++) {
            if (i > 1) {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n-1];
    }
}
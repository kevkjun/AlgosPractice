class Solution {
    // Faster than 83.04%
    // Less than 5.33%
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        
        // create the DP array and fill all the slots with huge integers - we want to find the min value
        int dp[] = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        /*
        For each coin, the lowest number of ways that we can make that change is the coin itself. That's why the
        inner loop starts from coin and iterates up to amount + 1. At each stage, we check to see if we were able
        to make change for the previous amount using previously used coins. If not, then we move on. If we were able,
        we take the "fastest" way to get there (i.e. the least amount of coins).
        */
        for (int coin : coins) {
            for (int i = coin; i < amount + 1; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
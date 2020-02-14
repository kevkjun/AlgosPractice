class Solution {
    // Classic DP problem that was actually part of the homework for Algos
    // The max profit of Day 1 is 0
    // The max profit of Day 2 is max (Day 1 max profit, Day 2 price - min price of previous days)
    // Faster than 80.13%
    // Less than 5.31%
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        else if (len == 1) return 0;
        
        // Create an array to keep track of previous profits for those days
        int[] memo = new int[len];
        // First profit is 0
        memo[0] = 0;
        // The min price so far is the price on the first day
        int min = prices[0];
        
        // The max profit for current day is the max (max profit of previous day, today's price - min price seen)
        for (int i = 1; i < len; i++) {
            memo[i] = Math.max(memo[i-1], prices[i] - min);
            min = Math.min(min, prices[i]);
        } 
        return memo[len-1];
    }

    // Can be done using Kadane's Algorithm which solves the max subarray problem
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/39038/Kadane's-Algorithm-Since-no-one-has-mentioned-about-this-so-far-%3A)-(In-case-if-interviewer-twists-the-input)
}
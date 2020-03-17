class Solution {
    // Faster than 92%
    // Less than 5%
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1])
                res += prices[i] - prices[i-1];
        }
        return res;
    }
}
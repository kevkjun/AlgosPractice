class Solution {
    // Simple idea: Just mod by 10 and find the prod and sum. After each iteration, divide i/10 until it reaches 0
    // Faster than 100%
    // Less than 100%
    public int subtractProductAndSum(int n) {
        int prod = 1, sum = 0, tmp = 0;
        for (int i = n; i > 0; i /= 10) {
            tmp = i % 10;
            prod *= tmp;
            sum += tmp;
        }
        return prod - sum;
    }
}
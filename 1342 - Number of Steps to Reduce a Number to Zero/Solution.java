class Solution {
    // Need the base case where the num == 0 or it runs recursively forever
    // Faster than 100%
    // Less than 100%
    public int numberOfSteps (int num) {
        if (num == 0) return 0;
        return 1 + (num % 2 == 0 ? numberOfSteps(num/2) : numberOfSteps(num - 1));
    }
}
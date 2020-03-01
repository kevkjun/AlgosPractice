class Solution {
    // Faster than 95%
    // Less than 100%
    public int findNumbers(int[] nums) {
        if (nums.length == 0) return 0;
        int sum = 0, count = 0;
        
        for (int num : nums) {
            for (int i = num; i > 0; i /= 10) {
                count++;
            }
            if (count % 2 == 0) sum++;
            count = 0;
        }
        return sum;
    }
}
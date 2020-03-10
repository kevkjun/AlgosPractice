class Solution {
    /*
    DP problem. Need to skip one house between each house we decide to rob.
    Create a memo array and prefer Math.max(current value + max value two items ago, max value one item ago).
    Edge cases:
        - nums is empty: return 0
        - nums only has one element: return the element
        - nums has two elements: return the max of the two
    */
    // Faster than 100%
    // Less than 5%
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            res[i] = Math.max(nums[i] + res[i-2], res[i-1]);
        }
        return res[nums.length - 1];
    }
}
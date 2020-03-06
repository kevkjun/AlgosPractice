class Solution {
    /*
    Voting algorithm:
        Keep track of the current majority.
        Has a counter that increases if the current majority is seen and decreases if different element is seen.
        If the counter drops below zero, the element just seen is the new majority.
        
    Edge cases: (pretend assumptions don't exist)
        (1) If empty, return -1
        (2) If counter is zero, return -1
        
    0, 1, 2, 1, 2, 1, 2, 1, 1
    1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 1, 1, 1
    */
    // Faster than 99%
    // Less than 70%
    public int majorityElement(int[] nums) {
        if (nums.length == 0) return -1;
        int counter = 0, majority = Integer.MAX_VALUE;
        
        for (int num : nums) {
            if (counter == 0) {
                majority = num;
            }
            count += (majority == num) ? 1 : -1;
        }
        if (counter == 0) return -1;
        return majority;
    }
}
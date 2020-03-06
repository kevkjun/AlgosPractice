class Solution {
    /*
    Two pointers: 
        (1) Moves through the array one item at a time, looking for zeroes
        (2) Moves through the array looking for non-zero items and replaces the current zero item at first pointer's index (i) with the non-zero item (j)
    Complexity should be O(n) because when second pointer reaches end of array, advance first pointer to end.
    
    Edge cases:
        - if nums is empty, then just return
    */
    // Faster than 100%
    // Less than 5%
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) return;
        int i = 0;
        int j = 1;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                while (j < nums.length && i < nums.length) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        i++;
                    }
                    j++;
                }
            }
            else j++;
        }
    }
}
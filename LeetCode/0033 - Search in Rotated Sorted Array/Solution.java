class Solution {
    // Faster than 100% 
    // Less than 47.17%
    
    // Definitely need to redo this and do it more slowly - required a lot of thinking and drawing
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        return searchHelper(nums, 0, nums.length -1, target);
    }
    
    public int searchHelper(int[] nums, int l, int r, int target) {
        int m = (l + r)/2;
        if (nums[m] == target) return m;
        if (m == l || m == r) return nums[l] == target ? l : (nums[r] == target ? r : -1);
        // If you land on the pivot (largest value) or to the right of the pivot (smallest value)
        if (nums[m] > nums[m+1] || nums[m] < nums[m-1]) {
            if (target <= nums[r]) return searchHelper(nums, m+1, r, target);
            return searchHelper(nums, l, m-1, target);
        }
        // Don't land on the pivot
        else {
            // If it's not rotated then it becomes regular binary search
            if (nums[l] < nums[r]) {
                if (nums[m] < target) return searchHelper(nums, m+1, r, target);
                return searchHelper(nums, l, m-1, target);
            }
            // If it is rotated then the rightmost number must be less than the leftmost number
            // If middle number is less than target
            if (nums[m] < target) {
                // If the middle value is larger than the leftmost value 
                // 2 3 4 *5* 6 7 0 1
                if (nums[m] > nums[l]) return searchHelper(nums, m+1, r, target);
                // Middle value is smaller
                // 6 7 0 *1* 2 3 4 5
                if (nums[m] < nums[l]) {
                    if (nums[l] <= target) return searchHelper(nums, l, m-1, target);
                    return searchHelper(nums, m+1, r, target);
                }
            }
            // If middle value is smaller than rigthtmost value
            if (nums[m] < nums[r]) return searchHelper(nums, l, m-1, target);
            // If middle value is larger than rightmost value
            if (nums[r] >= target) return searchHelper(nums, m+1, r, target);
            return searchHelper(nums, l, m-1, target);
        }
    }
}
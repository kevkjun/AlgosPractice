class Solution {
    // Faster than 100%
    // Less than 100%
    public int findMin(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return findMinHelper(nums, 0, nums.length -1);
    }
    
    // Just like searching in a rotated sorted array - need to check relative position with the ends of the array to search in the right half of the array or return if min value is known
    public int findMinHelper(int[] nums, int l, int r) {
        int m = (l + r)/2;
        // Immediate return if hit base case or can deduce we have hit the minimum value
        // If the array is rotated, then the minimum value must be next to the largest value
        if (m == l || m == r) return Math.min(nums[l], nums[r]);
        if (nums[m] < nums[m-1]) return nums[m];
        if (nums[m] > nums[m+1]) return nums[m+1];
        
        // If we have not found the pivot, then recurse on the half of the array that has smaller values
        if (nums[m] < nums[m+1] && nums[m+1] > nums[r]) return findMinHelper(nums, m+1, r);
        else return findMinHelper(nums,l, m-1);
    }
}
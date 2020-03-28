class Solution {
    /*
    Iterate through the arrays and put the smaller value in nums1. 
    Start from the end of nums1 because told that nums1 is at least as big as m+n so there will be empty slots at the end of nums1.
    */
    // Faster than 100%
    // Less than 5%
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // pointers for the elements in nums1 and nums2 (non-empty slots)
        int i = m-1;
        int j = n-1;
        
        // pointer into nums1 array
        int p = m + n - 1;
        
        while (i > -1 && j > -1) {
            if (nums1[i] > nums2[j]) {
                nums1[p--] = nums1[i--];
            }
            else 
                nums1[p--] = nums2[j--];
        }
        
        // if there are numbers leftover that haven't been written to nums1 from nums2
        while (j > -1) {
            nums1[p--] = nums2[j--];
        }
    }
}
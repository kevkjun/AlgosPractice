class Solution {
    // Naive solution - O(n^2)
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ret = new int[len];
        for (int i = 0; i < len; i++) {
            int mult = 1;
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                mult *= nums[j];
            }
            ret[i] = mult;
        }
        return ret;
    }

    /* 
    - Can think of splitting the array - a left half and a right half - around the index that we're concerned with
    - Moving to the right through the array, calculate the multiplication of the left of the index we're on as the initial value in the return array
    - At this point, we have the multiplication of all the values to the left of the index stored in the return array
    - Need to then multiply that with all the values on the right of the index
    - Do this by moving to the left through the array
    - Can do this using O(1) space by just tracking a value "right"
    - This means we have to iterate through the array twice - O(2N) = O(N)
    */
    
    // Faster than 100%
    // Less than 5.51%
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = nums[i-1] * res[i-1];
        }
        int right = 1;
        for (int i = len-1; i > -1; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
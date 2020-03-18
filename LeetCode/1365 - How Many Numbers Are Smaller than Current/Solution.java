class Solution {
    /*
    There is a constraint on the numbers in the array: 0 <= nums[i] <= 100. This makes this problem doable in linear time. 
    
    Basic idea is counting sort: providing some sort of sort function in linear time. Create an array and iterate through all the numbers and mark how 
    many times they occur in the array. Then, create a return array and iterate through the previously created array and sum up the values to the
    right of that array (marking how many times a number lesser than that number appears in the original array).
    */
    // Faster than 99%
    // Less than 100%
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int[] res = new int[nums.length];
        
        int max = 0; // the max number in nums
        // iterate through the numbers and mark how often they appear 
        for (int num : nums) {
            if (num > max) max = num;
            count[num]++;
        }
        // iterate through the count of numbers and make the number one greater than that number = to the count of numbers plus the count of numbers less
        for (int i = 1; i < max+1; i++) {
            count[i] += count[i-1]; 
        }
        // find the corresponding count of lesser numbers by looking to the left of the required number and insert it into res
        for (int i = 0; i < nums.length; i++) {
            // if the number is 0 then there are no numbers less than it - edge case because we are iterating from 0
            if (nums[i] == 0) 
                res[i] = 0;
            // look to the left of the current number to see the count of numbers less than that
            else
                res[i] = count[nums[i] - 1];
        }
        return res;
    }
}
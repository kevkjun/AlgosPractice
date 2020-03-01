class Solution {
    /*
    Discrete math solution: For array of n distinct numbers from 0, 1, 2,...,n the sum of the array is
    (n*(n+1))/2. Just take this sum and subtract all numbers from array. Will then be left with the one 
    number that wasn't subtracted.
    */
    
    // Faster than 100%
    // Less than 5%
    public int missingNumber(int[] nums) {
        int sum = (nums.length * (nums.length + 1))/2;
        for (int num : nums) 
            sum -= num;
        return sum;
    }
}
class Solution {
    /*
    We know that all elements of the list are <= the number of elements in the list. So for array of 10 elements, the largest
    an element could be is 10. This is very important. Because we know the bounds of the numbers in the array are <= size of array,
    we can use the numbers are indices into the array.
    
    For each num that we see as we iterate through the array, go to the index associated with (num - 1) and see if number at that index
    is negative. If no, then make it negative. If yes, then add num to list of duplicate numbers.
    */
    
    // Faster than 96%
    // Less than 36%
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new LinkedList<>();
        
        // Iterate through the numbers and turn the appropriate indices to negative
        // Need to take the absolute value of the number because it could have been turned negative before
        for (int num : nums) {
            int absNum = Math.abs(num);
            if (nums[absNum - 1] < 0) res.add(absNum);
            else 
                nums[absNum - 1] = -nums[absNum - 1];
        }
        return res;
    }
}
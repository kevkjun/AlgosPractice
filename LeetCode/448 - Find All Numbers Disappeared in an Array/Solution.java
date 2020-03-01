class Solution {
    /*
    Make an array of size n. For each num in the array, go to index num - 1 and make associated number negative. Once finished iterating 
    array, iterate through array one more time and add index + 1 to res if the element is negative.
    
    This works because we know that all elements in array are <= size of array so we know that each element can act as an index into the
    array. By making the number associated to the index of (num - 1) negative, we are signifying that we have seen the index (num - 1). 
    */
    
    // Faster than 89%
    // Less than 32%
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new LinkedList<>();
        
        // Iterate through the array and change the associated index (Math.abs(num) - 1) to negative if it is positive. 
        for (int num : nums) {
            int absNum = Math.abs(num);
            if (nums[absNum - 1] > 0) 
                nums[absNum - 1] = -nums[absNum - 1];
        }
        
        // Add the index + 1 to res if number is positive
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) res.add(i + 1);
        }
        return res;
    }
}
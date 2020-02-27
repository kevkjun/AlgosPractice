class Solution {
    /* General idea is to reduce this down to a 2Sum problem 
       Need to sort the array - O(nlgn) - then iterate through the array n times for each member to see if a triplet can be made
       By subtracting the current number from 0, we are seeing if the sum of the lowest possible number (the number directly to the right of current index)
       and the highest possible number (last number) equal that subtraction from 0. If true, then the addition of those
       three numbers would equal 0.
       */
    
    // Faster than 97.07%
    // Less than 96.47%
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < len-2; i++) {
            
            // Need to make sure that we're skipping identical elements to make sure we have unique triplets
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                
                // This is where we are reducing this problem down to a 2Sum problem
                // "sum" acts as the key into the map in the 2Sum problem
                int low = i+1, high = len-1, sum = 0 - nums[i];
                
                // This is the factor that make the algorithm O(n*n)
                // We are looping through all possible triplets for each value in the array
                while (low < high) {
                    
                    //Check if low and high can make "sum"
                    if (nums[low] + nums[high] == sum) {
                        res.add(Arrays.asList(nums[low], nums[high], nums[i]));

                        //Need to continuously iterate through the array until the low and high index numbers aren't 
                        //identical to the one that we just used - make sure that we are getting unique triplets
                        while (low < high && nums[low] == nums[low+1])
                            low++;
                        while (low < high && nums[high] == nums[high-1])
                            high--;
                        low++;
                        high--;
                    }
                    //If low and high index numbers are greater than sum then need to move high index down
                    else if (nums[low] + nums[high] > sum)
                        high--;
                    //If low and high index are less than sum then need to move low index up
                    else
                        low++;
                }
            }
        }
        return res;
    }
}
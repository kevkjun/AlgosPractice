class Solution {
    // Faster than 99.91% speed
    // Less than 5.65% memory
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) 
                return new int[] {map.get(nums[i]), i};
            map.put(target - nums[i], i);
        }
        // fake return value which will never get triggered if there is always a solution
        // require this to compile
        return new int[] {-1,-1};
    }
}
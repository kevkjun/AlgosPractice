class Solution {
    /*
    Create a HashMap that has all the elements of the array with lesser length and their counts.
    Iterate through the other array, checking if the element is present in the HashMap. 
    
    This answer changes the shorter array (nums1) because we will be updating the shorter array to contain the intersection 
    from index 0 to k of nums 1 (number of intersection points).
    */
    public int[] intersect(int[] nums1, int[] nums2) {
        // We want the smaller array to be first so that we can put that one into the HashMap
        if (nums1.length > nums2.length) return intersect(nums2, nums1);
        
        // Populate the map with the elements of nums1 and the number of times it appears
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums1)
            map.put(n, map.getOrDefault(n, 0) + 1);
        
        // Iterate through the values in the larger array (nums2) and place the value in nums1 if it's in the map
        // Decrement the count in the map if placed in the array
        int k = 0;
        for (int n : nums2) {
            int cnt = map.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k++] = n;
                map.put(n, cnt - 1);
            }
        }
        
        // Return the array (copyOfRange is exclusive for the ending index)
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
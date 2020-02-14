class Solution {
    // Simple solution: see if set contains the number. if yes, return true; if not, put it in the set for later comparison
    // Faster than 61.38%
    // Less than 5.17%
    
    // Adding final made it much faster:
    // Faster than 79.56%
    // Less than 5.17%
    public boolean containsDuplicate(int[] nums) {
        final Set<Integer> set = new HashSet<Integer>();
        
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
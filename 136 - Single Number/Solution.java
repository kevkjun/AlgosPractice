class Solution {
    /*
    Taking the XOR of all the numbers will leave you the one that wasn't repeated.
    a^b^a = (a^a)^b = 0 ^ b = b
    */
    
    // Faster than 100%
    // Less than 51%
    public int singleNumber(int[] nums) {
        int i = 0;
        for (int num : nums)
            i ^= num;
        return i;
    }
}
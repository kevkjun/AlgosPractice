class Solution {
    // Faster than 98%
    // Less than 98%
    public void reverseString(char[] s) {
        helper(0, s.length - 1, s);
    }
    
    public void helper(int l, int r, char[] s) {
        if (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            helper(l + 1, r - 1, s);
        }
    }
}
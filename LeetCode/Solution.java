class Solution {
    // Faster than 84%
    // Less than 47%
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (chars[t.charAt(i) - 'a'] == 0) return false;
            chars[t.charAt(i) - 'a']--;
        }
        return true;
    }
}
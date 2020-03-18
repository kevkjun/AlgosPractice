class Solution {
    /*
    Initial solution: Parse through the string and populate a HashMap where the key is the char and the value is the count. 
    Then, go back through the string and find the first char that has a value of 1. 
    */
    // Faster than 23%
    // Less than 5%
    public int firstUniqChar(String s) {
        if (s.length() == 0) return -1;
        if (s.length() == 1) return 0;
        
        Map<Character,Integer> countMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (!countMap.containsKey(s.charAt(i))) countMap.put(s.charAt(i), 1);
            else countMap.replace(s.charAt(i), countMap.get(s.charAt(i))+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (countMap.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }

    /*
    Use an array instead of a hashmap to iterate through the string. 
    */
    // Faster than 99%
    // Less than 5%
    public int firstUniqChar1(String s) {
        int[] chars = new int[26];
        char[] word = s.toCharArray();
        
        for (char c : word) {
            chars[c-'a']++;
        }
        
        for (int i = 0; i < word.length; i++) {
            if (chars[word[i]-'a'] == 1) return i;
        }
        
        return -1;
    }
}
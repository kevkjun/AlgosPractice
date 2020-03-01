class Solution {
    // No-brainer solution is double for loop - for each character in J, iterate through S and sum up the matches
    
    // Faster than 100%
    // Less than 5%
    public int numJewelsInStones(String J, String S) {
        int jewels = 0;
        for (int j = 0; j < J.length(); j++) {
            for (int s = 0; s < S.length(); s++) {
                if (J.charAt(j) == S.charAt(s)) jewels++;
            }
        }
        return jewels;
    }

    // Can use a HashSet which adds each jewel and then use for loop to iterate through all stones
    // Although this should be better time complexity, performance is much worse than simple double for loop (100%)
    // Faster than 79%
    // Less than 5%
    public int numJewelsInStones2(String J, String S) {
        int jewels = 0;
        Set<Character> set = new HashSet<>();
        for (int j = 0; j < J.length(); j++) 
            set.add(J.charAt(j));
        
        for (int s = 0; s < S.length(); s++) 
            if (set.contains(S.charAt(s))) jewels++;
        
        return jewels;
    }
}
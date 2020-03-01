class Solution {
    /*
    This solution required that the balanced splits be contiguous. Thus, we move across the string, incrementing counter by 1 if 'L' and
    decrementing if 'R'. If the counter ever reaches 0, that must mean that we saw equal number of 'L' and 'R' so a valid split must have 
    been seen.
    */
    // Faster than 100%
    // Less than 100%
    public int balancedStringSplit(String s) {
        if (s.length() == 0) return 0;
        int iter = 0, res = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') iter++;
            else iter--;
            if (iter == 0) res++;
        }
        return res;
    }
}
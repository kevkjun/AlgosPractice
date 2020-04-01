class Solution {
    /*
    First calculate the factorial then mod.
    This works for ints but overflows very quickly. Also does not run in logn time
    */
    public int trailingZeroes(int n) {
        if (n < 5) return 0;
        
        // start the factorial at 4! b/c we know that 5! is the first factorial with a trailing zero
        int fact = 24;
        for (int i = 5; i <= n; i++) {
            fact *= i;
        }
        
        // calculate the number of trailing zeros
        int res = 0;
        for (int i = fact; i % 10 == 0; i /= 10) {
            res++;
        }
        
        return res;
    }

    /*
    All trailing 0 is from factors 5 * 2.

    But sometimes one number may have several 5 factors, for example, 25 have two 5 factors, 125 have three 5 factors. 
    In the n! operation, factors 2 is always ample. So we just count how many 5 factors in all number from 1 to n.
    */
    // Faster than 100%
    // Less than 7%
    public int trailingZeroes1(int n) {
        return n == 0 ? 0 : n/5 + trailingZeroes(n/5);
    }
}
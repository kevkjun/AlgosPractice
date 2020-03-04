class Solution {
    /*
    Idea is insert a number and its negative rotated around the middle.
    There need to be a case for an odd and even n value. 
    Odd case is very similar to even case except insert a 0 at the end. 
    */
    // Faster than 100%
    // Less than 100%
    public int[] sumZero(int n) {
        if (n <= 0) return new int[0];
        
        int[] res = new int[n];
        
        if (n % 2 == 0) {
            for (int i = 0; i < n/2; i++) {
                res[i] = i + 1;
                res[n-i-1] = -(i + 1);
            }
        }
        else {
            res[n-1] = 0;
            for (int i = 0; i < n/2; i++) {
                res[i] = i+1;
                res[n-i-1] = -(i+1);
            }
        }
        return res;
    }
}
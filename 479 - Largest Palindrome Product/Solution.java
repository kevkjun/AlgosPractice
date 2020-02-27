class Solution {
    /*
    This is like impossible
    */
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        int max = 9;
        for (int i = 1; i < n; i++) {
            max = (max * 10) + 9;
        }
        int min = (int)Math.pow(10, n-1);
        boolean palFound = false;
        long maxMod = 0;
        
        for (int i = max; i >= min; i--) {
            for (int j = i; j >= min; j--) {
                long pal = i*j;
                palFound = isPalindrome(i*j);
                if (palFound) {
                    maxMod = i*j;
                    break;
                }
            }
            if (palFound) break;
        }
        return (int) maxMod % 1337;
    }
    
    // LeetCode 9
    public boolean isPalindrome(long num) {
        if (num < 0 || (num % 10 == 0 && num != 0)) return false;
        long revertedNumber = 0;
        
        while (num > revertedNumber) {
            revertedNumber = (revertedNumber * 10) + (num % 10);
            num /= 10;
        }
        
        return num == revertedNumber || num == revertedNumber/10;
    }
}
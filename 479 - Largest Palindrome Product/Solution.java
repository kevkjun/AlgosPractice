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

    /* 
    First, create the largest product that you can with the number of digits. Then, try to factor it to see if it is indeed a palindrome.
    Do this by creating an upper bound and lower bound for the products. This approach also assumes that the palindrome will have 2n digits.
    
    Need to study this. Really don't have much of a clue on what's going on here. 
    */
    // Faster than 9%
    // Less than 100%
    public int largestPalindrome1(int n) {
        if (n == 1) return 9;
        
        // Create the upper and lower bounds for the factors and define the absolute max number which upperbound ^ 2
        int upperBound = (int) Math.pow(10,n) - 1, lowerBound = upperBound/10; 
        long maxNumber = (long) upperBound * (long) upperBound;
        
        int firstHalf = (int) (maxNumber / (long) Math.pow(10, n));
        
        boolean palindromeFound = false;
        long palindrome = 0;
        
        while (!palindromeFound) {
            palindrome = createPalindrome(firstHalf);
            
            for (long i = upperBound; i * i >= palindrome; i--) {
                if (palindrome / i > maxNumber) 
                    break;
                
                if (palindrome % i == 0) {
                    palindromeFound = true;
                    break;
                }
            }
            firstHalf--;
        }
        return (int) (palindrome % 1337);
    }
    
    // Create a palindrome given the first half of the palindrome
    public long createPalindrome(long num) {
        String str = num + new StringBuilder().append(num).reverse().toString();
        return Long.parseLong(str);
    }
}
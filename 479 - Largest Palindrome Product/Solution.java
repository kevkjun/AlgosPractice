class Solution {
    /*
    This is like impossible
    */
    //=================================================FIRST TRY - DID NOT COMPILE============================================================//
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
    //=================================================SECOND TRY - FROM LEETCODE============================================================//
    /* 
    First, create the largest product that you can with the number of digits. Then, try to factor it to see if it is indeed a palindrome.
    Do this by creating an upper bound and lower bound for the products. This approach also assumes that the palindrome will have 2n digits.
    
    Need to study this. Really don't have much of a clue on what's going on here. 
    */
    // Faster than 12%
    // Less than 100%
    public int largestPalindrome1(int n) {
        if (n == 1) return 9;
        
        // Create the upper and lower bounds for the factors and define the absolute max number which is upperbound ^ 2
        int upperBound = (int) Math.pow(10,n) - 1, lowerBound = upperBound/10; 
        long maxNumber = (long) upperBound * (long) upperBound;
        
        int firstHalf = (int) (maxNumber / (long) Math.pow(10, n));
        
        boolean palindromeFound = false;
        long palindrome = 0;
        
        while (!palindromeFound) {
            palindrome = createPalindrome(firstHalf);
            
            for (long i = upperBound; i * i >= palindrome; i--) {
                if (palindrome / i <= lowerBound) 
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

    //=================================================MUCH EASIER, MUCH FASTER SOLUTION============================================================//
    /* 
    First, define the max factor which is the largest n-digit number (e.g. n=3 --> 999). 
    Outer for loop: 
        - Starting from i = max and iterating downwards - the lower bound is max/10 (e.g. n=3 --> 99)
        - Create the palindrome which is Long.valueOf(i + new StringBuilder().append(i).reverse().toString())
    Inner for loop:
        - Starting from j = max and iterating downwards - the lower bound is j*j >= palindrome (As to the two numbers we are looking for, 
        one of them must be x and another one should be u%x. so beyond sqrt(u), it is not possible to find any pairs of numbers that have 
        the product of palindrome)
        - if palindrome % j == 0, then we have found viable factors and we return the palindrome % 1337
        
    Idea is that we iterate one factor down in the outer for loop and iterate the second factor down in the inner for loop. 
    To prevent the product from becoming too small of a palindrome, we exit the inner for loop when Math.sqrt(j) < palindrome which means
    it is not possible to find any pairs of numbers that have product of palindrome. 
    
    Important assumption for this solution is that the answer will have 2n digits (i.e. even).
    */
    // Faster than 27%
    // Less than 100%
    public int largestPalindrome2(int n) {
        if (n == 1) return 9;
        
        int maxFactor = (int) Math.pow(10, n) - 1;
        
        for (int i = maxFactor; i > maxFactor/10; i--) {
            long pal = Long.valueOf(i + new StringBuilder().append(i).reverse().toString());
            for (long j = maxFactor; j * j >= pal; j--) 
                if (pal % j == 0) 
                    return (int) (pal % 1337);
            
        }
        return -1;
    }
}
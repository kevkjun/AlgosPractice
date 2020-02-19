class Solution {
    // Doesn't work
    public boolean isPalindrome(int x) {
        if (x < 10) return true;
        int places = 2;
        int tmp = x;
        while (x > 0) {
            tmp /= 10;
            places++;
        }
        for (int i = 1; i <= places; i++) {
            if (x/Math.pow(10,i) == x/Math.pow(10, places))
                places--;
            else return false;
        }
        return true;
    }

    /* 
    General idea is to slowly change revertedNumber into the left half of the original number by taking from the 
    right half of the original number. Build it up by multiplying the current value by 10 and adding the original 
    number mod 10; then, divide the original number by 10. 
    
    Run this algo until the original number is less than the reverted number. Once it is, check if the numbers are
    equal or if the original number is equal to the reverted number / 10. 
    
    The first case is if original number had an even number of digits; second case is if it's odd number of digits.
    Example of second case: x = 12321. After algo, x = 12 and revertedNumber = 123; x = revertedNumber/10. 
    */
    
    // Faster than 100%
    // Less than 5.02%
    public boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        
        return x == revertedNumber || x == revertedNumber/10;
    }
}
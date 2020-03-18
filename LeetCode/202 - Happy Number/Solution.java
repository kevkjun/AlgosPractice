class Solution {
    public boolean isHappy(int n) {
        if (n == 1) return true;
        
        while (true) {
            int n2 = n, tmp = 0;
            while (n > 0) {
                tmp += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (n2 == tmp) return false;
            else if (tmp == 1) return true;
            n = tmp;
        }
    }
}
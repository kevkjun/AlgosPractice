public class Solution {
    // Faster than 100%
    // Less than 5.41%
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n-1);
        }
        return count;
    }
}
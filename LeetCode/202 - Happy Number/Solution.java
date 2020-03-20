class Solution {
    /*
    Exactly the same as finding a cycle in a linked list. Keep two runners - one fast and one slow.
    The fast runner moves twice as fast as the slow runner which guarantees they will meet each other if there is a cycle.
    Keep moving the runners forward until they equal each other (there is a loop and it is not a happy number) or
    the faster runner is equal to 1 (it is a happy number).
    */
    // Faster than 100%
    // Less than 6%
    public int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            sum += d*d;
        }
        return sum;
    }
    
    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }
}
class Solution {
    // Faster than 99%
    // Less than 5%
    public List<String> fizzBuzz(int n) {
        List<String> res = new LinkedList<>();
        if (n == 0) return res;
        for (int i = 1; i < n+1; i++) {
            if (i % 15 == 0) res.add("FizzBuzz");
            else if (i % 3 == 0) res.add("Fizz");
            else if (i % 5 == 0) res.add("Buzz");
            else res.add(new Integer(i).toString());
        }
        return res;
    }
}
class Solution {
    /*
    Bitwise operators:
    ~ inverts a bit pattern
    & binary AND
    | binary OR
    ^ binary XOR (copies if set in one but not both)
    << left shift (moved left by the number of bits specified by right operand)
    >> right shift (moved right by the number of bits specified by right operand)
    >>> zero fill right shift (moved right by bits specified by right operand and filled with 0)
    
    Calculate the carry which is a & b - the flowover of the bits that cannot be represented with the number of bits that a and b have.
    a becomes the sum of a and b (XOR) without accounting for the carry. b becomes the carry leftshifted by 1 so we can get an extra bit
    to add to a. Keep repeating this until b becomes 0 (we have enough bits to represent the number of bits in a + b).
    
    Look at intro to systems notes Week 2 for more information. 
    */
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
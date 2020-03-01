class Solution {
    // Requires knowing regex - honestly, not a very helpful question because there is a built-in function that makes it pretty much a no-brainer
    // Faster than 53%
    // Less than 100%
    public String removeVowels(String S) {
        return S.replaceAll("[aeiou]","");
    }
}
class Solution {
    // Faster than 100%
    // Less than 6%
    // Absolutely useless knowledge. When would you have to memorize ASCII for a coding interview? 
    // I knew exactly what needed to be done but had to look up the ASCII for the characters, and I'm not trying to memorize ASCII.
    public String toLowerCase(String str) {
        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if ((int) str.charAt(i) < 91 &&  (int) str.charAt(i) > 64) 
                str2.append((char) ((int) str.charAt(i) + 32));
            else
                str2.append(str.charAt(i));
        }
        return str2.toString();
    }
}
class Solution {
    // Faster than 49%
    // Less than 5%
    public String removeOuterParentheses(String S) {
        int i = 0, curr = 0;
        
        StringBuilder str = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        for (int c = 0; c < S.length(); c++) {
            if (curr == 1 && S.charAt(c) == ')') {
                str.append(tmp.toString());
                tmp.setLength(0);
                curr--;
            }
            else if (curr == 0 && S.charAt(c) == '(') {
                curr++;
            }
            else {
                if (S.charAt(c) == '(') curr++;
                else if (S.charAt(c) == ')') curr--;
                tmp.append(S.charAt(c));
            }
        }
        return str.toString();
    }
}
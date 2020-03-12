class Solution {
    /*
    My initial thought was to iterate through all characters and add one to the associated int variable if opening and subtract one if closing, but this doesn't address 
    case in which they're closed out of order or the closing end comes before the opening end. 
    
    Used a stack to push items onto the stack when seeing opening braces and popping items off the stack when seeing closing braces to make sure they are the appropriate
    opening braces. 
    
    Needed a lot of checks. Need to make sure to get better at seeing and understanding edge cases. 
    */
    // Faster than 98%
    // Less than 5%
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        if (s.length() % 2 != 0) return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }
            else {
                try {
                    Character c = stack.pop();
                    if ((s.charAt(i) == ')' && c != '(') || (s.charAt(i) == ']' && c != '[') || (s.charAt(i) == '}' && c != '{'))
                        return false;
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
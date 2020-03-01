class Solution {
    // Simple regex solution - need to remember to input two escape forward slashes before the period
    // Faster than 37% 
    // Less than 100%
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[\\.]");
    }
    
    // Not using regex and just straight strings makes it much, much faster - makes sense b/c we don't need to use regex for such a simple switch
    // Faster than 100% 
    // Less than 100%
    public String defangIPaddr1(String address) {
        return address.replace(".", "[.]");
    }

    // Use a StringBuilder to iterate through the string - probably the answer that would be best accepted and it's just as fast as using replace
    // Faster than 100% 
    // Less than 100%
    public String defangIPaddr2(String address) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.')
                str.append("[.]");
            else
                str.append(address.charAt(i));
        }
        return str.toString();
    }
}
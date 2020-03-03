class Solution {
    /*
    Iterate through s until we see a word. If we see a word, move onto the next index and repeat.
    If reach the end of the string and was not able to make complete words, then return false.
    */
    public boolean wordBreak(String s, List<String> wordDict) {
        List<String> strList = new LinkedList<>();
        int index = 0;
        for (int c = 0; c < s.length(); c++) {
            StringBuilder str = new StringBuilder();
            for (int d = c; d < s.length(); d++) {
                
            }
        }
    }
    
    public boolean wordBreakRecursive(int i, int j, String s, List<String> wordDict) {
        if (i < j) {
            StringBuilder str = new StringBuilder();
            for (int k = i; k < s.length(); k++) {
                if (wordDict.contains(str.toString())) {
                    if (k = s.length() - 1) return true;
                    else wordBreakRecursive(i, )
                }
            }
        }
        else return false;
    }
}
class Solution {
    /*
    General idea I have is using a TreeMap which maps the student ID to an array of their top five scores. The array has a length of 5
    and because test scores must be between 1 to 100 it will be okay that the array was initilized with five 0's.
    
    After iterating through the list of test scores, iterate through the treemap and output the averages.
    for (Map.Entry<String,Integer> entry : treeMap.entrySet()) {
      String key = entry.getKey();
      Integer value = entry.getValue();
    */
    // Faster than 88%%
    // Less than 100%
    public int[][] highFive(int[][] items) {
        Map<Integer,int[]> treeMap = new TreeMap<>();
        int[] scores;
        for (int i = 0; i < items.length; i++) {
            if (treeMap.containsKey(items[i][0])) {
                scores = treeMap.get(items[i][0]);
                if (scores[0] > 0 && items[i][1] > scores[0]) {
                        scores[0] = items[i][1];
                        Arrays.sort(scores);
                }
                else if (scores[0] == 0) {
                    scores[0] = items[i][1];
                    Arrays.sort(scores);
                }
            }
            else
                treeMap.put(items[i][0], new int[] {0,0,0,0,items[i][1]});
        }
        
        int[][] res = new int[treeMap.size()][2];
        int i = 0, sum = 0;
        // iterate through the treemap to calculate average values
        for (Map.Entry<Integer,int[]> entry : treeMap.entrySet()) {
            res[i][0] = entry.getKey();
            for (int score : entry.getValue()) 
                sum += score;
            res[i][1] = sum/5;
            sum = 0;
            i++;
        }
        return res;
    }
}
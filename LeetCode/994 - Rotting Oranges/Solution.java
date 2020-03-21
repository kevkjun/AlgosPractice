class Solution {
    /*
    Initial Solution: Seems like it should be BFS from any rotten orange. Need to run through
    the entire grid and add each rotten orange on the periphery to a queue. 
    
    Keep iterating until either all rotten oranges are surrounded by only rotten oranges or empty spaces.
    */
    public int orangesRotting(int[][] grid) {
        int cols = grid.length;
        int rows = grid[0].length;
        
        // counting the days
        int days = 0;
        // q for the BFS
        Queue<Integer> q = new LinkedList<>();
        
        
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                
            }
        }
    }
}
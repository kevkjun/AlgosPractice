class Solution {
    /*
    BFS to find all connected nodes. 
    Could also use Union Find, similar to Prim's algorithm.
    */
    // Faster than 5%
    // Less than 100%
    public int countComponents(int n, int[][] edges) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (edges.length == 0) return n;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int nodeCount = 0, compCount = 0;
        boolean exit = false;
        while (true) {
            for (int [] edge : edges) {
                if (!visited[edge[0]]) {
                    queue.offer(edge[0]);
                    exit = false;
                    break;
                }
                else if (!visited[edge[1]]) {
                    queue.offer(edge[1]);
                    exit = false;
                    break;
                }
                else exit = true;
            }
            if (exit) break;
            while (!queue.isEmpty()) {
                Integer node = queue.poll();
                visited[node] = true;
                nodeCount++;
                for (int[] edge : edges) {
                    if (edge[0] == node && !visited[edge[1]]) 
                        queue.offer(edge[1]);
                    else if (edge[1] == node && !visited[edge[0]])
                        queue.offer(edge[0]);
                }
            }
            compCount++;
        }
        for (boolean visit : visited) 
            if (!visit)
                compCount++;
        return compCount;
    }
}
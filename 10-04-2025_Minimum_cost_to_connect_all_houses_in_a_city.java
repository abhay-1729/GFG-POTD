//Problem: Minimum cost to connect all houses in a city
class Solution {
    public int minCost(int[][] houses) {
        // code here
         int n = houses.length;
        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            int u = -1;
            // Step 1: Pick the unvisited node with minimum cost
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || minDist[j] < minDist[u])) {
                    u = j;
                }
            }
            // Step 2: Add the cost and mark the node as visited
            totalCost += minDist[u];
            visited[u] = true;
            // Step 3: Update distances of neighboring unvisited nodes
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int dist = manhattan(houses[u], houses[v]);
                    minDist[v] = Math.min(minDist[v], dist);
                }
            }
        }
        return totalCost;
    }
    // Manhattan distance between two points
    private int manhattan(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    
    }
}

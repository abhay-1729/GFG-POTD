//Problem: Bridge edge in a graph (GFG)

class Solution {
    int timer; // Move timer to class level

    public boolean isBridge(int V, int[][] edges, int c, int d) {
        // code here
        // Build the adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Initialize timer and arrays
        timer = 0; 
        int[] tin = new int[V];
        int[] low = new int[V];
        boolean[] visited = new boolean[V];

        // Run DFS and check for bridge (c, d)
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, adj, visited, tin, low, c, d)) {
                    return true; // found (c,d) as a bridge
                }
            }
        }
        return false; // not a bridge
    }

    private boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj,
                        boolean[] visited, int[] tin, int[] low, int c, int d) {
        visited[node] = true;
        tin[node] = low[node] = timer++; // Now works because timer is class-level
        
        for (int neighbor : adj.get(node)) {
            if (neighbor == parent) continue;
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, adj, visited, tin, low, c, d)) return true;
                low[node] = Math.min(low[node], low[neighbor]);

                // If edge is a bridge
                if (low[neighbor] > tin[node]) {
                    if ((node == c && neighbor == d) || (node == d && neighbor == c)) {
                        return true;
                    }
                }
            } else {
                low[node] = Math.min(low[node], tin[neighbor]);
            }
        }
        return false;
    }
}

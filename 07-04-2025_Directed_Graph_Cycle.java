//Problem: Directed Graph Cycle(GFG)
class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        // Step 1: Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        // Step 2: Initialize visited and recStack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        // Step 3: Check for cycles starting from each unvisited node
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfsCycle(i, adj, visited, recStack)) return true;
            }
        }

        return false;
    }

    private boolean dfsCycle(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfsCycle(neighbor, adj, visited, recStack)) return true;
            } else if (recStack[neighbor]) {
                // Cycle detected
                return true;
            }
        }

        recStack[node] = false; // backtrack
        return false;
    }
}

//Problem: Articulation Point-II (GFG)

class Solution {
    static int timer;
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        // code here
        // Step 1: Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Step 2: Initialize helper arrays
        int[] tin = new int[V];
        int[] low = new int[V];
        boolean[] visited = new boolean[V];
        boolean[] isArticulation = new boolean[V];
        timer = 0;

        // Step 3: Run DFS for each component
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, -1, adj, visited, tin, low, isArticulation);
            }
        }

        // Step 4: Collect articulation points
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (isArticulation[i]) result.add(i);
        }

        if (result.isEmpty()) result.add(-1);
        return result;
    }

    private static void dfs(int u, int parent, ArrayList<ArrayList<Integer>> adj,
                            boolean[] visited, int[] tin, int[] low, boolean[] isArticulation) {
        visited[u] = true;
        tin[u] = low[u] = timer++;
        int children = 0;

        for (int v : adj.get(u)) {
            if (v == parent) continue;
            if (!visited[v]) {
                dfs(v, u, adj, visited, tin, low, isArticulation);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] >= tin[u] && parent != -1) {
                    isArticulation[u] = true;
                }
                children++;
            } else {
                low[u] = Math.min(low[u], tin[v]);
            }
        }

        if (parent == -1 && children > 1) {
            isArticulation[u] = true;
        }
    }
}

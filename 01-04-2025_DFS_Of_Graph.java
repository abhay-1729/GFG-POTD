//Problem: DFS of Graph (GFG)

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int n = adj.size();
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[n]; // To keep track of visited nodes
        
        dfsHelper(0, adj, visited, result); // Start DFS from node 0
        
        return result;
    }

    private void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result) {
        visited[node] = true;
        result.add(node);

        // Traverse neighbors in the order they appear in adjacency list
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, adj, visited, result);
            }
        }
    }
}

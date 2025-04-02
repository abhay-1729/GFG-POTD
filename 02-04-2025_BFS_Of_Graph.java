//Problem: BFS of Graph(GFG)
// User function Template for Java
class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
         int n = adj.size(); // Number of nodes
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[n]; // To keep track of visited nodes
        Queue<Integer> queue = new LinkedList<>();

        // Start BFS from node 0
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            // Visit all unvisited neighbors
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return result;
    }
}

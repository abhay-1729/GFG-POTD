//Problem: Dijkstra Algorithm
// User function Template for Java
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
         // Step 1: Create adjacency list with weights
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w}); // Undirected graph
        }

        // Step 2: Min-heap priority queue: {distance, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.offer(new int[]{0, src});

        // Step 3: Dijkstra's Algorithm
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currDist = curr[0], node = curr[1];

            for (int[] neighbor : adj.get(node)) {
                int next = neighbor[0], weight = neighbor[1];
                if (currDist + weight < dist[next]) {
                    dist[next] = currDist + weight;
                    pq.offer(new int[]{dist[next], next});
                }
            }
        }

        return dist;
    }
}

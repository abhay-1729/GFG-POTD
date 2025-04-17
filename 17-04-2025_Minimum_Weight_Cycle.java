//Problem: Minimum Weight Cycle(GFG)

class Solution {
    // Helper function to construct adjacency list
    private ArrayList<ArrayList<int[]>> constructAdj(int V, int[][] edges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
        return adj;
    }

    // Helper function to find shortest path ignoring one direct edge
    private int shortestPath(int V, ArrayList<ArrayList<int[]>> adj, int src, int dest) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        dist[src] = 0;
        pq.offer(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int d = current[0];
            int u = current[1];

            if (d > dist[u]) continue;

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int w = neighbor[1];

                // Skip the direct edge being considered for the cycle
                if ((u == src && v == dest) || (u == dest && v == src)) continue;

                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        return dist[dest];
    }

    // Main function to find minimum weight cycle
    public int findMinCycle(int V, int[][] edges) {
        ArrayList<ArrayList<int[]>> adj = constructAdj(V, edges);
        int minCycle = Integer.MAX_VALUE;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            int dist = shortestPath(V, adj, u, v);
            if (dist != Integer.MAX_VALUE) {
                minCycle = Math.min(minCycle, dist + w);
            }
        }

        return (minCycle == Integer.MAX_VALUE) ? -1 : minCycle;
    }
}

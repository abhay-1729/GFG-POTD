//Problem: Find the number of islands (GFG)
class Solution {
    public int countIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int islandCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 'L') {
                    dfs(grid, visited, i, j, n, m);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }
    // DFS to mark connected land as visited
    private void dfs(char[][] grid, boolean[][] visited, int i, int j, int n, int m) {
        // 8 directions
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        visited[i][j] = true;
        for (int d = 0; d < 8; d++) {
            int ni = i + dx[d];
            int nj = j + dy[d];
            if (ni >= 0 && nj >= 0 && ni < n && nj < m &&
                grid[ni][nj] == 'L' && !visited[ni][nj]) {
                dfs(grid, visited, ni, nj, n, m);
            }
        }
    }
}

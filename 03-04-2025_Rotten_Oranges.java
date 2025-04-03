//Problem: Rotten Oranges(GFG)


class Solution {
    public int orangesRotting(int[][] mat) {
        // Code here
         if (mat == null || mat.length == 0) return -1;

        int rows = mat.length, cols = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0, time = 0;

        // Step 1: Add all rotten oranges to queue and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (mat[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // If no fresh oranges, return 0
        if (freshCount == 0) return 0;

        // Step 2: Perform BFS
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];

                // Spread rot in all 4 directions
                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && mat[newX][newY] == 1) {
                        mat[newX][newY] = 2; // Mark as rotten
                        queue.offer(new int[]{newX, newY});
                        freshCount--;
                        rotted = true;
                    }
                }
            }

            // Only increase time if at least one orange rotted in this round
            if (rotted) time++;
        }
        // Step 3: Check if all fresh oranges are rotten
        return (freshCount == 0) ? time : -1;
    }
}

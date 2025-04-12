//Problem: Flood Fill(GFG)

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        int originalColor = image[sr][sc];
        if (originalColor == newColor) return image; // No need to change if same

        dfs(image, sr, sc, originalColor, newColor);
        return image;
    }

    private void dfs(int[][] image, int x, int y, int originalColor, int newColor) {
        // Check bounds
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length)
            return;
        // Check if the color matches the original color
        if (image[x][y] != originalColor)
            return;

        // Change color
        image[x][y] = newColor;

        // Visit neighbors (4 directions)
        dfs(image, x + 1, y, originalColor, newColor); // down
        dfs(image, x - 1, y, originalColor, newColor); // up
        dfs(image, x, y + 1, originalColor, newColor); // right
        dfs(image, x, y - 1, originalColor, newColor); // left
    
    }
}

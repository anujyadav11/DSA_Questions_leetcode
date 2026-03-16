/*********************************************** JAVA **************************************************/

// Optimal Solution - Perform DFS from the starting pixel and recolor all connected cells with the same original color.
/* "This is a classic flood fill problem where we treat the image as a grid graph and perform DFS from the starting cell, 
    recoloring all connected cells that match the original color." */

class Solution {
    public void fill(int[][] image, int sr, int sc, int originalColor, int newColor) {
        // Boundary check and color check
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length
                || image[sr][sc] != originalColor) {
            return;
        }
        // Color the current cell
        image[sr][sc] = newColor;
        // Explore 4-directionally
        fill(image, sr - 1, sc, originalColor, newColor); // up
        fill(image, sr + 1, sc, originalColor, newColor); // down
        fill(image, sr, sc - 1, originalColor, newColor); // left
        fill(image, sr, sc + 1, originalColor, newColor); // right
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // If starting pixel already has the new color → nothing to do
        if (image[sr][sc] == color)
            return image;
        // Start DFS with the original color
        fill(image, sr, sc, image[sr][sc], color);
        return image;
    }
}

// Time Complexity :- O(m * n).
// Space Complexity :- O(m * n).

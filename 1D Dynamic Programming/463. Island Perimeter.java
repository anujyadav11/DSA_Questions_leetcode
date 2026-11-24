/*********************************************** JAVA **************************************************/

// Optimal Solution - Implemented a single-pass 2D grid traversal with four-directional boundary checks to calculate island perimeter in O(m × n) time and O(1) auxiliary space.
/* "I traverse the entire grid and process only land cells. For every land cell, I check its four neighboring directions. If a neighboring cell is water or the current side lies outside the grid, 
    I increment the perimeter. After processing all cells, I return the accumulated perimeter." */

class Solution {
    public int islandPerimeter(int[][] grid) {
        // Get the number of rows and columns in the grid.
        int rows = grid.length;
        int cols = grid[0].length;
        // Stores the total island perimeter.
        int count = 0;
        // Traverse every cell in the grid.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Process only land cells (1).
                if (grid[i][j] == 1) {
                    // Check the top side.
                    // It contributes to the perimeter if:
                    // 1. The cell is in the first row, or
                    // 2. The cell above is water.
                    if (i > 0 && grid[i - 1][j] == 0 || i == 0) {
                        count += 1;
                    }
                    // Check the right side.
                    // It contributes to the perimeter if:
                    // 1. The cell is in the last column, or
                    // 2. The cell to the right is water.
                    if (j < cols - 1 && grid[i][j + 1] == 0 || j == cols - 1) {
                        count += 1;
                    }
                    // Check the bottom side.
                    // It contributes to the perimeter if:
                    // 1. The cell is in the last row, or
                    // 2. The cell below is water.
                    if (i < rows - 1 && grid[i + 1][j] == 0 || i == rows - 1) {
                        count += 1;
                    }
                    // Check the left side.
                    // It contributes to the perimeter if:
                    // 1. The cell is in the first column, or
                    // 2. The cell to the left is water.
                    if (j > 0 && grid[i][j - 1] == 0 || j == 0) {
                        count += 1;
                    }
                }
            }
        }
        // Return the total perimeter of the island.
        return count;
    }
}

// Time Complexity :- O(m * n).
// Space Complexity :- O(1).

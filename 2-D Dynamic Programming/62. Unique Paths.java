/*********************************************** JAVA **************************************************/

// Optimal Solution - Dynamic programming solution that counts unique paths by accumulating ways from top and left cells. Each cell’s paths depend only on the cell above and to the left, making it a classic 2D DP grid problem.
/* “I use dynamic programming where grid[i][j] represents the number of ways to reach that cell. Since movement is only right or down, 
    every cell can be reached from either the cell above or the cell to the left, so I add those two values. The first row and column are initialized to one because they have only one possible path.” */

class Solution {
    public int uniquePaths(int m, int n) {
        // DP grid where grid[i][j] stores number of ways to reach cell (i, j)
        int[][] grid = new int[m][n];
        // Fill the DP table
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // First row or first column has only one way to reach
                if (i == 0 || j == 0) {
                    grid[i][j] = 1;
                }
                // Number of ways = from top + from left
                else {
                    grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
                }
            }
        }
        // Bottom-right cell contains the total unique paths
        return grid[m - 1][n - 1];
    }
}

// Time Complexity :- O(m x n).
// Space Complexity :- O(m x n).

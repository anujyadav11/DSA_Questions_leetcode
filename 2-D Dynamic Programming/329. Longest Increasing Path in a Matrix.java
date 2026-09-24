/*********************************************** JAVA **************************************************/

// Optimal Solution - DFS with memoization to compute the longest strictly increasing path in a matrix. Treat each cell as a starting point, run DFS to explore increasing neighbors, and memoize results to reduce exponential paths to linear time.
/* “I treat every cell as a starting point and use DFS to explore only adjacent cells having a strictly greater value. The state dp[i][j] stores the longest increasing path starting from cell (i,j). 
    Since the same cells can be reached from multiple starting points, I memoize each result so every cell is processed only once. Finally, I take the maximum DFS result over all cells.” */

class Solution {
    // Four possible directions:
    // right, down, left, up
    int[][] dirs = {{ 0, 1 },{ 1, 0 },{ 0, -1 },{ -1, 0 }};
    public int longestIncreasingPath(int[][] matrix) {
        // Handle empty matrix
        if (matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        // dp[i][j] = longest increasing path starting from (i, j)
        int[][] dp = new int[m][n];
        int longestPath = 0;
        // Try every cell as the starting point
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Find the longest increasing path starting from this cell
                int path = dfs(matrix, m, n, i, j, dp);
                longestPath = Math.max(path, longestPath);
            }
        }
        return longestPath;
    }
    public int dfs(int[][] mat, int m, int n,int i, int j, int[][] dp) {
        // If already calculated, return the cached result
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        // Stores the maximum path length from neighboring cells
        int max = 0;
        // Explore all four directions
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            // Check:
            // 1. Neighbor is inside the matrix
            // 2. Neighbor has a strictly greater value
            if (x >= 0 && y >= 0 && x < m && y < n
                    && mat[x][y] > mat[i][j]) {
                // Recursively find the longest path from the neighbor
                max = Math.max(
                    max,
                    dfs(mat, m, n, x, y, dp)
                );
            }
        }
        // Include the current cell itself
        dp[i][j] = max + 1;
        return max + 1;
    }
}

// Time Complexity :- O(m * n).
// Space Complexity :- O(m * n).

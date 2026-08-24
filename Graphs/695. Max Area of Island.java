/*********************************************** JAVA **************************************************/

// Optimal Solution - Use DFS to explore each island and track the maximum area by marking visited cells. I run DFS from every unvisited land cell, compute the connected component size, and keep the maximum.
/* “I traverse the entire grid and start a DFS whenever I find an unvisited land cell. The DFS marks each visited cell and returns 1 plus the areas obtained from its four neighbouring cells. 
    This gives the total area of that island. I compare each island’s area with the current maximum.” */

class Solution {
    int n, m;
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int maxArea = 0;
        // Visit every cell in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Start DFS for every unvisited island
                if (grid[i][j] == 1) {
                    maxArea = Math.max(
                        maxArea,
                        dfs(grid, i, j)
                    );
                }
            }
        }
        return maxArea;
    }
    public int dfs(int[][] grid, int i, int j) {
        // Stop at boundaries, water, or visited cells
        if (i < 0 || j < 0 || i >= n || j >= m
                || grid[i][j] == 0
                || grid[i][j] == 2) {
            return 0;
        }
        // Mark current land as visited
        grid[i][j] = 2;
        // Count current cell + all connected land
        return 1
                + dfs(grid, i + 1, j) // Down
                + dfs(grid, i, j + 1) // Right
                + dfs(grid, i - 1, j) // Up
                + dfs(grid, i, j - 1); // Left
    }
}

// Time Complexity :- O(n x m).
// Space Complexity :- O(n x m).

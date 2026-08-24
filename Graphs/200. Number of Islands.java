/*********************************************** JAVA **************************************************/

// Optimal Solution - Count islands by performing DFS to sink connected land cells in the grid. Each time I find an unvisited land cell, I use DFS to mark the entire island as visited.

class Solution {
    int n, m;
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int count = 0;
        // Visit every cell in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Found an unvisited island
                if (grid[i][j] == '1') {
                    // Mark the entire connected island as visited
                    dfs(grid, i, j);
                    // One DFS represents one island
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j) {
        // Stop if out of bounds, water, or already visited
        if (i < 0 || j < 0 || i >= n || j >= m
                || grid[i][j] == '0'
                || grid[i][j] == '2') {
            return;
        }
        // Mark current land cell as visited
        grid[i][j] = '2';
        // Explore all four directions
        dfs(grid, i - 1, j); // Up
        dfs(grid, i, j + 1); // Right
        dfs(grid, i + 1, j); // Down
        dfs(grid, i, j - 1); // Left
    }
}

// Time Complexity :- O(n x m).
// Space Complexity :- O(n x m).

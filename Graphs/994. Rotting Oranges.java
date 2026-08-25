/*********************************************** JAVA **************************************************/

// Optimal Solution - Use DFS from each rotten orange to compute the minimum time required to rot all fresh oranges. Since all rotten oranges spread simultaneously, BFS naturally models level-by-level time propagation, while DFS may cause redundant traversals.
/* “I treat every initially rotten orange as a source and run DFS from each one. I maintain a time matrix storing the minimum time required to reach every cell. If a DFS reaches a cell at a time greater than or equal to its previously recorded time, I stop that path. 
    After processing all rotten oranges, the maximum minimum-time among fresh oranges is the answer. If any fresh orange remains unreachable, I return -1.” */

class Solution {
    public int orangesRotting(int[][] grid) {
        // Invalid or empty grid
        if (grid == null || grid.length == 0)
            return -1;
        int row = grid.length;
        int cols = grid[0].length;
        // time[i][j] = minimum time needed to reach this cell
        int[][] time = new int[row][cols];
        // Initially, all cells are unreachable
        for (int i = 0; i < row; i++) {
            Arrays.fill(time[i], Integer.MAX_VALUE);
        }
        // Start DFS from every initially rotten orange
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, time, i, j, 0);
                }
            }
        }
        int timeReq = 0;
        // Find the maximum time required to rot every fresh orange
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    // Fresh orange was never reached
                    if (time[i][j] == Integer.MAX_VALUE)
                        return -1;
                    timeReq = Math.max(timeReq, time[i][j]);
                }
            }
        }
        return timeReq;
    }
    private void dfs(int[][] grid, int[][] time,int i, int j, int currTime) {
        // Stop if out of bounds, empty, or a faster/equal path already exists
        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length ||
            grid[i][j] == 0 ||
            currTime >= time[i][j]) {
            return;
        }
        // Store the minimum time to reach this cell
        time[i][j] = currTime;
        // Explore all four directions
        dfs(grid, time, i - 1, j, currTime + 1); // Up
        dfs(grid, time, i + 1, j, currTime + 1); // Down
        dfs(grid, time, i, j - 1, currTime + 1); // Left
        dfs(grid, time, i, j + 1, currTime + 1); // Right
    }
}

// Time Complexity :- O((R x C)^2).
// Space Complexity :- O(R x C).

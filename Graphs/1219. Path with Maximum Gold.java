/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds maximum gold collectible path using backtracking DFS from every non-zero cell, exploring all directions while preventing same-path cell revisits.
/* "The visited check must be in the DFS base case — not just before calling DFS. Without vis[i][j] in the boundary condition, a cell could be entered from two different neighbors in the same path, 
    breaking the 'no revisit' constraint. Backtracking (vis[i][j] = false after recursion) lets different starting paths reuse cells freely." */

class Solution {
    int rows;
    int cols;
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int getMaximumGold(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] vis = new boolean[rows][cols];
        int totalGold = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                totalGold += grid[i][j];
            }
        }
        int maxGold = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // start DFS from every non-zero cell
                if (grid[i][j] != 0)
                    maxGold = Math.max(maxGold, dfs(i, j, vis, grid));
                if (maxGold == totalGold)
                    return maxGold;
            }
        }
        return maxGold;
    }

    public int dfs(int i, int j, boolean[][] vis, int[][] grid) {
        // added vis[i][j] check to prevent revisiting cells
        if (i < 0 || j < 0 || i >= rows || j >= cols
                || grid[i][j] == 0 || vis[i][j])
            return 0;
        // mark current cell as visited for this path
        vis[i][j] = true;
        int res = 0;
        // explore all 4 directions — take max gold path
        for (int[] dir : dirs)
            res = Math.max(res, dfs(i + dir[0], j + dir[1], vis, grid));
        // backtrack — unmark to allow other paths to use this cell
        vis[i][j] = false;
        // return gold at current cell plus best path forward
        return grid[i][j] + res;
    }
}

// Time Complexity :- O(n * m * 4^k).— k = non-zero cells; each path branches 4 ways
// Space Complexity :- O(n * m).

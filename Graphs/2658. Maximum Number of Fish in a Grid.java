/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds maximum fish in a connected water region using in-place DFS that zeroes visited cells, avoiding a separate visited array.
/* "Zeroing visited cells instead of maintaining a vis array is an elegant space optimization — O(1) auxiliary vs O(n×m). It works when modifying input is allowed. 
    If the original grid must be preserved, restore values after DFS or use a visited array. Always clarify with the interviewer whether input modification is acceptable." */

class Solution {
    int rows;
    int cols;
    public int findMaxFish(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int maxFish = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // start DFS from every unvisited water cell
                if (grid[i][j] != 0)
                    maxFish = Math.max(maxFish, dfs(i, j, grid));
            }
        }
        return maxFish;
    }
    public int dfs(int i, int j, int[][] grid) {
        // out of bounds or land cell — stop recursion
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 0)
            return 0;
        // collect fish and mark cell as visited by zeroing it
        int ans = grid[i][j];
        grid[i][j] = 0;
        // explore all 4 directions
        ans += dfs(i - 1, j, grid) + dfs(i + 1, j, grid)
             + dfs(i, j - 1, grid) + dfs(i, j + 1, grid);
        return ans;
    }
}

// Time Complexity :- O(n * m).
// Space Complexity :- O(1).

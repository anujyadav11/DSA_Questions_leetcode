/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts unguarded cells by simulating guard line-of-sight in 4 directions on an encoded grid, blocking propagation at walls and other guards.
/* "The key design choice is the 4-value encoding — it lets directional scans detect both walls and guards as blockers with a single condition. 
    Marking guard positions before scanning ensures guards block each other's vision correctly. Final answer is simply the count of cells still at 0." */

class Solution {
    public void markGuarded(int row, int col, int[][] grid) {
        // scan upward from guard — stop at wall(3) or another guard(2)
        for (int i = row - 1; i >= 0; i--) {
            if (grid[i][col] == 2 || grid[i][col] == 3) break;
            // mark cell as guarded
            grid[i][col] = 1;
        }
        // scan downward from guard — stop at wall or guard
        for (int i = row + 1; i < grid.length; i++) {
            if (grid[i][col] == 2 || grid[i][col] == 3) break;
            grid[i][col] = 1;
        }
        // scan leftward from guard — stop at wall or guard
        for (int j = col - 1; j >= 0; j--) {
            if (grid[row][j] == 2 || grid[row][j] == 3) break;
            grid[row][j] = 1;
        }
        // scan rightward from guard — stop at wall or guard
        for (int j = col + 1; j < grid[0].length; j++) {
            if (grid[row][j] == 2 || grid[row][j] == 3) break;
            grid[row][j] = 1;
        }
    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        // mark all guard positions as 2
        for (int[] guard : guards)
            grid[guard[0]][guard[1]] = 2;
        // mark all wall positions as 3
        for (int[] wall : walls)
            grid[wall[0]][wall[1]] = 3;
        // propagate guard vision in all 4 directions for each guard
        for (int[] guard : guards)
            markGuarded(guard[0], guard[1], grid);
        int count = 0;
        // count cells that remain 0 — never reached by any guard
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 0) count++;
        return count;
    }
}

// Time Complexity :- O(m × n + g × (m + n)).
// Space Complexity :- O(m * n).

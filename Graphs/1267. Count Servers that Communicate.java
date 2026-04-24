/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts communicating servers by subtracting isolated ones — servers alone in both their row and column — from the total server count using two grid passes.
/* "The complement approach is cleaner than finding communicating pairs directly — count all servers, then remove isolated ones. 
    A server is isolated only if rowCount == 1 AND colCount == 1 — either condition alone means it shares a row or column with another server." */

class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] rowCount = new int[n];
        int[] colCount = new int[m];
        int count = 0;
        // first pass — count servers per row and column
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                    count++;
                }
            }
        }
        // second pass — subtract isolated servers (alone in both row and column)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1)
                    count--;
            }
        }
        // return servers that can communicate with at least one other
        return count;
    }
}

// Time Complexity :- O(n *  m). We are traversing the grid two times.
// Space Complexity :- O(n + m). rowCount and colCount space.

/*********************************************** JAVA **************************************************/

// Optimal Solution - Mark all boundary-connected regions using DFS and flip the remaining surrounded cells. Instead of searching surrounded regions, I first mark all boundary-connected regions and then flip the rest.
/* “I don’t search for surrounded regions directly. Instead, I start DFS from every O on the boundary and mark all connected Os as safe. Any O that wasn’t reached by these DFS traversals cannot connect to the boundary, 
    so it must be surrounded and can safely be changed to X.” */

class Solution {
    public void dfs(int row, int col, int[][] vis, char[][] mat,
                    int[] delRow, int[] delCol) {
        // Mark current boundary-connected O as safe
        vis[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;
        // Explore all four directions
        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            // Visit unvisited neighbouring O
            if (nrow >= 0 && nrow < n &&
                ncol >= 0 && ncol < m &&
                vis[nrow][ncol] == 0 &&
                mat[nrow][ncol] == 'O') {

                dfs(nrow, ncol, vis, mat, delRow, delCol);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        // Direction vectors: up, right, down, left
        int delRow[] = {-1, 0, +1, 0};
        int delCol[] = {0, +1, 0, -1};
        // Mark O's connected to the boundary
        int[][] vis = new int[n][m];
        // Check top and bottom boundaries
        for (int j = 0; j < m; j++) {
            if (vis[0][j] == 0 && board[0][j] == 'O') {
                dfs(0, j, vis, board, delRow, delCol);
            }

            if (vis[n - 1][j] == 0 && board[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, board, delRow, delCol);
            }
        }
        // Check left and right boundaries
        for (int i = 0; i < n; i++) {
            if (vis[i][0] == 0 && board[i][0] == 'O') {
                dfs(i, 0, vis, board, delRow, delCol);
            }
            if (vis[i][m - 1] == 0 && board[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, board, delRow, delCol);
            }
        }
        // Unvisited O's are surrounded, so flip them
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}

// Time Complexity :- O(R x C).
// Space Complexity :- O(R x C).

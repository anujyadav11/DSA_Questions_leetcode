/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts grid regions formed by slash dividers by scaling each cell to 3×3, marking slash diagonals as barriers, then counting zero-connected components via DFS.
/*  "The 3×3 scaling trick is the key insight — it converts abstract slash characters into concrete pixel-level barriers that flood fill can navigate. 
    Each / marks three cells top-right to bottom-left, \\ marks top-left to bottom-right. Spaces stay zero — flood fill then counts enclosed zero-regions naturally." */

class Solution {
    int rows;
    int cols;
    // four directional movement vectors
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int regionsBySlashes(String[] grid) {
        int size = grid.length;
        // scale each cell to 3x3 to represent slash directions precisely
        rows = size * 3;
        cols = size * 3;
        int[][] mat = new int[rows][cols];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int row = i * 3;
                int col = j * 3;
                if (grid[i].charAt(j) == '/') {
                    // mark diagonal top-right to bottom-left
                    mat[row][col + 2] = 1;
                    mat[row + 1][col + 1] = 1;
                    mat[row + 2][col] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    // mark diagonal top-left to bottom-right
                    mat[row][col] = 1;
                    mat[row + 1][col + 1] = 1;
                    mat[row + 2][col + 2] = 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    // new unvisited region found — flood fill it
                    dfs(i, j, mat);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int row, int col, int[][] mat) {
        // out of bounds or already visited/blocked
        if (row < 0 || row >= rows || col < 0 || col >= cols || mat[row][col] == 1)
            return;
        // mark as visited
        mat[row][col] = 1;
        // explore all 4 directions
        for (int[] dir : dirs)
            dfs(row + dir[0], col + dir[1], mat);
    }
}

// Time Complexity :- O(n ^ 2). - processes (3n)² = 9n² cells; each visited once.
// Space Complexity :- O(n ^ 2). - scaled matrix of size (3n)².

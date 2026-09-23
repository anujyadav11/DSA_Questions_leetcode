/*********************************************** JAVA **************************************************/

// Optimal Solution - Classic backtracking solution for N-Queens, placing queens column-wise with diagonal conflict pruning. Place one queen per column and backtrack whenever a placement violates row or diagonal constraints.
/* “I solve N-Queens using backtracking. I place one queen per column, so for each column I try every possible row. Before placing a queen, I check whether that position is safe by looking at the same row and the upper-left and lower-left diagonals. 
    If it is safe, I place the queen and recursively process the next column. After returning, I remove the queen to backtrack and try another position. When all columns are filled, 
    I add the current board configuration to the result.” */

class Solution {
    public List<List<String>> solveNQueens(int n) {
        // Initialize the board with empty cells
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        // Start placing queens from column 0
        dfs(0, board, res);
        return res;
    }
    public void dfs(int col,char[][] board,List<List<String>> res) {
        // All columns have been filled
        if (col == board.length) {
            res.add(construct(board));
            return;
        }
        // Try placing a queen in every row of this column
        for (int row = 0; row < board.length; row++) {
            if (validate(row, col, board)) {
                // Choose
                board[row][col] = 'Q';
                // Explore
                dfs(col + 1, board, res);
                // Backtrack
                board[row][col] = '.';
            }
        }
    }
    public boolean validate(int row,int col,char[][] board) {
        int dupRow = row;
        int dupCol = col;
        // Check upper-left diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q')
                return false;

            row--;
            col--;
        }
        row = dupRow;
        col = dupCol;
        // Check same row to the left
        while (col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            col--;
        }
        row = dupRow;
        col = dupCol;
        // Check lower-left diagonal
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q')
                return false;
            col--;
            row++;
        }
        return true;
    }
    public List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        // Convert each board row into a String
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}

// Time Complexity :- O(N! × N).
// Space Complexity :- O(N²).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Search for the word using DFS backtracking, marking cells as visited and exploring all four directions.
/* “I try every cell as a possible starting point. When the character matches, I mark the cell as visited and recursively search its four neighbouring cells for the next character. 
    If a path fails, I restore the cell and backtrack so it can be used by another path. This ensures that a cell is never reused within the same word path.” */

class Solution {
    // Four possible movement directions:
    // down, up, right, left
    int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        // Try every cell as the starting point
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)
                        && find(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean find(char[][] board,int i,int j,int idx,String word) {
        // Reached the end of the word
        if (idx == word.length()) {
            return true;
        }
        // Out of bounds or cell already used
        if (i < 0 || j < 0 ||
            i >= board.length || j >= board[0].length ||
            board[i][j] == '$') {
            return false;
        }
        // Current cell doesn't match the required character
        if (board[i][j] != word.charAt(idx)) {
            return false;
        }
        // Mark current cell as visited
        char temp = board[i][j];
        board[i][j] = '$';
        // Try all four directions
        for (int[] dir : dirs) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            if (find(board, new_i, new_j, idx + 1, word)) {
                // Restore before returning
                board[i][j] = temp;
                return true;
            }
        }
        // Backtrack: restore the cell
        board[i][j] = temp;
        return false;
    }
}


// Time Complexity :- O(m × n × 4ˡ).
// Space Complexity :- O(L).

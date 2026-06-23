/************************************************ JAVA ************************************************/

// Optimal soultion - Use a HashSet to track digit occurrences in rows, columns, and 3×3 boxes and detect duplicates efficiently.
/* “For every digit, I generate three unique identifiers representing its row, column, and box occurrence. If any identifier already exists in the HashSet, the Sudoku board is invalid.” */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // HashSet to track whether a number has already appeared
        // in a particular row, column, or 3x3 sub-box
        HashSet<String> seen = new HashSet<>();
        // Traverse each cell in the 9x9 Sudoku board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currVal = board[i][j];
                // Skip empty cells
                if (currVal != '.') {
                    // Create unique identifiers for row, column, and sub-box
                    String rowKey = currVal + " found in row " + i;
                    String colKey = currVal + " found in column " + j;
                    String boxKey = currVal + " found in sub box " + (i / 3) + "-" + (j / 3);
                    // If any identifier already exists, the Sudoku is invalid
                    if (!seen.add(rowKey) || 
                        !seen.add(colKey) || 
                        !seen.add(boxKey)) {
                        return false;
                    }
                }
            }
        }
        // No conflicts found, Sudoku is valid
        return true;
    }
}
// Time Complexity - O(9 * 9).
// Space Complexity - O(1).

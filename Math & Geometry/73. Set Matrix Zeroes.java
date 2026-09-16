/*********************************************** JAVA **************************************************/

// Optimal Solution - In-place matrix zeroing using the first row and column as markers for constant space optimisation. Reuse the first row and column as marker arrays, and handle them carefully using separate flags to avoid overwriting original information.
/* “To achieve constant extra space, I use the first row and first column of the matrix as marker arrays. Whenever I find a zero at (i, j), I mark (i, 0) and (0, j) as zero. I then use those markers to zero the remaining cells.
    Since the first row and column are themselves being used as markers, I separately track whether they originally contained zeros using two boolean variables.” */

class Solution {
    public void setZeroes(int[][] matrix) {
        // Tracks whether the original first row
        // contains a zero.
        boolean firstRow = false;
        // Tracks whether the original first column
        // contains a zero.
        boolean firstCol = false;
        // STEP 1:
        // Find zeros and use the first row/column
        // as markers.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    // Remember if first row originally
                    // contained a zero.
                    if (i == 0) firstRow = true;
                    // Remember if first column originally
                    // contained a zero.
                    if (j == 0) firstCol = true;
                    // Mark this column
                    matrix[0][j] = 0;
                    // Mark this row
                    matrix[i][0] = 0;
                }
            }
        }
        // STEP 2:
        // Use the markers to zero out the remaining
        // cells, excluding the first row and column.
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                // If the row or column was marked,
                // this cell needs to become zero.
                if (matrix[i][0] == 0 ||
                    matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // STEP 3:
        // Handle first row separately because its values
        // were also being used as column markers.
        if (firstRow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        // STEP 4:
        // Handle first column separately because its values
        // were also being used as row markers.
        if (firstCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

// Time Complexity :- O(m * n).
// Space Complexity :- O(1).

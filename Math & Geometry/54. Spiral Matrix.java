/*********************************************** JAVA **************************************************/

// Optimal Solution - Layer-by-layer traversal to collect matrix elements in spiral order using boundary pointers. Use four pointers to track the current layer and shrink them after each directional traversal.
/* “I maintain four boundaries representing the unvisited portion of the matrix: top, bottom, left, and right. 
    In each iteration, I traverse right across the top, down the right side, left across the bottom, and up the left side. After each traversal I shrink the corresponding boundary. 
    I use boundary checks before the left and upward traversals to avoid processing elements twice when the remaining region collapses.” */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        // Handle empty matrix
        if (matrix.length == 0) return res;
        // Define the four boundaries
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        // Continue while there is still an unvisited region
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // 1. Traverse from LEFT → RIGHT
            // across the top row.
            for (int j = colBegin; j <= colEnd; j++) {
                res.add(matrix[rowBegin][j]);
            }
            // Top row is completely processed
            rowBegin++;
            // 2. Traverse from TOP → BOTTOM
            // down the right column.
            for (int j = rowBegin; j <= rowEnd; j++) {
                res.add(matrix[j][colEnd]);
            }
            // Right column is completely processed
            colEnd--;
            // 3. Traverse from RIGHT → LEFT
            // across the bottom row.
            // Check that a valid row still exists.
            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j--) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            // Bottom row is completely processed
            rowEnd--;
            // 4. Traverse from BOTTOM → TOP
            // up the left column.
            // Check that a valid column still exists.
            if (colBegin <= colEnd) {
                for (int j = rowEnd; j >= rowBegin; j--) {
                    res.add(matrix[j][colBegin]);
                }
            }
            // Left column is completely processed
            colBegin++;
        }
        return res;
    }
}

// Time Complexity :- O(N * M).
// Space Complexity :- O(N * M).

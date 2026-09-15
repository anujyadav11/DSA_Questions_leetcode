/*********************************************** JAVA **************************************************/

// Optimal Solution - In-place rotation of a matrix by 90° clockwise using transpose and row reversal. Transpose the matrix first, then reverse each row to achieve a clockwise rotation without extra space.
/*“ I can rotate the matrix clockwise by decomposing the operation into two simpler operations. First, I transpose the matrix by swapping elements across the main diagonal.   
    Then I reverse every row. This produces the same result as a 90-degree clockwise rotation while using constant extra space.” */

class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        // Step 1: Transpose the matrix
        // Swap matrix[i][j] with matrix[j][i].
        // We start j from i + 1 so that:
        // 1. We don't swap diagonal elements.
        // 2. We don't swap the same pair twice.
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Step 2: Reverse every row
        // After transposing, reversing each row
        // produces a 90-degree clockwise rotation.
        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = m - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}

// Time Complexity :- O(n^2).
// Space Complexity :- O(1).

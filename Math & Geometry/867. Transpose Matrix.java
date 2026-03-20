/*********************************************** JAVA **************************************************/

// Optimal Solution - Returns the transpose of a matrix by mapping each element from position (i, j) to (j, i) in a new m×n grid.
/* "Transpose is just index swapping — (i, j) becomes (j, i). The key thing to watch is the output dimensions flip from n×m to m×n, 
    which matters for non-square matrices — a common edge case interviewers test." */

class Solution {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length; // number of rows in original matrix
        int m = matrix[0].length; // number of columns in original matrix
        int res[][] = new int[m][n]; // transposed matrix has dimensions m x n
        for (int i = 0; i < n; i++) { // iterate over each row
            for (int j = 0; j < m; j++) { // iterate over each column
                res[j][i] = matrix[i][j]; // element at (i,j) goes to (j, i)
            }
        }
        return res; // return the transposed matrix
    }
}

// Time Complexity :- O(n * m).
// Space Complexity :- O(n * m).

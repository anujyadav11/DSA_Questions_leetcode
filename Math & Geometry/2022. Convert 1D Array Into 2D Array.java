/*********************************************** JAVA **************************************************/

// Optimal Solution - Converts a 1D array into an m×n 2D array using the standard index mapping row = i/n, col = i%n.
/* "The key insight is the index formula — i/n gives the row and i%n gives the column. This works because every n elements fill one row. 
    Always validate original.length == m*n first since an invalid reshape must return empty." */

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        // allocate the result 2D array of size m x n
        int[][] res = new int[m][n];
        // if total elements don't match, return empty 2D array
        if (original.length != m * n)
            return new int[][] {};
        for (int i = 0; i < original.length; i++) {
            // map 1D index to 2D row using integer division
            int row = i / n;
            // map 1D index to 2D col using modulo
            int col = i % n;
            // place element at correct 2D position
            res[row][col] = original[i];
        }
        // return the fully constructed 2D array
        return res;
    }
}

// Time Complexity :- O(m * n).
// Space Complexity :- O(m * n).

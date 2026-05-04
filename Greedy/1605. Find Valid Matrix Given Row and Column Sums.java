/*********************************************** JAVA **************************************************/

// Optimal Solution - Restores a matrix from row and column sums by greedily placing the minimum of remaining constraints at each cell and advancing the exhausted pointer.
/* "The greedy works because total row sum always equals total column sum — so exhausting one row always leaves enough in columns (and vice versa). 
    Placing the minimum at each step ensures we never over-allocate to any row or column. The two-pointer advances linearly, making this O(rows + cols) rather than O(rows × cols)." */

class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;
        int[][] resMat = new int[rows][cols];
        int r = 0, c = 0;
        while (r < rows && c < cols) {
            // place minimum of remaining row and column sums
            int minVal = Math.min(rowSum[r], colSum[c]);
            resMat[r][c] = minVal;
            rowSum[r] -= minVal;
            colSum[c] -= minVal;
            // advance pointer whose sum is exhausted
            if (rowSum[r] == 0) r++;
            else c++;
        }
        return resMat;
    }
}

// Time Complexity :- O(m + n).
// Space Complexity :- O(m * n).

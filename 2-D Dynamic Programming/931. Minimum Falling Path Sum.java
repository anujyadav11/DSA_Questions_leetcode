/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds minimum falling path sum using row-by-row DP where each cell takes the minimum of three valid predecessors from the row above.
/* "Three predecessors — directly above, left diagonal, right diagonal — with Integer.MAX_VALUE sentinels for out-of-bounds cases. Space optimization: only need previous row to compute current, 
    so two O(n) arrays suffice instead of O(n²). For the 'non-adjacent columns' variant (LC 1289), track top-2 minimums per row instead of all values." */

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        // base case: first row values are starting points
        for (int i = 0; i < n; i++)
            dp[0][i] = matrix[0][i];
        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                // left diagonal — guard against out of bounds
                int left = col - 1 >= 0 ? dp[row - 1][col - 1] : Integer.MAX_VALUE;
                // right diagonal — guard against out of bounds
                int right = col + 1 < n ? dp[row - 1][col + 1] : Integer.MAX_VALUE;
                // minimum of directly above, left diagonal, right diagonal
                dp[row][col] = matrix[row][col] + Math.min(dp[row - 1][col], Math.min(left, right));
            }
        }
        // find minimum in last row
        int res = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++)
            res = Math.min(res, dp[n - 1][col]);
        return res;
    }
}

// Time Complexity :- O(n^2).
// Space Complexity :- O(n^2).

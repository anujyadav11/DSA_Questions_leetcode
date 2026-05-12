/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts all squares of ones by computing the largest square ending at each cell using the three-neighbor minimum DP recurrence and summing all values.
/* "The key insight is that dp[i][j] counts not just one square but all squares ending at that cell — a value of 3 means squares of size 1×1, 2×2, and 3×3 all end here. 
    Summing the entire DP table gives the total count directly. This same recurrence solves 'Maximal Square' — just track the maximum instead of the sum." */

class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        // initialize first row
        for (int j = 0; j < m; j++)
            dp[0][j] = matrix[0][j];
        // initialize first column
        for (int i = 0; i < n; i++)
            dp[i][0] = matrix[i][0];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0)
                    dp[i][j] = 0;
                else
                    // dp[i][j] = largest square ending at (i,j) as bottom-right corner
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
            }
        }
        // sum all dp values — each dp[i][j] counts squares of size 1 to dp[i][j]
        int sum = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                sum += dp[i][j];
        return sum;
    }
}

// Time Complexity :- O(m * n).
// Space Complexity :- O(m * n).

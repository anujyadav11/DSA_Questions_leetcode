/*********************************************** JAVA **************************************************/

// Optimal Solution - Interval DP solution that maximizes coins by choosing the last balloon to burst in each subarray. Think in reverse: instead of bursting first, assume one balloon is burst last—this fixes its neighbors and enables interval DP.
/* “I use interval DP and consider each balloon as the last balloon to burst in a given interval. When a balloon is burst last, its neighboring balloons are fixed, so its contribution is left × current × right. 
    The balloons on both sides become independent subproblems. I take the maximum over every possible last balloon.” */

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // Add dummy balloons with value 1
        // at both ends.
        int[] a = new int[n + 2];
        a[0] = 1;
        for (int i = 0; i < n; i++) {
            a[i + 1] = nums[i];
        }
        a[n + 1] = 1;
        // dp[i][j] = maximum coins we can collect
        // by bursting all balloons from index i to j.
        int[][] dp = new int[n + 2][n + 2];
        // Process smaller intervals before larger intervals.
        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                // Try every balloon as the LAST balloon
                // to burst in the interval [i, j].
                for (int ind = i; ind <= j; ind++) {
                    int coins =
                            a[i - 1] * a[ind] * a[j + 1] + dp[i][ind - 1] + dp[ind + 1][j];
                    // We want the maximum number of coins.
                    dp[i][j] = Math.max(dp[i][j], coins);
                }
            }
        }
        return dp[1][n];
    }
}

// Time Complexity :- O(n^3).
// Space Complexity :- O(n^2).

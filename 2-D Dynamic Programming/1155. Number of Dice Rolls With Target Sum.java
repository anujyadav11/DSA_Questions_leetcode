/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts dice roll combinations reaching target sum using 2D DP, where each state sums ways from all valid previous face values.
/* "This is an unbounded knapsack variant — each die contributes 1 to k to the sum. The rolling array optimisation reduces space to O(target) by noting dp[i] 
    only depends on dp[i-1] — process j in forward order with a single 1D array updated per dice count. Always apply modulo inside the inner loop to prevent overflow before accumulation." */

class Solution {
    int mod = (int) 1e9 + 7;
    public int numRollsToTarget(int n, int k, int target) {
        // dp[i][j] = number of ways to get sum j using exactly i dice
        int[][] dp = new int[n + 1][target + 1];
        // base case: 0 dice, sum 0 — exactly one way (do nothing)
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                int ways = 0;
                // try each face value 1 to k
                for (int face = 1; face <= k; face++) {
                    if (j >= face)
                        ways = (ways + dp[i - 1][j - face]) % mod;
                }
                dp[i][j] = ways;
            }
        }
        // return ways to get exactly target using exactly n dice
        return dp[n][target];
    }
}

// Time Complexity :- O(n × target × k).
// Space Complexity :- O(n × target).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Maximizes partitioned array sum using DP where each state tries all valid partition sizes up to k, replacing partition elements with their maximum value.
/* "The partition insight is that all elements in a subarray become the maximum — so greedily we want large maximums over large windows. The DP tries all window sizes 1 to k ending at each position, 
    tracking the running maximum. Initialize curMax to 0 not -1 for non-negative arrays — wrong initialization causes subtle failures on zero-valued elements." */

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        // dp[i] = maximum sum for first i elements
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int curMax = 0;
            // try all partition sizes from 1 to k ending at index i
            for (int j = 1; j <= k && i - j >= 0; j++) {
                // track max element in current partition window
                curMax = Math.max(curMax, arr[i - j]);
                // partition of size j ending at i: j * curMax + best before it
                dp[i] = Math.max(dp[i], j * curMax + dp[i - j]);
            }
        }
        return dp[n];
    }
}

// Time Complexity :- O(n * k).
// Space Complexity :- O(n).

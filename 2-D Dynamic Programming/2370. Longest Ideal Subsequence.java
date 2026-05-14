/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds longest ideal subsequence using DP over character alphabet, extending the best valid predecessor within k-distance at each position.
/* "The dp array indexed by character (not position) is the key space optimization — we only need the best subsequence ending at each of 26 characters, not all positions. 
    The 2k+1 window scan is bounded by 26 regardless of k — so the inner loop is effectively O(1), making the overall solution O(n)." */

class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        // dp[c] = longest ideal subsequence ending with character c
        int[] dp = new int[26];
        int res = 0;
        for (int i = 0; i < n; i++) {
            int curr = s.charAt(i) - 'a';
            // valid predecessor characters within k distance
            int left = Math.max(0, curr - k);
            int right = Math.min(25, curr + k);
            int longest = 0;
            // find best subsequence ending at any valid predecessor
            for (int j = left; j <= right; j++)
                longest = Math.max(longest, dp[j]);
            // extend best predecessor subsequence with current character
            dp[curr] = Math.max(dp[curr], longest + 1);
            res = Math.max(res, dp[curr]);
        }
        return res;
    }
}

// Time Complexity :- O(n + 26).
// Space Complexity :- O(26).

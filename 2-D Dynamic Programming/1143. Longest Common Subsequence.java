/*********************************************** JAVA **************************************************/

// Optimal Solution - Dynamic programming solution to compute the longest common subsequence between two strings. Define DP on prefixes of both strings and build the answer by matching or skipping characters optimally.
/* “I use a 2D DP table where dp[i][j] represents the LCS length between the first i characters of text1 and the first j characters of text2. 
    If the current characters match, I add one to the diagonal value. Otherwise, I take the maximum of the values obtained by skipping a character from either string.” */

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        // dp[i][j] = LCS length of first i chars of text1
        // and first j chars of text2
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // Characters match, so include this character
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } 
                else {
                    // Skip one character from either string
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}

// Time Complexity :- O(n x m).
// Space Complexity :- O(n x m).

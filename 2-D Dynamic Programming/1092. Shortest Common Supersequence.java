/*********************************************** JAVA **************************************************/

// Optimal Solution - Builds shortest common supersequence by computing LCS via DP and backtracking to include each character exactly once from both strings.
/* "SCS length = n + m - LCS(s1, s2) — the LCS is shared so counted once. Backtracking the DP table reconstructs the actual string: matching chars appear once, 
    non-matching chars follow the larger LCS direction. The dp[0][0] initialization bug is subtle — zero is correct for empty string LCS, and adding a special case there corrupts the boundary conditions." */
  
class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        // dp[i][j] = length of LCS of s1[0..i-1] and s2[0..j-1]
        int[][] dp = new int[n + 1][m + 1];
        // dp[0][j] and dp[i][0] remain 0 — correct base cases for LCS
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        // backtrack to build SCS
        int i = n, j = m;
        StringBuilder ans = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                // matching char — part of LCS, include once
                ans.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                // came from s1 — include s1 char
                ans.append(s1.charAt(i - 1));
                i--;
            } else {
                // came from s2 — include s2 char
                ans.append(s2.charAt(j - 1));
                j--;
            }
        }
        // append remaining characters from either string
        while (i > 0) {
            ans.append(s1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            ans.append(s2.charAt(j - 1));
            j--;
        }
        return ans.reverse().toString();
    }
}

// Time Complexity :- O(m * n).
// Space Complexity :- O(m * n).

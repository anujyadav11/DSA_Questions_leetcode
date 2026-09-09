/*********************************************** JAVA **************************************************/

// Optimal Solution - Top-down DP solution to check if a string is an interleaving of two others using memoisation. Define DP on indices of both strings and match characters greedily against the third string while caching overlapping subproblems.
/* “I define dp[i][j] as whether the first i characters of s1 and first j characters of s2 can form the first i + j characters of s3. At each state, 
    I check whether the next character can come from s1 or s2. A key observation is that the position in s3 is always i + j, so I only need a 2D DP table.” */

class Solution {
    // Lengths of s1, s2, and s3
    int m, n, N;
    // Memoization table: t[i][j] stores whether
    // s3[i+j...] can be formed using s1[i...] and s2[j...]
    Boolean t[][];
    public boolean solve(int i, int j, String s1, String s2, String s3) {
        // If both strings are fully consumed, interleaving is valid
        if (i == m && j == n)
            return true;
        // Return cached result if already computed
        if (t[i][j] != null)
            return t[i][j];
        boolean res = false;
        // Try taking next character from s1 if it matches s3
        if (i < m && s1.charAt(i) == s3.charAt(i + j)) {
            res = solve(i + 1, j, s1, s2, s3);
        }
        // If not successful, try taking the next character from s2
        if (!res && j < n && s2.charAt(j) == s3.charAt(i + j)) {
            res = solve(i, j + 1, s1, s2, s3);
        }
        // Store and return the result for state (i, j)
        return t[i][j] = res;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        // Store lengths
        m = s1.length();
        n = s2.length();
        N = s3.length();
        // If total lengths don't match, interleaving is impossible
        if (m + n != N)
            return false;
        // Initialize memoization table
        t = new Boolean[m + 1][n + 1];
        // Start recursion from index 0 of both strings
        return solve(0, 0, s1, s2, s3);
    }
}
// Optimal 2D DP solution - Determine whether a string can be formed by interleaving two strings using 2D dynamic programming.

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        // s1 and s2 together must contain exactly all characters of s3
        if (m + n != s3.length()) {
            return false;
        }
        // dp[i][j] = whether first i chars of s1 and first j chars of s2
        // can form the first i + j chars of s3
        boolean[][] dp = new boolean[m + 1][n + 1];
        // Empty s1 and empty s2 can form empty s3
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // Position in s3 is determined by i + j
                int k = i + j;
                // Take the current character from s1
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(k - 1)) {
                    dp[i][j] |= dp[i - 1][j];
                }
                // Take the current character from s2
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(k - 1)) {
                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}

// Time Complexity :- O(m * n).
// Space Complexity :- O(m * n).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Use dynamic programming to count decoding ways by validating one-digit and two-digit mappings at each step. At each index, I check whether the last one or two characters form valid encodings and build the solution bottom-up.

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        // dp[i] = number of ways to decode first i characters
        int[] dp = new int[n + 1];
        // Empty string has one valid decoding
        dp[0] = 1;
        // First character cannot be zero
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            // Decode current character as a single digit
            int oneDig = Integer.valueOf(s.substring(i - 1, i));
            // Decode last two characters as one number
            int towDig = Integer.valueOf(s.substring(i - 2, i));
            // 1-9 can be decoded individually
            if (oneDig >= 1) {
                dp[i] += dp[i - 1];
            }
            // 10-26 can be decoded as a pair
            if (towDig >= 10 && towDig <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(N).

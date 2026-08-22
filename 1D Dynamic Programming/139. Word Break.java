/*********************************************** JAVA **************************************************/

// Optimal Solution - Use dynamic programming to check whether a string can be segmented by validating dictionary words ending at each index. At each index, I only check substrings up to the maximum dictionary word length to optimize the DP.

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Store dictionary for O(1) average lookup
        Set<String> wordSet = new HashSet<>(wordDict);
        // Maximum dictionary word length
        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }
        int n = s.length();
        // dp[i] = can s[0...i-1] be formed using dictionary words?
        boolean[] dp = new boolean[n + 1];
        // Empty string can always be formed
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            // Check only possible word lengths
            for (int j = i - 1; j >= Math.max(0, i - maxLen); j--) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // Stop once a valid split is found
                }
            }
        }
        return dp[n];
    }
}

// Time Complexity :- O(n^2).
// Space Complexity :- O(n).

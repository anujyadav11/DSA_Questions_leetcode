/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds longest word chain using length-sorted DP where each word checks all shorter predecessors via single-deletion two-pointer subsequence matching.
/*  "Sorting by length is the key enabler — it guarantees predecessors always appear at earlier indices, making the DP transition valid. The predecessor check is elegant: 
    use two pointers allowing one skip in curr — if all of prev matches in order, exactly one character was added. This is O(L) vs O(L²) for the naive deletion approach." */

class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        // sort by word length — shorter words must come before longer ones
        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        // dp[i] = longest chain ending at words[i]
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // check if words[j] is a predecessor of words[i]
                if (isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
        return maxLen;
    }
    public boolean isPredecessor(String prev, String curr) {
        int m = prev.length();
        int n = curr.length();
        // predecessor must be exactly one character shorter
        if (n - m != 1) return false;
        // check if prev can be obtained by removing one char from curr
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (prev.charAt(i) == curr.charAt(j))
                i++;
            j++;
        }
        // all chars of prev matched in order within curr
        return i == m;
    }
}

// Time Complexity :- O(n^2 * L).
// Space Complexity :- O(n).

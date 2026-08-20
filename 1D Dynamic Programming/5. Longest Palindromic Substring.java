/*********************************************** JAVA **************************************************/

// Optimal Solution - Find the longest palindromic substring by expanding around each possible centre. For each index, I expand around it as a centre for both odd and even palindromes and keep track of the maximum length found.
/* “I use a 2D memoization table where t[i][j] stores whether the substring from i to j is a palindrome. A substring is a palindrome when its boundary characters match and its inner substring is also a palindrome. 
    I enumerate all possible start and end positions and keep track of the longest valid palindrome. Memoization ensures each interval is evaluated only once.” */


class Solution {
    int[][] t;
    // Check whether s[i...j] is a palindrome
    boolean solve(String s, int i, int j) {
        // Empty or single-character substring
        if (i >= j)
            return true;
        // Return memoized result
        if (t[i][j] != -1)
            return t[i][j] == 1;
        // Boundary characters must match
        if (s.charAt(i) == s.charAt(j)) {
            boolean result = solve(s, i + 1, j - 1);
            t[i][j] = result ? 1 : 0;
            return result;
        }
        t[i][j] = 0;
        return false;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        // -1 = not calculated, 0 = false, 1 = true
        t = new int[n][n];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        int maxLen = 0;
        int sp = 0;
        // Try every possible substring
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (solve(s, i, j)) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        sp = i;
                    }
                }
            }
        }
        return s.substring(sp, sp + maxLen);
    }
}

// Time Complexity :- O(N^2).
// Space Complexity :- O(1).

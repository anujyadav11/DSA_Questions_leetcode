/*********************************************** JAVA **************************************************/

// Optimal Solution - Matches a string against a regex pattern using DFS + memoization with support for. and * in O(mn) time and space.
/* “I use DFS with memoisation where dfs(i,j) represents whether the suffix of the string starting at i matches the pattern suffix starting at j. 
    For a normal character or dot, both pointers advance. When the next pattern character is *, I consider two choices: skip the x* completely, or, 
    if the current characters match, consume one character from the string while keeping the pattern pointer on x*. Memoisation prevents recalculating the same (i,j) state.” */

class Solution {
    public boolean isMatch(String s, String p) {
        // cache[i][j] stores whether s[i...] matches p[j...].
        // null means this state has not been calculated yet.
        Boolean[][] cache = new Boolean[s.length() + 1][p.length() + 1];
        // Start matching from the beginning of both strings.
        return dfs(cache, s, p, 0, 0);
    }
    private boolean dfs(Boolean[][] cache,String s,String p,int i,int j) {
        // Return the already calculated result for this state.
        if (cache[i][j] != null) return cache[i][j];
        // Both strings are completely consumed.
        // Therefore, the pattern matches successfully.
        if (i == s.length() && j == p.length()) return true;
        // Pattern is exhausted while characters are still
        // remaining in s, so matching is impossible.
        if (j == p.length()) return false;
        // Check whether the current characters match.
        // A character matches when:
        // 1. s[i] == p[j]
        // 2. p[j] == '.'
        boolean match =i < s.length() &&(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        // If the next pattern character is '*',
        // we have two choices:
        // 1. Ignore "x*" completely -> j + 2
        // 2. If current characters match, consume one character
        //    from s while keeping '*' available -> i + 1, j
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            cache[i][j] = dfs(cache, s, p, i, j + 2)||(match && dfs(cache, s, p, i + 1, j));
        } else {
            // No '*':
            // Current characters must match and both pointers
            // move forward by one.
            cache[i][j] = match && dfs(cache, s, p, i + 1, j + 1);
        }
        return cache[i][j];
    }
}

// Time Complexity :- O(m*n).
// Space Complexity :- O(m*n).

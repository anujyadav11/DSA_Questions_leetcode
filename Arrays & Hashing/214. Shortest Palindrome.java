/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds shortest palindrome by prepending minimum characters using KMP LPS on s+"#"+reverse(s) to identify the longest palindromic prefix.
/* "The # separator is critical — without it, LPS could match characters across the boundary between s and rev, giving wrong results. 
    The last LPS value tells us how much of s from the start already forms a palindrome — prepend only the remaining reversed suffix. 
    This is O(n) vs O(n²) for naive palindrome checking." */

class Solution {
    // compute LPS (Longest Proper Prefix which is also Suffix) array using KMP
    public void computeLPS(String pattern, int[] lps) {
        int M = pattern.length();
        int len = 0;
        // lps[0] always 0 — no proper prefix/suffix for single char
        lps[0] = 0;
        int i = 1;
        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                // characters match — extend current prefix-suffix length
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0)
                    // fall back to previous longest prefix-suffix
                    len = lps[len - 1];
                else {
                    // no prefix-suffix possible at this position
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
    public String shortestPalindrome(String s) {
        // reverse of s
        String rev = new StringBuilder(s).reverse().toString();
        // separator prevents cross-boundary matches in LPS
        String temp = s + "#" + rev;
        int[] lps = new int[temp.length()];
        computeLPS(temp, lps);
        // lps last value = length of longest palindromic prefix of s
        int longestPalPrefix = lps[temp.length() - 1];
        // characters in rev not part of palindromic prefix need to be prepended
        String toAdd = rev.substring(0, s.length() - longestPalPrefix);
        return toAdd + s;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

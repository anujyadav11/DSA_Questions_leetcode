/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds the longest common prefix by sorting the strings and comparing the lexicographically smallest and largest strings.
/* “I sort the strings lexicographically and compare only the first and last strings. Any prefix common to every string must also be common to these two extreme strings. Therefore, 
    I scan them character by character until the first mismatch.” */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        // Sort strings lexicographically.
        Arrays.sort(strs);
        // The first and last strings have the maximum
        // possible difference in their prefixes.
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();
        // Compare only while both strings have characters.
        int len = Math.min(first.length, last.length);
        for (int i = 0; i < len; i++) {
            // Stop at the first mismatch.
            if (first[i] != last[i]) {
                break;
            }
            res.append(first[i]);
        }
        return res.toString();
    }
}

// Time Complexity :- O(n log n + l).
// Space Complexity :- O(l).

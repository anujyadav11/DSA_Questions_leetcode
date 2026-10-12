/*********************************************** JAVA **************************************************/

// Optimal Solution - Merge two strings alternately using two pointers and StringBuilder in O(n + m) time.
/* “I use two pointers to traverse both strings and append their characters alternately. If one string is exhausted, 
    I continue appending characters from the other. This takes O(n + m) time.” */

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int n = word1.length();
        int m = word2.length();
        int i = 0;
        int j = 0;
        // Alternate characters from both strings while either has characters left.
        while (i < n || j < m) {
            // Append the next character from word1, if available.
            if (i < n) {
                sb.append(word1.charAt(i));
                i++;
            }
            // Append the next character from word2, if available.
            if (j < m) {
                sb.append(word2.charAt(j));
                j++;
            }
        }
        return sb.toString();
    }
}

// Time Complexity :- O(n + m).
// Space Complexity :- O(n + m).

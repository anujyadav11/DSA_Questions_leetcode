/*********************************************** JAVA **************************************************/

// Optimal Solution - Use two pointers to match t as a subsequence of s and append the remaining unmatched characters.
                    // “I greedily match t as a subsequence inside s using two pointers, and the unmatched suffix of t is the number of characters to append.”

class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0;   // Pointer for string s
        int j = 0;   // Pointer for string t
        // Traverse both strings
        while (i < s.length() && j < t.length()) {
            // If characters match, move both pointers
            if (s.charAt(i) == t.charAt(j)) {
                j++;
                i++;
            } 
            else {
                // Otherwise move pointer in s
                i++;
            }
        }
        // Remaining characters in t must be appended
        return t.length() - j;
    }
}

// Time Complexity :- O(n). n is the length of s.
// Space Complexity :- O(1).

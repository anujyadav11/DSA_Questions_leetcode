/*********************************************** JAVA **************************************************/

// Optimal Solution - Compare two string arrays character-by-character using a two-pointer traversal without building the concatenated strings.
                      // Instead of concatenating both arrays into full strings, which would cost extra memory, 
                      // I simulate the traversal using two pointers across both arrays and compare characters directly.

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // Pointers for arrays
        int i = 0, j = 0;
        // Pointers for characters inside each string
        int p1 = 0, p2 = 0;
        // Traverse both arrays
        while (i < word1.length && j < word2.length) {
            // Compare current characters
            if (word1[i].charAt(p1) != word2[j].charAt(p2)) {
                return false; // mismatch found
            }
            // Move character pointers
            p1++;
            p2++;
            // If end of current string in word1 reached → move to next string
            if (p1 == word1[i].length()) {
                i++;
                p1 = 0;
            }
            // If end of current string in word2 reached → move to next string
            if (p2 == word2[j].length()) {
                j++;
                p2 = 0;
            }
        }
        // Both arrays must be completely traversed
        return i == word1.length && j == word2.length;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

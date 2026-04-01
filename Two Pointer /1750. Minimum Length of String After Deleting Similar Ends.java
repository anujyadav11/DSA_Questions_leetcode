/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds minimum string length after repeatedly removing matching prefix-suffix characters using an inward two-pointer approach.

/* "The key insight is removing ALL copies of the matching character from both ends in one step — not just one at a time. The inner while loops handle this efficiently. 
    The subtle guard j >= i in the right inner loop prevents j from crossing below i when all remaining characters are the same." */

class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;
        // shrink from both ends while outer characters match
        while (i < j && s.charAt(i) == s.charAt(j)) {
            // store the matching character to remove all its copies from both ends
            char ch = s.charAt(i);
            // move i past all consecutive ch from the left
            while (i < j && s.charAt(i) == ch)
                i++;
            // move j past all consecutive ch from the right
            while (j >= i && s.charAt(j) == ch)
                j--;
        }
        // remaining length between i and j inclusive
        return j - i + 1;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

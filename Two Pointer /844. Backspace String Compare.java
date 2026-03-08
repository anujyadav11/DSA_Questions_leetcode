/*********************************************** JAVA **************************************************/

// Optimal Solution - Compare two strings with backspaces using a reverse two-pointer approach without building the final strings.

class Solution {
    public boolean backspaceCompare(String s, String t) {
        // Start pointers from the end of both strings
        int i = s.length() - 1;
        int j = t.length() - 1;
        int back; // Tracks how many characters should be skipped due to '#'
        while (true) {
            // Process string s
            back = 0;
            // Skip characters affected by backspaces
            while (i >= 0 && (back > 0 || s.charAt(i) == '#')) {
                // If '#', increase backspace count
                // Otherwise consume one backspace
                back += s.charAt(i) == '#' ? 1 : -1;
                // Move pointer left
                i--;
            }
            // Process string t
            back = 0;
            // Skip characters affected by backspaces
            while (j >= 0 && (back > 0 || t.charAt(j) == '#')) {
                // Same logic for backspaces
                back += t.charAt(j) == '#' ? 1 : -1;
                // Move pointer left
                j--;
            }
            // If both pointers are valid and characters match
            if (i >= 0 && j >= 0 && s.charAt(i) == t.charAt(j)) {
                // Move both pointers left to compare next characters
                i--;
                j--;
            }
            else break; // Stop if mismatch or one string finished
        }
        // Both strings should be fully processed
        return i == -1 && j == -1;
    }
}

// Time Complexity :- O(n + m).
// Space Complexity :- O(1).

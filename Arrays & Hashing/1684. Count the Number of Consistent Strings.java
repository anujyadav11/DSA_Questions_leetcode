/*********************************************** JAVA **************************************************/

// Optimal Solution - Mark allowed characters and count words containing only allowed letters. 
                    // “I pre-mark allowed characters in a boolean array and verify each word contains only those characters.”

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        // Boolean array to mark allowed characters
        boolean[] allowedChars = new boolean[26];
        // Mark allowed characters
        for (char ch : allowed.toCharArray()) {
            allowedChars[ch - 'a'] = true;
        }
        int res = 0;  // Count of consistent words
        // Check each word
        for (String word : words) {
            boolean ok = true;
            // Check each character of word
            for (char ch : word.toCharArray()) {
                // If character not allowed → invalid
                if (!allowedChars[ch - 'a']) {
                    ok = false;
                    break;
                }
            }
            // If valid word, increment result
            if (ok) {
                res++;
            }
        }
        return res;
    }
}

// Time Complexity :- O(n * m).
// Space Complexity :- O(1).

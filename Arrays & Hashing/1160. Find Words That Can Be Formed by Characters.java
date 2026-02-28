/*********************************************** JAVA **************************************************/

// Optimal Solution - Use frequency arrays to validate each word against available characters and sum lengths of valid words.
                      // “Since only lowercase letters are involved, I use fixed-size arrays instead of HashMap for optimal constant space and faster access.”

class Solution {
    public int countCharacters(String[] words, String chars) {
        // Frequency array for available characters
        int[] charCount = new int[26];
        // Count frequency of each character in chars
        for (char ch : chars.toCharArray()) {
            charCount[ch - 'a']++;
        }
        int result = 0;  // Stores total length of valid words
        // Check each word
        for (String word : words) {
            // Frequency array for current word
            int[] wordCount = new int[26];
            // Count frequency of characters in word
            for (char ch : word.toCharArray()) {
                wordCount[ch - 'a']++;
            }
            boolean ok = true;  // Flag to check if word is valid
            // Compare frequencies
            for (int i = 0; i < 26; i++) {
                if (wordCount[i] > charCount[i]) {
                    ok = false;  // Word uses more chars than available
                    break;
                }
            }
            // If valid, add its length
            if (ok) {
                result += word.length();
            }
        }
        return result;
    }
}

// Time Complexity :- O(m * n).
// Space Complexity :- O(1).

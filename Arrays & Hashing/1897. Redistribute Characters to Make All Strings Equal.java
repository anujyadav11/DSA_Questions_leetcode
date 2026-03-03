/*********************************************** JAVA **************************************************/

// Optimal Solution - Count total character frequencies and ensure each is divisible by the number of words.
                    // "For equal redistribution, each character’s total frequency must be divisible by the number of words.”

class Solution {
    public boolean makeEqual(String[] words) {
        // Frequency array for all characters
        int[] count = new int[26];
        // Count total frequency of each character
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                count[ch - 'a']++;
            }
        }
        int size = words.length;  // Number of words
        // Check if each character frequency is divisible by number of words
        for (int i = 0; i < 26; i++) {
            if (count[i] % size != 0) {
                return false;
            }
        }
        return true;
    }
}

// Time Complexity :- O(n * m).
// Space Complexity :- O(1).

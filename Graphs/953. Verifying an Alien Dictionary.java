/*********************************************** JAVA **************************************************/

// Optimal Solution - Implemented custom alphabet ranking using an integer mapping array and adjacent lexicographical string comparison in O(N × L) time and O(1) auxiliary space.
/* "I first create a mapping that stores the position of every character in the alien alphabet. Then I compare adjacent words character by character. At the first differing character, 
    I compare their mapped positions to determine whether the ordering is valid. If all compared characters match, I ensure that the shorter word comes first. 
    If every adjacent pair satisfies these conditions, \the dictionary is sorted." */

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // Stores the ranking of each character in the alien alphabet.
        // Lower index means higher priority in the alien dictionary.
        int[] orderIndex = new int[26];
        // Build the character-to-order mapping.
        // Example: orderIndex['h' - 'a'] stores the position of 'h'.
        for (int i = 0; i < order.length(); i++) {
            orderIndex[order.charAt(i) - 'a'] = i;
        }
        // Compare every pair of adjacent words.
        // If all adjacent pairs are correctly ordered,
        // the entire array is sorted.
        for (int i = 0; i < words.length - 1; i++) {
            // Get the two words being compared.
            String w1 = words[i];
            String w2 = words[i + 1];
            // Pointer to compare characters at corresponding positions.
            int j = 0;
            // Compare characters until a difference is found
            // or the first word is completely traversed.
            for (; j < w1.length(); j++) {
                // If the second word ends before the first word
                // and all previous characters were equal,
                // the ordering is invalid.
                if (j == w2.length()) {
                    return false;
                }
                // Find the first position where the characters differ.
                if (w1.charAt(j) != w2.charAt(j)) {
                    // Compare their positions in the alien alphabet.
                    // If the first word's character comes later,
                    // the words are not sorted.
                    if (orderIndex[w1.charAt(j) - 'a'] >
                        orderIndex[w2.charAt(j) - 'a']) {
                        return false;
                    }
                    // A valid first differing character determines
                    // the ordering, so stop comparing this pair.
                    break;
                }
            }
        }
        // Every adjacent pair is correctly ordered.
        return true;
    }
}

// Time Complexity :- O(N * L).
// Space Complexity :- O(1).

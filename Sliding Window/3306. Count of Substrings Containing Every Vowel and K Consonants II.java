/*********************************************** JAVA **************************************************/

// Optimal Solution - Use sliding window with inclusion-exclusion to count substrings with exactly k consonants and all vowels.
/* “I convert the problem into counting substrings with at least k consonants and subtract those with at least k+1 using a sliding window.” */

class Solution {
    public long countOfSubstrings(String word, int k) {
        // Exactly k = atLeast(k) - atLeast(k+1)
        return atLeast(k, word) - atLeast(k + 1, word);
    }
    // Check if character is consonant
    public boolean isConsonant(char ch) {
        return (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u');
    }
    // Check if all 5 vowels are present at least once
    public boolean isAllVowel(int[] freq) {
        return (freq['a' - 'a'] > 0 &&
                freq['e' - 'a'] > 0 &&
                freq['i' - 'a'] > 0 &&
                freq['o' - 'a'] > 0 &&
                freq['u' - 'a'] > 0);
    }
    // Count substrings with at least k consonants and all vowels
    public long atLeast(int k, String word) {
        long count = 0;     // Result
        int currCon = 0;    // Current consonant count
        int[] freq = new int[26]; // Frequency of characters
        int left = 0;  // Left pointer
        // Expand window
        for (int right = 0; right < word.length(); right++) {
            char ch = word.charAt(right);
            // Update consonant count
            if (isConsonant(ch)) {
                currCon++;
            }
            // Update frequency
            freq[ch - 'a']++;
            // Shrink window while valid
            while (currCon >= k && isAllVowel(freq)) {
                // All substrings starting here are valid
                count += (word.length() - right);
                char c = word.charAt(left);
                // Remove left char from window
                if (isConsonant(c)) {
                    currCon--;
                }
                freq[c - 'a']--;
                left++;
            }
        }
        return count;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

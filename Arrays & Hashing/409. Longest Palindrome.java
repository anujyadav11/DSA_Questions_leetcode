/*********************************************** JAVA **************************************************/

// Optimal Solution - Count character frequencies and build the longest palindrome by summing even pairs and optionally adding one centre character.
                  // “A palindrome can use all even counts fully and at most one odd count in the centre, so I accumulate pairs and add one if any odd frequency exists.”

class Solution {
    public int longestPalindrome(String s) {
        // Frequency array for ASCII characters
        int[] count = new int[128]; 
        // Count occurrences of each character
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int length = 0;        // Stores maximum palindrome length
        boolean hasOdd = false; // Tracks if any character has odd frequency
        // Process each character frequency
        for (int freq : count) {
            // Add the largest even portion (pairs)
            length += (freq / 2) * 2;
            // Check if there's any leftover odd
            if (freq % 2 == 1) {
                hasOdd = true;
            }
        }
        // If any odd frequency exists,
        // we can place exactly one character in the centre
        if (hasOdd) {
            length += 1;
        }
        return length;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

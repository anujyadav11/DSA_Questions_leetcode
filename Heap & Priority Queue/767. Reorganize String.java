/*********************************************** JAVA **************************************************/

// Optimal Solution - Implemented a greedy character rearrangement algorithm using frequency counting and alternate index placement to avoid adjacent duplicate characters in O(n) time and O(n) space.
/* "I count the frequency of every character and identify the most frequent one. Before constructing the result, I check whether its frequency exceeds the maximum possible limit. If it does, I return an empty string. 
    Otherwise, I place the most frequent character at alternate even indices first, then fill the remaining even and odd positions with the other characters. 
    This greedy placement ensures that identical characters are separated." */

class Solution {
    public String reorganizeString(String s) {
        // Store the frequency of each lowercase English character.
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        // Find the character with the maximum frequency.
        int max = 0;
        int letter = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }
        // If the most frequent character appears more than
        // half the string length (rounded up), rearrangement
        // without adjacent duplicates is impossible.
        if (max > (s.length() + 1) / 2) {
            return "";
        }
        // Result array to store the reorganized string.
        char[] res = new char[s.length()];
        // Start placing characters at even indices: 0, 2, 4, ...
        int idx = 0;
        // Place the most frequent character first.
        // This separates its occurrences as much as possible.
        while (hash[letter]-- > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
        }
        // Place all remaining characters.
        for (int i = 0; i < hash.length; i++) {
            while (hash[i]-- > 0) {
                // Once all even positions are filled,
                // switch to odd positions: 1, 3, 5, ...
                if (idx >= res.length) {
                    idx = 1;
                }
                // Place the current character.
                res[idx] = (char) (i + 'a');
                // Move to the next alternate position.
                idx += 2;
            }
        }
        // Convert the character array into a String.
        return String.valueOf(res);
    }
}

// Time Complexity :- O(n). 
// Space Complexity :- O(n).

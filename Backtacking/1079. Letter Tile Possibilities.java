/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts all distinct tile sequences using backtracking on a frequency array, where each letter placement counts as a new sequence and frequency deduplicates identical tiles.
/* "The frequency array is the key — it automatically deduplicates identical tiles without sorting or visited sets. Each recursive call represents extending the current sequence by one letter, 
    and count++ before the recursive call counts the sequence ending at the current placement. The base case is implicit — when no letters remain, the loop finds nothing and returns 0." */

class Solution {
    public int numTilePossibilities(String tiles) {
        // frequency array for all uppercase letters
        int[] freq = new int[26];
        for (char c : tiles.toCharArray())
            freq[c - 'A']++;
        return backtrack(freq);
    }
    public int backtrack(int[] freq) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            // skip letters not available
            if (freq[i] == 0) continue;
            // place this letter — counts as one new sequence
            count++;
            freq[i]--;
            // add all sequences buildable after placing this letter
            count += backtrack(freq);
            // restore frequency for other branches
            freq[i]++;
        }
        return count;
    }
}

// Time Complexity :- O(n!).
// Space Complexity :- O(26).

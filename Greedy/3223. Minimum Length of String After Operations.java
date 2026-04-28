/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds minimum string length after symmetric deletions by keeping 2 characters for even frequencies and 1 for odd frequencies per character.
/* "The key insight is that symmetric deletion from both ends reduces each character's count by 2 per operation — so even frequencies reduce to 2 and odd frequencies reduce to 1. 
    No need to simulate deletions — pure frequency parity gives the answer in O(n). This is a common string reduction pattern worth recognizing immediately." */

class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];
        // count frequency of each character
        for (char c : s.toCharArray())
            freq[c - 'a']++;
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                // even frequency — keep 2, odd frequency — keep 1
                count += (freq[i] % 2 == 0) ? 2 : 1;
            }
        }
        // return minimum possible length after deletions
        return count;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(26).

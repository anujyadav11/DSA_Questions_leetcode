/*********************************************** JAVA **************************************************/

// Optimal Solution - Minimizes phone keypad presses by greedily assigning highest frequency letters to lowest press-count positions using sorted frequency counts.
/* "The key insight is that 8 keys each have multiple press levels — first 8 letters cost 1, next 8 cost 2, etc. cnt / 8 + 1 elegantly computes the press level for the cnt-th assigned letter. 
    Sorting by frequency and assigning greedily guarantees optimality — same principle as Huffman coding but with fixed cost levels." */
  
class Solution {
    public int minimumPushes(String word) {
        int[] count = new int[26];
        // count frequency of each letter
        for (char ch : word.toCharArray())
            count[ch - 'a']++;
        // sort ascending — process highest frequency first (descending)
        Arrays.sort(count);
        int cnt = 0;
        int minKeyPress = 0;
        for (int i = 25; i >= 0; i--) {
            if (count[i] == 0)
                break;
            // letters assigned to position 1-8 need 1 press
            // letters assigned to position 9-16 need 2 presses etc.
            int presses = cnt / 8 + 1;
            minKeyPress += count[i] * presses;
            cnt++;
        }
        return minKeyPress;
    }
}

// Time Complexity :- O(n + 26 log 26).
// Space Complexity :- O(26).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds longest substring with even vowel counts using 5-bit XOR state tracking, storing earliest occurrence of each parity state for maximum distance calculation.
/* "Five vowels give 2⁵ = 32 possible parity states — small enough for an array instead of HashMap. XOR toggles each vowel's parity bit — same state at two indices means even counts of all vowels between them. 
    Storing the earliest index maximizes substring length. This pattern generalizes to any small set of tracked characters." */

class Solution {
    public int findTheLongestSubstring(String s) {
        // bitmask value for each vowel — 5 vowels = 32 possible states
        int[] mapping = new int[26];
        mapping['a' - 'a'] = 1;
        mapping['e' - 'a'] = 2;
        mapping['i' - 'a'] = 4;
        mapping['o' - 'a'] = 8;
        mapping['u' - 'a'] = 16;
        // map[state] = earliest index where this XOR state was seen
        int[] map = new int[32];
        // -2 means state not yet seen
        Arrays.fill(map, -2);
        // state 0 seen before index 0 (empty prefix)
        map[0] = -1;
        int xor = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            // XOR current character's vowel bit into state
            xor ^= mapping[s.charAt(i) - 'a'];
            if (map[xor] == -2)
                // first time seeing this state — record index
                map[xor] = i;
            else
                // same state seen before — substring between has even vowel counts
                max = Math.max(max, i - map[xor]);
        }
        return max;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(32 + 26).

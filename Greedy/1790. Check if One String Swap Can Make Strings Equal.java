/*********************************************** JAVA **************************************************/

// Optimal Solution - Check if two strings can be made equal with at most one swap by tracking mismatched positions.
/* "I count mismatched positions. If there are exactly two mismatches, I check if swapping those characters makes the strings equal." */

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        // If both strings are already equal → no swap needed
        if (s1.equals(s2)) {
            return true;
        }
        int diffs = 0;       // Count of mismatched positions
        int firstIdx = 0;    // Index of first mismatch
        int secondIdx = 0;   // Index of second mismatch
        // Traverse both strings
        for (int i = 0; i < n; i++) {
            // If characters differ
            if (s1.charAt(i) != s2.charAt(i)) {
                diffs++;
                // More than 2 mismatches → impossible with one swap
                if (diffs > 2) {
                    return false;
                }
                // Store indices of mismatches
                else if (diffs == 1) {
                    firstIdx = i;
                } else {
                    secondIdx = i;
                }
            }
        }
        // Check if swapping makes strings equal
        return s1.charAt(firstIdx) == s2.charAt(secondIdx) &&
               s1.charAt(secondIdx) == s2.charAt(firstIdx);
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

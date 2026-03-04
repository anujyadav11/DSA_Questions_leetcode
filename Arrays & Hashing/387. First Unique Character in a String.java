/*********************************************** JAVA **************************************************/

// Optimal Solution - Count character frequencies and return the index of the first character with frequency one.

class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26]; // For 'a' to 'z'
        // Count frequency of each character
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        // Find first unique character
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1; // No unique character
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

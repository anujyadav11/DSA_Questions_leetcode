/*********************************************** JAVA **************************************************/

// Optimal Solution - Count magazine character frequencies and decrement while constructing ransomNote, returning false if any character runs out.
                      // “I use a frequency array for magazine and decrement counts while forming ransomNote. If any character count reaches zero before use, construction is impossible.”

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Frequency array for magazine characters
        int[] count = new int[26];
        // Count characters available in magazine
        for (char ch : magazine.toCharArray()) {
            count[ch - 'a']++;
        }
        // Try to construct ransomNote
        for (char ch : ransomNote.toCharArray()) {
            // If character not available → cannot construct
            if (count[ch - 'a'] == 0) {
                return false;
            }
            // Use one occurrence
            count[ch - 'a']--;
        }        
        return true;  // Successfully constructed
    }
}

// Time Complexity :- O(n + m).
// Space Complexity :- O(1).

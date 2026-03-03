/*********************************************** JAVA **************************************************/

// Optimal Solution - Store first occurrence of each character and compute maximum distance between repeating characters in one pass.
                      // “To maximise distance, I store only the first occurrence of each character and compute distance whenever it repeats.”

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int n = s.length();   // Length of string
        int[] count = new int[26];  
        // Initialize all values with -1 (means character not seen yet)
        Arrays.fill(count, -1);
        int res = -1;  // Default result if no valid pair found
        // Traverse string
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // If first time seeing this character
            if (count[ch - 'a'] == -1) {
                count[ch - 'a'] = i;  // Store first occurrence index
            } 
            else {
                // Compute distance excluding the equal characters
                res = Math.max(res, i - count[ch - 'a'] - 1);
            }
        }
        return res;  // Return maximum distance found
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

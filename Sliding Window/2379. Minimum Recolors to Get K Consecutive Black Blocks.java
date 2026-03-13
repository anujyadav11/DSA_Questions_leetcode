/*********************************************** JAVA **************************************************/

// Optimal Solution - Use a fixed-size sliding window to track the minimum number of white blocks that must be recolored.
/* "Since we only care about substrings of length k, I use a fixed sliding window and count the number of white blocks. 
    The minimum white count across all windows equals the minimum recolouring operations." */

class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length(); // Length of the blocks string
        int left = 0; // Left pointer of sliding window
        int right = 0; // Right pointer of sliding window
        int minOperations = k; // Maximum possible recolors is k
        int whiteCount = 0; // Number of white blocks in the current window
        // Expand the sliding window
        while (right < n) {
            // If the current block is white, increase the white counter
            if (blocks.charAt(right) == 'W') {
                whiteCount++;
            }
            // When the window size becomes exactly k
            if (right - left + 1 == k) {
                // Minimum recolours needed = number of white blocks in window
                minOperations = Math.min(minOperations, whiteCount);
                // Move the window forward by removing the left element
                if (blocks.charAt(left) == 'W') {
                    whiteCount--;
                }
                left++;
            }
            // Expand the window
            right++;
        }
        // Minimum recolours required
        return minOperations;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

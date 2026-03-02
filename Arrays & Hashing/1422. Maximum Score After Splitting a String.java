/*********************************************** JAVA **************************************************/

// Optimal Solution - Maximize score by tracking the best prefix difference (zeros - ones) and adding total ones.
                    // “I convert the scoring formula into maximizing a prefix difference (zeros - ones), which allows solving in one pass.”

class Solution {
    public int maxScore(String s) {
        int n = s.length();                  // Length of string
        int result = Integer.MIN_VALUE;      // Stores max (zeros - ones) so far
        int zeros = 0;  // Count of zeros on left side
        int ones = 0;   // Count of ones on left side
        // Traverse until second last character
        // (Right part must contain at least one character)
        for (int i = 0; i < n - 1; i++) {
            // Update counts for left partition
            if (s.charAt(i) == '1') {
                ones++;
            } else {
                zeros++;
            }
            // Maximize (zeros in left - ones in left)
            result = Math.max(result, zeros - ones);
        }
        // Add last character to total ones
        if (s.charAt(n - 1) == '1') {
            ones++;
        }
        // Final score = max(zeros - ones_left) + total_ones
        return result + ones;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

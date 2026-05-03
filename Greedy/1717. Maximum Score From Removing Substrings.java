/*********************************************** JAVA **************************************************/

// Optimal Solution - Maximizes string pair removal points by greedily processing the higher-value pair first via string reversal normalization, counting leftover pairs for the second pass.
/*  "The reversal trick is elegant — instead of writing two different greedy passes for ab and ba, normalize so the higher-value pair is always ab by reversing when needed. This reduces two cases to one. 
    The min(bCount, aCount) for leftover pairs correctly counts how many ba pairs can form from unmatched characters." */

class Solution {
    public int maximumGain(String s, int x, int y) {
        // ensure higher value pair is always processed first
        if (x < y) {
            // swap points so x always represents higher value pair
            int temp = x;
            x = y;
            y = temp;
            // reverse string so "ba" becomes "ab" — consistent with logic
            s = new StringBuilder(s).reverse().toString();
        }
        int aCount = 0;
        int bCount = 0;
        int totalPoints = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                // accumulate 'a' for potential "ab" pair
                aCount++;
            } else if (ch == 'b') {
                if (aCount > 0) {
                    // form "ab" pair — consume one 'a' and score x points
                    aCount--;
                    totalPoints += x;
                } else {
                    // no 'a' available — accumulate 'b' for potential "ba" pair
                    bCount++;
                }
            } else {
                // non a/b character — process remaining "ba" pairs from leftovers
                totalPoints += Math.min(bCount, aCount) * y;
                // reset for next segment
                aCount = bCount = 0;
            }
        }
        // process any remaining "ba" pairs after full traversal
        totalPoints += Math.min(bCount, aCount) * y;
        return totalPoints;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

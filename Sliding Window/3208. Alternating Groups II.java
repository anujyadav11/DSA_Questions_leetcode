/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts alternating color groups of size k on a circular array using a sliding window with modulo indexing and same-color reset.
/* The circular wrap is handled by iterating n + k - 1 steps with % n indexing — no array duplication needed. The window resets whenever two adjacent elements match since that breaks alternation. 
    When the window hits exactly size k, it's valid — shrink by incrementing left to slide forward for the next candidate." */

class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int left = 0;
        int res = 0;
        // iterate up to n+k-1 to handle circular wrap-around
        for (int right = 1; right < (n + k - 1); right++) {
            // if adjacent colors are same — reset window start to current right
            if (colors[right % n] == colors[(right - 1) % n])
                left = right;
            // window has reached size k — valid alternating group found
            if ((right - left + 1) == k) {
                left++;
                res++;
            }
        }
        // return total number of valid alternating groups
        return res;
    }
}

// Time Complexity :- O(n + k). n = colors size, k = window size; 
// Space Complexity :- O(1).

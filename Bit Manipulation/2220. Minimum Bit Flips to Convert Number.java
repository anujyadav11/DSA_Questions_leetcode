/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts differing bits using XOR and bit counting to compute minimum flips.

class Solution {
    public int minBitFlips(int start, int goal) {
        // XOR gives bits that are different between start and goal
        int xor = start ^ goal;
        // Count number of set bits in xor (these need flipping)
        int res = 0;
        // Traverse all bits of xor
        while (xor != 0) {
            // If last bit is 1 → increment flip count
            if ((xor & 1) == 1) res++;
            // Right shift to check next bit
            xor >>= 1;
        }
        return res;
    }
}

// Time Complexity :- O(log n).
// Space Complexity :- O(1).

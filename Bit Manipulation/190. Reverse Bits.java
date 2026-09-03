/*********************************************** JAVA **************************************************/

// Optimal Solution - Bit manipulation approach that reverses all 32 bits of an integer by mirroring each bit position. Read bits from left to right and rebuild the number by placing each bit at its reversed index.
/* “I process all 32 bits from right to left. At each step, I left-shift the result to create space, 
    extract the least significant bit of n using n & 1, append it using OR, and unsigned-right-shift n to process the next bit.” */

class Solution {
    public int reverseBits(int n) {
        if (n == 0)
            return 0;
        int res = 0;
        // Process all 32 bits
        for (int i = 1; i <= 32; i++) {
            // Make space for the next bit
            res <<= 1;
            // Add the last bit of n to result
            res = res | (n & 1);
            // Remove the processed bit
            n >>>= 1;
        }
        return res;
    }
}

// Time Complexity :- O(32) ~ O(1).
// Space Complexity :- O(1).

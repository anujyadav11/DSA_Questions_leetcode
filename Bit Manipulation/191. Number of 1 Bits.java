/*********************************************** JAVA **************************************************/

// Optimal Solution - Bit-by-bit approach to count the number of set bits in an integer using right shifts. Repeatedly check the least significant bit and shift right until the number becomes zero.

class Solution {
    public int hammingWeight(int n) {
        // Variable to count number of set bits (1s)
        int res = 0;
        // Loop until all bits are processed
        while (n > 0) {
            // Add 1 if the least significant bit is set
            res += n % 2;
            // Right shift n to process the next bit
            n = n >> 1;
        }
        // Return the total count of set bits
        return res;
    }
}

class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        // Check all 32 bits of the integer
        for (int i = 31; i >= 0; i--) {
            // Right shift i positions and check the last bit
            if (((n >> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}

class Solution {
    public int hammingWeight(int n) {
        // Java's built-in method counts the number of set bits (1s)
        return Integer.bitCount(n);
    }
}

// Time Complexity :- O(1).
//Space Complexity :- O(1).

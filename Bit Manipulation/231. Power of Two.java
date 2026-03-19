/*********************************************** JAVA **************************************************/

// Optimal Solution - Check if a number is a power of two using the bit trick (n & (n - 1)) == 0.
/* "A power of two has only one set bit. Using n & (n - 1) removes the lowest set bit, so if the result is zero, it means there was only one set bit." */

class Solution {
    public boolean isPowerOfTwo(int n) {
        // n must be positive
        // (n & (n - 1)) removes the lowest set bit
        // If result is 0 → only one bit was set → power of 2
        return (n > 0 && (n & (n - 1)) == 0);
    }
}

// Time Complexity :- O(1).
// Space Complexity :- O(1).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Check power of four using bit manipulation and the property that (n−1) is divisible by 3.
/* "First I check if the number is a power of 2 using bit manipulation. Then I use the mathematical property that powers of 4 satisfy (n−1) % 3 == 0." */

class Solution {
    public boolean isPowerOfFour(int n) {
        // Power of 4 must be positive
        if (n <= 0) return false;
        // Condition 1: n is a power of 2 (only one set bit)
        // Condition 2: (n - 1) is divisible by 3 → ensures it's power of 4, not just 2
        if ((n & (n - 1)) == 0 && (n - 1) % 3 == 0)
            return true;
        return false;
    }
}

// Time Complexity :- O(1).
// Space Complexity :- O(1).

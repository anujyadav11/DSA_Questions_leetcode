/*********************************************** JAVA **************************************************/

// Optimal Solution - Construct the answer by inserting bits of (n−1) into unset bit positions of x.
/* “All set bits of x must remain fixed, so I use the zero-bit positions to encode n−1 directly.” */

class Solution {
    public long minEnd(int n, int x) {
        long num = x; // Start from x
        // Generate next valid numbers
        for (int i = 1; i < n; i++) {
            // Move to next number and force x's bits to remain set
            num = (num + 1) | x;
        }
        return num;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

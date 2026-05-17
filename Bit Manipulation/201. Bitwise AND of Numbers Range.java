/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds bitwise AND of range [left, right] by repeatedly clearing rightmost set bit of right until it converges to the common bit prefix with left.
/* "right & (right - 1) is the standard rightmost-bit-clear trick — -1 flips the trailing bits and AND clears the lowest set bit. This works because any differing bit between left and right will be 0 
    in the AND of the entire range — the common prefix is all that survives. Always add parentheses around right - 1 — operator precedence is a common interview gotcha." */

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // keep clearing rightmost set bit of right until right <= left
        while (left < right)
            right = right & (right - 1);
        // common prefix bits of left and right
        return left & right;
    }
}

// Time Complexity :- O(log n).
// Space Complexity :- O(1).

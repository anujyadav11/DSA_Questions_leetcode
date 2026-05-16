/*********************************************** JAVA **************************************************/

// Optimal Solution - Validates existence of original array by checking if XOR of all derived values equals zero, leveraging the self-cancellation property of circular XOR differences.
/* "XOR all derived values — each original[i] appears exactly twice in the expansion (once as left operand, once as right). Since a ^ a = 0, all originals cancel leaving 0 if valid. 
    Any non-zero result means the circular constraint is broken and no valid original exists. Elegant O(n) O(1) solution from a pure math observation." */

class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int res = 0;
        // XOR all derived values — valid original exists only if XOR equals 0
        for (int val : derived)
            res ^= val;
        return res == 0;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

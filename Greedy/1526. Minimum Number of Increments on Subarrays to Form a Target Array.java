/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds minimum increment operations to build target array by summing initial value and all positive consecutive differences.
/* "Think of this as painting bars — you can extend a horizontal stroke for free when the next bar is lower, but need extra strokes for each unit the next bar rises above the current. 
    This is equivalent to: start at 0, pay for every upward step. The total is target[0] plus all positive differences — same pattern as the 'minimum number of moves' problems involving monotonic stacks." */

class Solution {
    public int minNumberOperations(int[] target) {
        // start with cost to build first element from 0
        int res = target[0];
        for (int i = 1; i < target.length; i++) {
            // only add extra operations when current element exceeds previous
            if (target[i] > target[i - 1])
                res += target[i] - target[i - 1];
        }
        return res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

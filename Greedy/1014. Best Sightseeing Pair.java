/*********************************************** JAVA **************************************************/

// Optimal Solution - Maximizes sightseeing pair score by splitting the formula into left (values[i]+i) and right (values[j]-j) components, tracking running maximum of the left term.
/* "The algebraic split is the key insight — values[i] + values[j] + i - j becomes (values[i]+i) + (values[j]-j). This converts an O(n²) pair search into O(n) by maintaining a running max of the left term. 
    Always update leftMax after computing the score — updating before would allow i == j which violates the pair constraint." */

class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int res = 0;
        int n = values.length;
        // leftMax tracks best values[i] + i seen so far
        int leftMax = values[0] + 0;
        for (int j = 1; j < n; j++) {
            // right contribution: values[j] - j
            int rightVal = values[j] - j;
            // score = (values[i] + i) + (values[j] - j)
            res = Math.max(res, leftMax + rightVal);
            // update best left candidate for future j
            leftMax = Math.max(leftMax, values[j] + j);
        }
        return res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

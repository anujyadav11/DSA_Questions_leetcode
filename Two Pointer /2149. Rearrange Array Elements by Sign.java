/*********************************************** JAVA **************************************************/

// Optimal Solution - Rearranges an equal-positive-negative array in alternating order by placing positives at even indices and negatives at odd indices using two step-2 pointers.

/* "The equal count guarantee is what makes this O(n) — no sorting or swapping needed. Two independent index pointers jumping by 2 naturally enforce alternation. 
    If counts were unequal the problem would require a different approach like a queue-based two-pointer with overflow handling." */

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        // pi starts at 0 — positives placed at even indices
        int pi = 0;
        // ni starts at 1 — negatives placed at odd indices
        int ni = 1;
        int[] res = new int[n];
        for (int num : nums) {
            if (num > 0) {
                // place positive at next even index
                res[pi] = num;
                pi += 2;
            } else {
                // place negative at next odd index
                res[ni] = num;
                ni += 2;
            }
        }
        // return alternating positive-negative array
        return res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds maximum absolute subarray sum using dual Kadane's — simultaneously tracking maximum positive and minimum negative subarray sums.
/* "Maximum absolute sum is either the largest positive subarray or the largest magnitude negative subarray. Running Kadane's twice — once for max, once for min — captures both in one pass. 
    Initialize accumulators to 0 not MIN/MAX_VALUE since empty subarrays are valid and Kadane's reset handles the rest correctly." */

class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0;
        int minSum = 0;
        int curPSum = 0;
        int curNSum = 0;
        for (int num : nums) {
            curPSum += num;
            // reset first then track max — Kadane's correct order
            if (curPSum < 0) curPSum = 0;
            maxSum = Math.max(maxSum, curPSum);
            curNSum += num;
            // reset first then track min
            if (curNSum > 0) curNSum = 0;
            minSum = Math.min(minSum, curNSum);
        }
        // max absolute sum is either largest positive or largest negative subarray
        return Math.max(maxSum, Math.abs(minSum));
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

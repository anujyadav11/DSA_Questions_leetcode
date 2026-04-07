/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts subarrays with exact binary sum using inclusion-exclusion of two sliding window atMost(goal) computations.
/*  "Sliding window naturally counts ≤ not ==. The inclusion-exclusion trick atMost(k) - atMost(k-1) converts it to exact equality — a reusable pattern for binary array sum problems. 
    The goal < 0 guard handles the atMost(-1) call cleanly without special casing in the main function." */

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // exact count = subarrays with sum <= goal MINUS subarrays with sum <= goal-1
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    private int atMost(int[] nums, int goal) {
        // negative goal impossible for binary array
        if (goal < 0) return 0;
        int l = 0, sum = 0, cnt = 0;
        for (int r = 0; r < nums.length; r++) {
            // expand window by including nums[r]
            sum += nums[r];
            // shrink from left until sum is within goal
            while (sum > goal) {
                sum -= nums[l];
                l++;
            }
            // all subarrays ending at r with left boundary in [l, r] are valid
            cnt += (r - l + 1);
        }
        return cnt;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

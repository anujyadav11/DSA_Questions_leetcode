/*********************************************** JAVA **************************************************/

// Optimal Solution - Kadane’s Algorithm to find the maximum sum subarray in linear time. At every index, I decide whether to start a new subarray or extend the previous one, while keeping track of the global maximum.
/* “I maintain two values: currMax, the maximum subarray sum ending at the current index, and maxSoFar, the maximum sum found overall. For every element, I decide whether to start a new subarray or extend the previous one. 
    Then I update the global maximum. This allows me to solve the problem in one pass without extra space.” */

class Solution {
    public int maxSubArray(int[] nums) {
        // Maximum subarray sum found so far
        int maxSoFar = nums[0];
        // Maximum subarray sum ending at current index
        int currMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // Either start a new subarray or extend the previous one
            currMax = Math.max(nums[i], nums[i] + currMax);
            // Update the overall maximum
            maxSoFar = Math.max(currMax, maxSoFar);
        }
        return maxSoFar;
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(1).

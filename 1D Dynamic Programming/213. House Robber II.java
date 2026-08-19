/*********************************************** JAVA **************************************************/

// Optimal Solution - Solve the circular House Robber problem by converting it into two linear robberies: skipping the first house or skipping the last house.
/* “Since the houses form a circle, the first and last houses are adjacent and cannot both be robbed. I split the problem into two independent linear House Robber problems: 
    one excluding the last house and one excluding the first house. I solve both using standard DP and return the larger result.” */

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        // Only one house
        if (n < 2)
            return nums[0];
        // Case 1: Skip the last house
        int[] skipLast = new int[n - 1];
        // Case 2: Skip the first house
        int[] skipFirst = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            skipLast[i] = nums[i];
            skipFirst[i] = nums[i + 1];
        }
        // Find maximum loot for both cases
        int lootSkipLast = helper(skipLast);
        int lootSkipFirst = helper(skipFirst);
        return Math.max(lootSkipLast, lootSkipFirst);
    }
    public int helper(int[] nums) {
        int n = nums.length;
        if(n < 2) return nums[0];
        // dp[i] = maximum loot from houses 0 to i
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            // Rob current or skip current
            dp[i] = Math.max(dp[i - 2] + nums[i],dp[i - 1]);
        }
        return dp[n - 1];
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(N).

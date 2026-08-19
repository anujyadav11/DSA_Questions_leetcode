/*********************************************** JAVA **************************************************/

//Optimal Solution - Dynamic programming solution where each house is either robbed or skipped to maximise total profit without triggering alarms.

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        // Edge case: if there is only one house
        if (n == 1)
            return nums[0];
        // dp[i] = maximum money that can be robbed from houses [0..i]
        int[] dp = new int[n];
        // Base cases
        dp[0] = nums[0];                         // Only one house
        dp[1] = Math.max(nums[0], nums[1]);     // Choose the better of first two houses
        // Fill DP array
        for (int i = 2; i < n; i++) {
            // Either rob current house + dp[i-2], or skip it and take dp[i-1]
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        // The last element contains the maximum money possible
        return dp[n - 1];
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).


//Space-efficient solution - Solve House Robber using DP by choosing between robbing the current house with i-2 or skipping it.
/* “For every house, I decide whether to rob it or skip it. If I rob it, I cannot rob the previous house, so the value is nums[i] + prev2. If I skip it, 
    I keep the best value from the previous house. Taking the maximum gives the optimal result. Since only the previous two states are required, I optimize the space to O(1).” */

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        // Edge case: if there is only one house
        if (n == 1)
            return nums[0];
        // dp[i] = maximum money that can be robbed from houses [0..i]
        int[] dp = new int[n];
        // Base cases
        dp[0] = nums[0];                         // Only one house
        dp[1] = Math.max(nums[0], nums[1]);     // Choose the better of first two houses
        // Fill DP array
        for (int i = 2; i < n; i++) {
            // Either rob current house + dp[i-2], or skip it and take dp[i-1]
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        // The last element contains the maximum money possible
        return dp[n - 1];
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).


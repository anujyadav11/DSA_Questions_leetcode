/*********************************************** JAVA **************************************************/

// Optimal Solution - Use 1D dynamic programming to check if a subset with sum equal to half of the total array sum exists. This is a 0/1 knapsack problem where we check if any subset sums to half of the total array sum.

class Solution {
    public boolean canPartition(int[] nums) {
        // An odd total cannot be divided into two equal subsets
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;
        // dp[i] = can we form sum i?
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            // Traverse backwards so each number is used only once
            for (int i = target; i >= num; i--) {
                // If i - num is possible, i is also possible
                if (dp[i - num]) {
                    dp[i] = true;
                }
            }
        }
        return dp[target];
    }
}

// Time Complexity :- O(n x s).
// Space Complexity :- O(s). s = total sum of elements

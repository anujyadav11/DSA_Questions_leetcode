/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts subsets achieving maximum OR using top-down DP with (index, currentOR) state, memoizing include/exclude choices across all elements.
/* "Maximum OR is always the OR of all elements — any subset can only achieve this by including at least one element contributing each set bit. 
    The DP state (index, curOr) is compact because OR is monotonically non-decreasing, bounding curOr to [0, targetOr]. 
    Bottom-up with a simple array would reduce overhead but top-down with memoization is more intuitive here." */

class Solution {
    public int countMaxOrSubsets(int[] nums) {
        // compute maximum possible OR across all elements
        int targetOr = 0;
        for (int num : nums)
            targetOr |= num;
        // dp[index][curOr] = number of subsets from index onwards achieving targetOr
        Integer[][] dp = new Integer[nums.length][targetOr + 1];
        return recur(0, nums, 0, targetOr, dp);
    }

    public int recur(int index, int[] nums, int curOr, int targetOr, Integer[][] dp) {
        // base case: all elements considered — check if max OR achieved
        if (index == nums.length)
            return curOr == targetOr ? 1 : 0;
        // return cached result if state already computed
        if (dp[index][curOr] != null)
            return dp[index][curOr];
        // include current element — OR it into running value
        int pickCount = recur(index + 1, nums, curOr | nums[index], targetOr, dp);
        // exclude current element — running OR unchanged
        int noPickCount = recur(index + 1, nums, curOr, targetOr, dp);
        // memoize and return total subsets achieving targetOr from this state
        return dp[index][curOr] = pickCount + noPickCount;
    }
}

// Time Complexity :- O(n × targetOr).
// Space Complexity :- O(n × targetOr). 

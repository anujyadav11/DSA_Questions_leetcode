/*********************************************** JAVA **************************************************/

// Optimal Solution - Implemented recursive backtracking with a visited array to construct K equal-sum subsets, using target-sum validation and pruning to explore valid partitions.
/* "I first check whether the total sum is divisible by k. Then I calculate the target sum for each subset. Using backtracking and a visited array, I select unused elements until the current subset reaches the target.
    Once a subset is complete, I recursively construct the remaining subsets. If a selection exceeds the target or cannot lead to a valid partition, I backtrack and try another combination." */

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // Calculate the sum of all array elements.
        int total = 0;
        for (int el : nums) {
            total += el;
        }
        // If the total sum is not divisible by k,
        // we cannot divide the array into k equal-sum subsets.
        if (total % k != 0) return false;
        // We need at least k elements to form k non-empty subsets.
        if (nums.length < k) return false;
        // Calculate the required sum of each subset.
        int subsetSum = total / k;
        // Tracks whether an element has already been included
        // in one of the subsets.
        boolean[] vis = new boolean[nums.length];
        // Start constructing k subsets.
        // start = 0: begin searching from the first element.
        // curSum = 0: current subset is initially empty.
        return canPart(nums, vis, 0, k, 0, subsetSum);
    }
    private boolean canPart(int[] nums,boolean[] vis,int start,int k,int curSum,int subsetSum) {
        // Base case: all k subsets have been successfully constructed.
        if (k == 0) return true;
        // If the current subset exceeds the required sum,
        // this selection cannot produce a valid subset.
        if (curSum > subsetSum) return false;
        // If the current subset reaches the target sum,
        // start constructing the next subset.
        if (curSum == subsetSum) {
            return canPart(nums, vis, 0, k - 1, 0, subsetSum);
        }
        // Try selecting unused elements to complete the current subset.
        for (int i = start; i < nums.length; i++) {
            // Skip elements that have already been used.
            if (vis[i]) continue;
            // Choose the current element.
            vis[i] = true;
            // Recursively try to complete the current subset.
            if (canPart(nums,vis,i + 1,k,curSum + nums[i],subsetSum)) {
                return true;
            }
            // Backtrack: undo the selection and try another element.
            vis[i] = false;
        }
        // No valid combination was found for the current subset.
        return false;
    }
}

// Time Complexity :- O(k * 2^m).
// Space Complexity :- O(n).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds largest divisible subset using DP with parent tracking on sorted array, checking backward divisibility and reconstructing via parent chain traversal.
/* "Sorting is essential — it ensures nums[j] < nums[i] for j < i, so divisibility only needs one direction check. The parent array enables O(n) reconstruction without storing full subsets at each index. 
    Always track maxIdx separately — the maximum dp value could be at any index, not necessarily the last." */

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        // sort so divisibility only needs to check backwards
        Arrays.sort(nums);
        // dp[i] = size of largest divisible subset ending at index i
        int[] dp = new int[n];
        // parent[i] = previous index in the subset chain for reconstruction
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        int maxLen = 1;
        int maxIdx = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // nums[i] divisible by nums[j] — valid extension since array is sorted
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            // track index of largest subset ending position
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }
        // reconstruct subset by following parent chain
        List<Integer> res = new ArrayList<>();
        int idx = maxIdx;
        while (idx != -1) {
            res.add(nums[idx]);
            idx = parent[idx];
        }
        return res;
    }
}

// Time Complexity :- O(n^2).
// Space Complexity :- O(n).

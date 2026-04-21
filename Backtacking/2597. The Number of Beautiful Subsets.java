/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts beautiful subsets using backtracking with a frequency map to enforce the k-difference constraint, subtracting 1 to exclude the empty subset.
/* "Checking both nums[idx] - k and nums[idx] + k in the map covers all conflict directions. Using a frequency map instead of a set handles duplicate values correctly — 
    same value can appear multiple times without falsely blocking itself. The res - 1 is a clean trick to count all subsets including empty, then subtract it at the end." */

class Solution {
    int res;
    int K;
    public int beautifulSubsets(int[] nums, int k) {
        res = 0;
        K = k;
        Map<Integer, Integer> map = new HashMap<>();
        solve(0, nums, map);
        // subtract 1 to exclude the empty subset
        return res - 1;
    }
    public void solve(int idx, int[] nums, Map<Integer, Integer> map) {
        // base case: all elements considered — count this subset
        if (idx >= nums.length) {
            res++;
            return;
        }
        // option 1: skip current element
        solve(idx + 1, nums, map);
        // option 2: include current element only if no conflict with k-difference rule
        if (!map.containsKey(nums[idx] - K) && !map.containsKey(nums[idx] + K)) {
            // add current element to frequency map
            map.put(nums[idx], map.getOrDefault(nums[idx], 0) + 1);
            solve(idx + 1, nums, map);
            // backtrack — remove current element
            map.put(nums[idx], map.get(nums[idx]) - 1);
            if (map.get(nums[idx]) == 0)
                map.remove(nums[idx]);
        }
    }
}

// Time Complexity :- O(2^n).
// Space Complexity :- O(n).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Minimizes array difference after 3 changes by sorting and checking all four strategies of removing combinations of smallest and largest elements.
/*  "After sorting, the minimum difference is always max - min of the remaining elements. With 3 changes we can eliminate up to 3 extreme values — the 4 strategies cover all ways to split those 3 removals between left and right ends. 
    This exhaustive-but-constant approach is O(1) after sorting — no need for more complex optimization." */

class Solution {
    public int minDifference(int[] nums) {
        // with 4 or fewer elements we can change all — difference becomes 0
        if (nums.length <= 4)
            return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        // try all 4 strategies: change i smallest and (3-i) largest
        res = Math.min(res, nums[n - 4] - nums[0]); // change 3 largest
        res = Math.min(res, nums[n - 3] - nums[1]); // change 2 largest 1 smallest
        res = Math.min(res, nums[n - 2] - nums[2]); // change 1 largest 2 smallest
        res = Math.min(res, nums[n - 1] - nums[3]); // change 3 smallest
        return res;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(1).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts fair pairs with sum in [lower, upper] using inclusion-exclusion on two sorted two-pointer scans counting pairs with sum ≤ threshold.
/* "The inclusion-exclusion trick converts a range query into two simpler ≤ queries — a common pattern for range counting problems. The two-pointer works because sorting guarantees that when nums[i] + nums[j] > sum, 
    decreasing j is the only way to reduce the sum. j - i counts all valid right partners for the current i in one step." */

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        // sort to enable two-pointer counting
        Arrays.sort(nums);
        // pairs with sum <= upper MINUS pairs with sum <= lower-1 = pairs in [lower, upper]
        return countLess(nums, upper) - countLess(nums, lower - 1);
    }
    private long countLess(int[] nums, int sum) {
        long res = 0;
        // two pointers — count pairs with sum <= target
        for (int i = 0, j = nums.length - 1; i < j; i++) {
            // shrink j until nums[i] + nums[j] <= sum
            while (i < j && nums[i] + nums[j] > sum)
                j--;
            // all indices between i+1 and j form valid pairs with i
            res += j - i;
        }
        return res;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(1).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds minimum removals for mountain array by computing LIS and LDS at each index and maximizing valid mountain length where both sides are strictly monotonic.
/* "lds[j] = 1 vs lds[j] + 1 is a classic assignment-in-expression bug — compiles silently but corrupts state. Always read compound expressions carefully. 
    The +1 in n - lis[i] - lds[i] + 1 accounts for the peak being counted in both lis and lds. The validity check lis[i] > 1 && lds[i] > 1 ensures the peak has at least one element on each side." */

class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        // lis[i] = length of longest increasing subsequence ending at i
        int[] lis = new int[n];
        // lds[i] = length of longest decreasing subsequence starting at i
        int[] lds = new int[n];
        // compute LIS for each index
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j])
                    lis[i] = Math.max(lis[i], lis[j] + 1);
            }
        }
        // compute LDS for each index (longest decreasing from right)
        for (int i = n - 1; i >= 0; i--) {
            lds[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j])
                    lds[i] = Math.max(lds[i], lds[j] + 1);
            }
        }
        int minRemove = n;
        for (int i = 0; i < n; i++) {
            // valid mountain peak — must have strictly increasing left and decreasing right
            if (lis[i] > 1 && lds[i] > 1)
                // removals = total - elements kept in mountain
                minRemove = Math.min(minRemove, n - lis[i] - lds[i] + 1);
        }
        return minRemove;
    }
}

// Time Complexity :- O(n²) — two nested loops for LIS and LDS computation.
// Space Complexity :- O(n). size of lis and lds array.

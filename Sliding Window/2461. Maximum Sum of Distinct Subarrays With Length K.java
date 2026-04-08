/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds maximum sum k-length subarray with all distinct elements using a sliding window backed by a HashSet for O(1) duplicate detection.
/* "Window invariant: all elements distinct AND size ≤ k. When size hits exactly k, record sum then slide — don't wait for a duplicate to trigger shrink. 
    Inner while removes duplicates greedily from left ensuring the new right element always enters cleanly. Use long for sum to prevent overflow." */

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long res = 0;
        long currWindowSum = 0;
        // tracks distinct elements in current window
        Set<Integer> set = new HashSet<>();
        int i = 0, j = 0;
        while (j < n) {
            // shrink window from left until nums[j] has no duplicate in window
            while (set.contains(nums[j])) {
                currWindowSum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
            // expand window — add nums[j] to window
            currWindowSum += nums[j];
            set.add(nums[j]);
            // window reached exactly size k — valid subarray
            if (j - i + 1 == k) {
                res = Math.max(res, currWindowSum);
                // slide window forward by removing leftmost element
                currWindowSum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
            j++;
        }
        // return maximum sum found across all valid windows
        return res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(k).

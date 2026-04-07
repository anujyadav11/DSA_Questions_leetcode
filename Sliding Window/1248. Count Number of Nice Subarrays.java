/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts subarrays with exactly k odd numbers using inclusion-exclusion of two sliding window atMost(k) passes tracking parity via modulo.
/* "This is the same pattern as binary subarray sum — sliding window counts ≤ naturally, so subtract atMost(k-1) from atMost(k) to isolate exactly k. 
    The nums[r] % 2 trick maps odd detection to a simple integer addition, making the odd-count window identical in structure to a sum window." */

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // exact k odd numbers = atMost(k) - atMost(k-1)
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    public int atMost(int[] nums, int goal) {
        // negative goal impossible — no subarrays qualify
        if (goal < 0) return 0;
        int l = 0, sum = 0, cnt = 0;
        for (int r = 0; r < nums.length; r++) {
            // add 1 if nums[r] is odd, 0 if even
            sum += nums[r] % 2;
            // shrink window from left until odd count <= goal
            while (sum > goal) {
                sum -= nums[l] % 2;
                l++;
            }
            // all subarrays ending at r with start in [l, r] are valid
            cnt += (r - l + 1);
        }
        return cnt;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

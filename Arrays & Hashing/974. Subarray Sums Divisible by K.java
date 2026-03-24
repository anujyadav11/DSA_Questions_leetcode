/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts subarrays with sum divisible by k using prefix sum remainders and a frequency map, with correct negative modulo normalization.
/* The key insight is that (prefixSum[j] - prefixSum[i]) % k == 0 means both indices share the same remainder. Java's % can return negative values for negative numbers — 
    always normalize with mod + k when mod < 0, never re-apply % k." */

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // frequency map of prefix sum remainders, size k covers all mod values
        int[] map = new int[k];
        // empty subarray has remainder 0
        map[0] = 1;
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            // accumulate prefix sum
            sum += nums[i];
            // compute remainder of current prefix sum
            int mod = sum % k;
            // FIXED: mod is already in [-(k-1), -1], just add k to normalize
            if (mod < 0)
                mod = mod + k;
            // count previous prefix sums with same remainder
            res += map[mod];
            // record this remainder for future subarrays
            map[mod]++;
        }
        // return total subarrays with sum divisible by k
        return res;
    }
}

// Time Complexity :- O(n). for loop.
// Space Complexity :- O(k). for size of map.

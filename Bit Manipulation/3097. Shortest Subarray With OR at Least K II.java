/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds shortest subarray with OR ≥ k using sliding window with per-bit frequency tracking to correctly maintain OR during window shrinking.
/* "The bit frequency array is essential — OR can't be decremented directly since removing one element doesn't necessarily clear a bit if other elements in the window share it. 
    Always use |= to set bits and ^= to clear them — never arithmetic += or -= on bit manipulation since they corrupt other bit positions." */

class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        // tracks count of each set bit position across current window
        int[] bits = new int[32];
        int start = 0;
        int res = Integer.MAX_VALUE;
        int OR = 0;
        for (int j = 0; j < nums.length; j++) {
            // expand window — add nums[j] to current OR
            for (int i = 0; i < 32; i++) {
                if ((nums[j] & (1 << i)) != 0 && ++bits[i] == 1)
                    // first time this bit set in window — add to OR
                    OR |= (1 << i);
            }
            // shrink window from left while OR >= k
            while (start <= j && OR >= k) {
                // update minimum length for valid window
                res = Math.min(res, j - start + 1);
                // remove nums[start] influence from window
                for (int i = 0; i < 32; i++) {
                    if ((nums[start] & (1 << i)) != 0 && --bits[i] == 0)
                        // last instance of this bit removed — clear from OR
                        OR ^= (1 << i);
                }
                start++;
            }
        }
        // return -1 if no valid subarray found
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

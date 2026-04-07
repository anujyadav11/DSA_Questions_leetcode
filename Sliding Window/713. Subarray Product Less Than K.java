/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts subarrays with product less than k using a sliding window that multiplies on expansion and divides on shrink, batch-counting valid subarrays as j−i+1.
/* "Product window works like sum window — multiply to expand, divide to shrink. The k <= 1 guard is critical since all array values are positive integers ≥ 1, 
    so no subarray product can ever be < 1. Counting j - i + 1 works because fixing the right boundary j, every left boundary from i to j gives a distinct valid subarray." */

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        // if k <= 1 no product of positive integers can be less than k
        if (k <= 1) return 0;
        int i = 0, j = 0;
        int count = 0;
        int prod = 1;
        while (j < n) {
            // expand window by multiplying in nums[j]
            prod *= nums[j];
            // shrink window from left until product < k
            while (prod >= k) {
                prod /= nums[i];
                i++;
            }
            // all subarrays ending at j with start in [i, j] have product < k
            count += j - i + 1;
            j++;
        }
        // return total count of valid subarrays
        return count;
    }
}


// Time Complexity :- O(n).
// Space Complexity :- O(1).

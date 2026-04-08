/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds the longest subarray where no element appears more than k times using a sliding window with a HashMap frequency tracker.
/* "Only the newly added element nums[end] can violate the frequency constraint — so the inner while only needs to check freq.get(nums[end]) > k, not all elements. 
    This keeps the shrink targeted and efficient. HashMap tracks frequencies in O(1) per operation, giving overall O(n) despite the nested loops." */

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int start = 0, end = 0;
        int maxLen = 0;
        int n = nums.length;
        // tracks frequency of each element in current window
        Map<Integer, Integer> freq = new HashMap<>();
        while (end < n) {
            // add nums[end] to window and update frequency
            freq.put(nums[end], freq.getOrDefault(nums[end], 0) + 1);
            // shrink window from left until nums[end] frequency <= k
            while (freq.get(nums[end]) > k) {
                freq.put(nums[start], freq.get(nums[start]) - 1);
                start++;
            }
            // window [start, end] satisfies constraint — update max length
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        // return longest valid subarray length
        return maxLen;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

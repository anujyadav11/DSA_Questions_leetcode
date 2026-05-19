/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds longest nice subarray using a sliding window with a bitmask tracking used bits, shrinking from left whenever a new element conflicts with existing bits.
/* "The bitmask acts as a compact set of all bits used in the current window. & detects conflicts, ^ removes a departing element's bits (safe since each bit appears at most once in a valid window), 
    and | adds an arriving element's bits. This bit-tracking pattern is reusable for any 'no overlapping bits' constraint problem." */

class Solution {
    public int longestNiceSubarray(int[] nums) {
        int start = 0;
        int maxLen = 0;
        // tracks OR of all bits used by elements in current window
        int bitMask = 0;
        for (int end = 0; end < nums.length; end++) {
            // shrink window from left while nums[end] shares a bit with window
            while ((bitMask & nums[end]) != 0) {
                // remove nums[start] bits from mask
                bitMask ^= nums[start];
                start++;
            }
            // add nums[end] bits to mask
            bitMask |= nums[end];
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

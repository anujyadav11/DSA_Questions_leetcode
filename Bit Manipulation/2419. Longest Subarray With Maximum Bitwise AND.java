/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds longest subarray of maximum value by tracking streaks of the current max and resetting fully when a new maximum is discovered.
/* "The reset on new maximum is the key — when we find a larger value, all previous streaks are irrelevant so both streak and res reset to 0. 
    This single-pass approach avoids a separate max-finding pass. For follow-up, mention this also works for 'longest streak of any specific value' by replacing maxVal tracking with a fixed target value." */

class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = 0;
        int res = 0;
        int streak = 0;
        for (int num : nums) {
            if (num > maxVal) {
                // found new maximum — reset everything
                maxVal = num;
                res = 0;
                streak = 0;
            }
            if (num == maxVal) {
                // extend current streak of max values
                streak++;
            } else {
                // streak broken — reset
                streak = 0;
            }
            res = Math.max(res, streak);
        }
        return res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

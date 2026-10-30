/*********************************************** JAVA **************************************************/

// Optimal Solution - Solved Minimum Size Subarray Sum using variable-size sliding window with O(n) time and O(1) auxiliary space.
/* “I use a variable-size sliding window. I expand the right pointer while maintaining the running sum. Whenever the sum reaches the target, 
    I update the minimum window length and shrink the window from the left until it becomes invalid. Since both pointers traverse the array at most once, 
    the solution runs in O(n) time and O(1) auxiliary space.” */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int curSum = 0;
        int minLenWindow = Integer.MAX_VALUE;
        int low = 0;
        int high = 0;
        while (high < n) {
            // Expand the window by including the current element.
            curSum += nums[high];
            high++;
            // Shrink the window while its sum satisfies the target.
            while (curSum >= target) {
                // Update the minimum valid window length.
                int curWin = high - low;
                minLenWindow = Math.min(minLenWindow, curWin);
                // Remove the leftmost element and shrink the window.
                curSum -= nums[low];
                low++;
            }
        }
        // Return 0 if no valid subarray was found.
        return minLenWindow == Integer.MAX_VALUE ? 0 : minLenWindow;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

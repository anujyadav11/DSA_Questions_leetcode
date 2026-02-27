/*********************************************** JAVA **************************************************/

// Optimal Solution - Track both non-decreasing and non-increasing conditions in one pass and return true if either holds.
                      // “Instead of counting, I track whether the array violates increasing or decreasing order. If at least one condition remains valid, the array is monotonic.”

class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        boolean increasing = true;   // Assume non-decreasing
        boolean decreasing = true;   // Assume non-increasing
        // Traverse array once
        for (int i = 1; i < n; i++) {
            // If current is smaller → not increasing
            if (nums[i] < nums[i - 1]) {
                increasing = false;
            }
            // If current is greater → not decreasing
            if (nums[i] > nums[i - 1]) {
                decreasing = false;
            }
        }
        // Array is monotonic if either condition holds
        return increasing || decreasing;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

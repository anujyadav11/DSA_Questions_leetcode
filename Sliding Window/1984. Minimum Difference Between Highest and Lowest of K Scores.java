/*********************************************** JAVA **************************************************/

// Optimal Solution - Sort the array and use a sliding window of size k to find the minimum difference between max and min elements.
/* "To minimize the difference between max and min of k elements, I first sort the array. Then I check every consecutive window of size k and track the smallest difference." */

class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;   // Total number of elements
        // Sort the array so that close values are next to each other
        Arrays.sort(nums);
        int left = 0;          // Left pointer of the window
        int right = k - 1;     // Right pointer (window size = k)
        int minDifference = Integer.MAX_VALUE; // Store minimum difference
        // Slide the window across the sorted array
        while (right < n) {
            // Difference between max and min in the current window
            minDifference = Math.min(minDifference, nums[right] - nums[left]);
            // Move window forward
            left++;
            right++;
        }
        return minDifference;  // Minimum possible difference
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(1).

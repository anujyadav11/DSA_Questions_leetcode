/*********************************************** JAVA **************************************************/

// Optimal Solution - Solved Search in Rotated Sorted Array II using modified binary search with duplicate handling in O(log n) average time and O(n) worst-case time.
/* “I use modified binary search. At each iteration, I check whether the target is at the midpoint. If duplicates make it impossible to identify the sorted half, I shrink both boundaries. Otherwise, 
    I identify the sorted half and determine whether the target lies within its range, allowing me to discard half the search space.” */

class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        // Binary search in the rotated sorted array.
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // Target found.
            if (nums[mid] == target) {
                return true;
            }
            // Duplicates make it impossible to identify the sorted half.
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            }
            // Left half is sorted.
            else if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    // Target lies in the sorted left half.
                    high = mid - 1;
                } else {
                    // Search the right half.
                    low = mid + 1;
                }
            }
            // Right half is sorted.
            else {
                if (nums[mid] < target && target <= nums[high]) {
                    // Target lies in the sorted right half.
                    low = mid + 1;
                } else {
                    // Search the left half.
                    high = mid - 1;
                }
            }
        }
        // Target does not exist in the array.
        return false;
    }
}

// Time Complexity :- O(log n).
// Space Complexity :- O(1).

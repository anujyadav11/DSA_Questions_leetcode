/*********************************************** JAVA **************************************************/

// Optimal Solution - Solved Search Insert Position using binary search in O(log n) time and O(1) auxiliary space.
/* “I use binary search on the sorted array. If the target exists, I return its index. Otherwise, I adjust the search boundaries until the search space becomes empty. 
    At that point, low represents the correct insertion position.” */

class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        // Binary search in the sorted array.
        while (low <= high) {
            // Calculate the middle index without risking integer overflow.
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                // Target already exists; return its index.
                return mid;
            } else if (nums[mid] > target) {
                // Target must be in the left half.
                high = mid - 1;
            } else {
                // Target must be in the right half.
                low = mid + 1;
            }
        }
        // When the search ends, low is the correct insertion position.
        return low;
    }
}

// Time Complexity :- O(log n).
// Space Complexity :- O(1).

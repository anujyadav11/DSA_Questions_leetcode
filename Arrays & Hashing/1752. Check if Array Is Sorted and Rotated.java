/*********************************************** JAVA **************************************************/

// Optimal Solution - Count circular order violations and ensure there is at most one to verify sorted-rotated array
                      // “A sorted rotated array can have only one decreasing adjacent pair. I count such violations using circular indexing.”

class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;   // Length of array
        int count = 0;         // Counts number of "drops" (rotation break points)
        // Traverse entire array
        for (int i = 0; i < n; i++) {
            // Compare current element with next element (circularly)
            if (nums[i] > nums[(i + 1) % n]) {
                count++;   // Found a break in sorted order
            }
        }
        // Array is sorted & rotated if at most one such break exists
        return count <= 1;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

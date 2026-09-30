/*********************************************** JAVA **************************************************/

// Optimal Solution - Remove elements equal to the target value in-place using a two-pointer approach with O(n) time and O(1) space.
/* “I use two pointers where i scans the array and j maintains the position for the next valid element. This lets me remove the target value in-place without using extra space.” */

class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if (n == 0)
            return 0;
        // j represents the position where the next valid element
        // (an element different from val) should be placed.
        int j = 0;
        // i scans through every element of the array.
        for (int i = 0; i < n; i++) {
            // If the current element should be kept,
            // move it to the next available position at index j.
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        // j is the number of elements that are not equal to val.
        return j;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

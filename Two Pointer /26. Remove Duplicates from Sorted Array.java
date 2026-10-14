/*********************************************** JAVA **************************************************/

// Optimal Solution - Remove duplicates from a sorted array in-place using two pointers in O(n) time and O(1) extra space.
/* “Since the array is sorted, duplicates are adjacent. I maintain a pointer to the last unique element and scan with a second pointer. 
    Whenever I find a different element, I write it to the next available position and advance the write pointer.” */

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int i = 0;
        int j = 1;
        while (j < n) {
            // Skip duplicates of the last unique element.
            if (nums[i] == nums[j]) {
                j++;
            } else {
                // Place the next unique element after the last one.
                nums[i + 1] = nums[j];
                i++;
                j++;
            }
        }
        // i is the index of the last unique element.
        return i + 1;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

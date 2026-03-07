/*********************************************** JAVA **************************************************/

// Optimal Solution - Use two pointers to compare squared values from both ends and fill the result array from largest to smallest.
                      // Use two pointers to compare squared values from both ends and fill the result array from largest to smallest.

class Solution {
    public int[] sortedSquares(int[] nums) {
        // Result array to store sorted squares
        int[] res = new int[nums.length];
        // Square every element in nums
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        // Two pointers at beginning and end
        int head = 0;
        int tail = nums.length - 1;
        // Fill result from the end (largest squares first)
        for (int i = nums.length - 1; i >= 0; i--) {
            // Compare squares at both ends
            if (nums[head] > nums[tail]) {
                res[i] = nums[head];
                head++; // Move left pointer forward
            } else {
                res[i] = nums[tail];
                tail--; // Move right pointer backward
            }
        }
        return res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

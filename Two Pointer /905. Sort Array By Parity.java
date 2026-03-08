/*********************************************** JAVA **************************************************/

// Optimal Solution - In-place partitioning using two pointers to move all even numbers to the front of the array in O(n) time and O(1) space.
                      // This problem can be solved using a two-pointer partition approach similar to QuickSort.

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int j = 0; // Pointer to place the next even number
        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            // Check if current element is even
            if (nums[i] % 2 == 0) {
                // Swap current element with element at index j
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                // Move j to the next position for the next even number
                j++;
            }
        }
        // Return the modified array with evens first and odds later
        return nums;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

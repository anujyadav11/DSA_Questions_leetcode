/*********************************************** JAVA **************************************************/

// Optimal Solution - Simulate adjacent doubling operations and then move all zeros to the end using a stable two-pointer partition.

class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        // Step 1: Apply the doubling operation
        for (int i = 0; i < n - 1; i++) {
            // If adjacent numbers are equal
            if (nums[i] == nums[i + 1]) {
                // Double the current element
                nums[i] = 2 * nums[i];
                // Set the next element to zero
                nums[i + 1] = 0;
            }
        }
        // Step 2: Move all zeros to the end (stable order)
        int j = 0; // position for next non-zero element
        for (int i = 0; i < n; i++) {
            // If current element is non-zero
            if (nums[i] != 0) {
                // Swap with position j
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        return nums;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

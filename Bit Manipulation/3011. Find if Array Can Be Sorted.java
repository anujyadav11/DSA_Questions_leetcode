/*********************************************** JAVA **************************************************/

// Optimal Solution - Determines if array can be sorted using bubble sort restricted to swapping adjacent elements with equal popcount, returning false on any impossible required swap.
/* "Bubble sort is justified here because the constraint is on adjacent swaps — exactly what bubble sort performs. Any sorting algorithm using non-adjacent swaps wouldn't respect the constraint. 
    Integer.bitCount() is the clean Java built-in for popcount — mention it explicitly. The early termination on !swapped reduces best case to O(n) for already-sorted input." */

class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        boolean swapped = true;
        for (int i = 0; i < n; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] <= nums[j + 1]) {
                    // already in order — no swap needed
                    continue;
                }
                if (Integer.bitCount(nums[j]) == Integer.bitCount(nums[j + 1])) {
                    // same bit count — swap allowed
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                } else {
                    // different bit count — swap not allowed, can't sort
                    return false;
                }
            }
            // no swaps in this pass — array already sorted
            if (!swapped) break;
        }
        return true;
    }
}

// Time Complexity :- O(n^2).
// Space Complexity :- O(1).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Rotate an array to the right in-place using the three-reversal technique in O(n) time and O(1) space.
/* “I rotate the array in-place using three reversals. First, I reverse the entire array, then reverse the first k elements, 
    and finally reverse the remaining elements. I normalize k using modulo n to handle rotations larger than the array length." */
  
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // Handle an empty array.
        if (n == 0) return;
        // Normalize k if it is greater than or equal to n.
        k %= n;
        // Reverse the entire array.
        reverse(nums, 0, n - 1);
        // Reverse the first k elements.
        reverse(nums, 0, k - 1);
        // Reverse the remaining n - k elements.
        reverse(nums, k, n - 1);
    }
    public void reverse(int[] nums, int i, int j) {
        // Swap elements until the pointers meet.
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

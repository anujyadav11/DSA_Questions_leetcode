/*********************************************** JAVA **************************************************/

// Optimal Solution - Generates next lexicographic permutation in-place by finding the rightmost ascending pair, swapping with next greater element, then reversing the suffix.
/* "Three steps: find rightmost nums[i] > nums[i-1], find rightmost nums[j] > nums[i-1] in suffix, swap them, reverse from i onward. If no ascending pair exists the array is fully descending — 
    just reverse all to get the smallest permutation. Java has no built-in swap or reverse for arrays so implement manually — Collections.swap only works on Lists." */

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        // find rightmost index where nums[i] > nums[i-1] — first non-descending break
        int i = n - 1;
        while (i > 0 && nums[i] <= nums[i - 1])
            i--;
        if (i != 0) {
            // find rightmost element greater than nums[i-1] to swap with
            int index = i;
            for (int j = n - 1; j >= i; j--) {
                if (nums[j] > nums[i - 1]) {
                    index = j;
                    break;
                }
            }
            // swap to place next greater element at position i-1
            int temp = nums[i - 1];
            nums[i - 1] = nums[index];
            nums[index] = temp;
        }
        // reverse suffix to get smallest possible arrangement after i
        int left = i, right = n - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

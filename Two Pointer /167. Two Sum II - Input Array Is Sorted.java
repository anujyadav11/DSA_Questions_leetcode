/**************************************** JAVA ******************************************/

// Optimal Solution - Use two pointers on the sorted array to find the target pair in linear time.
/* “Because the array is sorted, I use two pointers from both ends. If the current sum is too small, 
    I move the left pointer; if it’s too large, I move the right pointer, achieving O(n) time.” */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start pointers from both ends
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            // Pair found
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }
            // Need a larger sum
            else if (sum < target) {
                left++;
            }
            // Need a smaller sum
            else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(1).

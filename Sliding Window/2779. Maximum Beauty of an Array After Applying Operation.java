/*********************************************** JAVA **************************************************/

// Optimal Solution - Use a difference array to mark value ranges and compute maximum overlap via prefix sum.
/* “Each number creates a valid range after adjustment, so I convert the problem into finding maximum overlap using a difference array.” */

class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        // Find max value in nums
        int max = 0;
        for (int num : nums)
            max = Math.max(max, num);
        // We need space till max + k
        int[] count = new int[max + k + 2];
        // Mark ranges using difference array
        for (int num : nums) {
            int left = Math.max(0, num - k);
            int right = num + k;
            count[left]++; // Start of range
            count[right + 1]--; // End of range
        }
        int currSum = 0;
        int maxSum = 0;
        // Prefix sum to find maximum overlap
        for (int c : count) {
            currSum += c;
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}

// Time Complexity :- O(n + r). r = max range of an element in an array
// Space Complexity :- O(r).

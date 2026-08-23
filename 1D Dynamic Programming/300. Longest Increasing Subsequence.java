/*********************************************** JAVA **************************************************/

// Optimal Solution - Use dynamic programming to compute the longest increasing subsequence ending at each index. For each index, I compute the LIS ending there by extending all valid previous subsequences.
/* “I define dp[i] as the length of the longest increasing subsequence ending at index i. For every element, I check all previous elements. If the current element is greater, 
    I can extend the subsequence ending at that previous element, so I update dp[i] with dp[j] + 1. Finally, the answer is the maximum value in the DP array.” */

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // t[i] = length of LIS ending at index i (excluding nums[i] itself)
        int[] t = new int[n];
        // Build LIS lengths
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // If current number can extend the increasing subsequence
                if (nums[i] > nums[j]) {
                    // Update LIS ending at i
                    t[i] = Math.max(t[i], t[j] + 1);
                }
            }
        }
        // Find the maximum LIS value
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (t[i] > t[maxIndex]) {
                maxIndex = i;
            }
        }
        // +1 because t[] stores length excluding the element itself
        return t[maxIndex] + 1;
    }
}

// Time Complexity :- O(n^2).
// Space Complexity :- O(n).

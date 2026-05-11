 /*********************************************** JAVA **************************************************/

// Optimal Solution - Finds longest Fibonacci subsequence length using 2D DP with two-pointer pair search, extending chains where arr[start]+arr[end]==arr[cur].
/* "The dp[i][j] state represents extensions beyond the first two elements — so the final answer adds 2 to account for the initial pair. Two pointers work because the array is sorted, 
    allowing O(n) pair search per cur instead of O(n²). The DP correctly handles different subsequences sharing the same endpoint pair." */

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        // dp[i][j] = length of longest Fibonacci subsequence ending with arr[i], arr[j]
        int[][] dp = new int[n][n];
        int maxLen = 0;
        for (int cur = 2; cur < n; cur++) {
            int start = 0;
            int end = cur - 1;
            // two pointer — find pairs that sum to arr[cur]
            while (start < end) {
                int sum = arr[start] + arr[end];
                if (sum < arr[cur]) {
                    start++;
                } else if (sum > arr[cur]) {
                    end--;
                } else {
                    // arr[start] + arr[end] == arr[cur] — valid Fibonacci triple
                    dp[end][cur] = dp[start][end] + 1;
                    maxLen = Math.max(maxLen, dp[end][cur]);
                    start++;
                    end--;
                }
            }
        }
        // add 2 for the first two elements of the sequence
        return maxLen == 0 ? 0 : maxLen + 2;
    }
}

// Time Complexity :- O(n^2).
// Space Complexity :- O(n^2).

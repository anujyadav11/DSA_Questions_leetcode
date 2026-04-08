/*********************************************** JAVA **************************************************/

// Optimal Solution - Track consecutive increasing sequence length and use it to validate sliding windows in O(n) time.
/* “Instead of checking each window separately, I track the length of consecutive increasing sequence and validate windows in O(n).” */

class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        // Result array of size n-k+1
        int[] res = new int[n - k + 1];
        // Initialize all values with -1
        java.util.Arrays.fill(res, -1);
        int count = 1;  // Tracks length of current consecutive sequence
        // Process first window [0...k-1]
        for (int i = 1; i < k; i++) {
            // Check if consecutive increasing
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                count = 1;
            }
        }
        // If first window is valid
        if (count == k)
            res[0] = nums[k - 1];
        int i = 1;   // Result index
        int j = k;   // Sliding window end
        // Slide window
        while (j < n) {
            // Update consecutive count
            if (nums[j] == nums[j - 1] + 1) {
                count++;
            } else {
                count = 1;
            }
            // If current sequence length ≥ k
            if (count >= k)
                res[i] = nums[j];
            i++;
            j++;
        }
        return res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

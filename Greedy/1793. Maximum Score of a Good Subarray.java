/*********************************************** JAVA **************************************************/

// Optimal Solution - Maximizes subarray score containing index k by greedily expanding the window towards the larger neighbor, tracking minimum times width.
/* "Greedy expansion towards the larger neighbor is optimal — adding a smaller element reduces currMin faster, so delay it as long as possible. 
    Using 0 as sentinel for out-of-bounds ensures the in-bounds side is always chosen when one pointer hits the boundary. 
    Score formula min × width requires updating after every expansion since both factors change." */

class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        // start with window containing only index k
        int i = k, j = k;
        int currMin = nums[k];
        // initial score = nums[k] * 1
        int res = nums[k];
        while (i > 0 || j < n - 1) {
            // expand towards the larger neighbor to maximize minimum
            int leftVal = (i > 0) ? nums[i - 1] : 0;
            int rightVal = (j < n - 1) ? nums[j + 1] : 0;
            if (leftVal < rightVal) {
                // right neighbor is larger — expand right
                j++;
                currMin = Math.min(currMin, nums[j]);
            } else {
                // left neighbor is larger or equal — expand left
                i--;
                currMin = Math.min(currMin, nums[i]);
            }
            // update max score with current window
            res = Math.max(res, currMin * (j - i + 1));
        }
        return res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

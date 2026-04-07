/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds longest subarray of ones after flipping at most k zeros using a sliding window that tracks zero count and shrinks when the flip budget is exceeded.
/* "This is a classic sliding window on a budget — the budget is k zero flips. Expand freely, shrink only when the budget is exceeded. The window always represents the best valid configuration seen so far. 
    For follow-up, if you need the actual indices, just return start and end at max — the window boundaries tell you exactly where the optimal subarray is." */

class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeroCnt = 0;
        int start = 0;
        int maxOnes = 0;
        for (int end = 0; end < nums.length; end++) {
            // expand window — count zeros entering from right
            if (nums[end] == 0)
                zeroCnt++;
            // shrink window from left until zero count <= k
            while (zeroCnt > k) {
                if (nums[start] == 0)
                    zeroCnt--;
                start++;
            }
            // window [start, end] has at most k zeros — update max length
            maxOnes = Math.max(maxOnes, end - start + 1);
        }
        // return longest subarray with at most k zeros flipped
        return maxOnes;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

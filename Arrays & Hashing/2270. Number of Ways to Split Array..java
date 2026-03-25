/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts valid array splits where left sum ≥ right sum using O(n) running prefix and suffix sum variables to avoid recomputation.
/*  "Instead of maintaining a prefix sum array, I use two variables — shifting each element from right to left as I move the split point. This avoids O(n) extra space and keeps it O(1). 
      Key detail: loop only to n-2 since both halves must be non-empty." */

class Solution {
    public int waysToSplitArray(int[] nums) {
        // initialize right as total sum, left starts at 0
        long right = 0;
        long left = 0;
        // compute total sum into right
        for (int num : nums)
            right += num;
        int count = 0;
        int n = nums.length;
        // iterate all valid split points (exclude last index — right part must be non-empty)
        for (int i = 0; i < n - 1; i++) {
            // expand left part to include nums[i]
            left += nums[i];
            // shrink right part by removing nums[i]
            right -= nums[i];
            // valid split if left sum >= right sum
            if (left >= right)
                count++;
        }
        // return total valid splits
        return count;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

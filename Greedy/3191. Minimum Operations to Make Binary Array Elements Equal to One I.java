/*********************************************** JAVA **************************************************/

// Optimal Solution - Converts binary array to all-ones greedily by flipping triple windows starting at each zero, returning -1 if the last two positions can't be fixed.
/*  "Greedy works here because a 0 at position i can only be fixed by a flip anchored at i or earlier — once we pass it without flipping, it becomes permanently unfixable. 
     So the decision at each position is forced: flip if 0, skip if 1. The last two positions are the classic edge case since they can't anchor any flip." */

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) {
                // flip current and next two elements
                nums[i] = 1 - nums[i];
                nums[i + 1] = 1 - nums[i + 1];
                nums[i + 2] = 1 - nums[i + 2];
                count++;
            }
        }
        // last two elements can't anchor a flip — if either is 0 it's impossible
        if (nums[n - 1] == 0 || nums[n - 2] == 0)
            return -1;
        return count;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

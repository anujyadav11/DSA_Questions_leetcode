/*********************************************** JAVA **************************************************/

// Optimal Solution - Minimizes increments for array uniqueness by sorting and greedily bumping each duplicate to one above its predecessor, counting total steps moved.
/* "Sorting is the key — it groups duplicates together so each fix is a simple prev + 1 bump. The moves formula nums[i-1] + 1 - nums[i] 
    correctly handles both exact duplicates and elements less than previous. An alternative O(n) approach uses path compression similar to Union-Find for very large inputs." */

class Solution {
    public int minIncrementForUnique(int[] nums) {
        // sort to process duplicates in order
        Arrays.sort(nums);
        int moves = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                // must increment nums[i] to nums[i-1] + 1
                moves += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return moves;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(1).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Greedy approach that tracks the leftmost index capable of reaching the end by scanning from right to left. Instead of simulating jumps forward, I work backward and keep shrinking the goal position whenever an index can reach it
/* “I start with the last index as the goal. Traversing backwards, whenever an index can reach the current goal, I move the goal to that index. 
    If the goal eventually reaches index zero, there exists a valid sequence of jumps from the start to the end.” */

class Solution {
    public boolean canJump(int[] nums) {
        // Initially, the last index is our goal
        int finalPos = nums.length - 1;
        // Work backwards to find an index that can reach the goal
        for (int idx = nums.length - 2; idx >= 0; idx--) {
            // Current index can reach the goal
            if (idx + nums[idx] >= finalPos) {
                finalPos = idx;
            }
        }
        // If goal moves back to index 0, we can reach the end
        return finalPos == 0;
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(1).

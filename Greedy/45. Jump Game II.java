/*********************************************** JAVA **************************************************/

//Optimal Solution - Greedy approach that minimizes jumps by expanding the farthest reachable range and jumping only when necessary.I treat each jump as a range and greedily expand the farthest reachable index before committing to the next jump.
/*  */

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int totalJumps = 0;
        int dest = n - 1;
        // Farthest index reachable in the current jump range
        int coverage = 0;
        // End of the current jump range
        int lastJumpIdx = 0;
        if (n == 1)
            return 0;
        for (int i = 0; i < n; i++) {
            // Track the farthest position reachable
            coverage = Math.max(coverage, i + nums[i]);
            // Current jump range is exhausted
            if (i == lastJumpIdx) {
                // Start the next jump from the farthest reachable position
                lastJumpIdx = coverage;
                totalJumps++;
                // Destination is reachable
                if (coverage >= dest) {
                    return totalJumps;
                }
            }
        }
        return totalJumps;
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(1).

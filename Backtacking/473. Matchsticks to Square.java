/*********************************************** JAVA **************************************************/

// Optimal Solution - Used backtracking to distribute matchsticks across four equal-sum buckets, with descending sorting and symmetry pruning to reduce redundant search.
/* "I use backtracking to distribute matchsticks among four equal-length sides. First, I verify that the total length is divisible by four. Then I sort the matchsticks and process the largest ones first. 
    For each stick, I try placing it on each side without exceeding the target length. I skip sides with identical current sums to avoid equivalent states and stop exploring equivalent empty sides when a placement fails." */

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        // Calculate the total length.
        long total = 0;
        for (int stick : matchsticks) {
            total += stick;
        }
        // Four equal sides must be possible.
        if (total % 4 != 0) {
            return false;
        }
        long target = total / 4;
        // Sort in ascending order.
        Arrays.sort(matchsticks);
        // The largest stick must fit on one side.
        if (matchsticks[n - 1] > target) {
            return false;
        }
        // Store the current length of each of the four sides.
        long[] sides = new long[4];
        // Start assigning sticks from largest to smallest.
        return backtrack(matchsticks, n - 1, sides, target);
    }
    private boolean backtrack(int[] matchsticks,int index,long[] sides,long target) {
        // All matchsticks have been successfully assigned.
        if (index < 0) {
            return true;
        }
        // Current matchstick being assigned.
        int stick = matchsticks[index];
        // Try placing the stick on each of the four sides.
        for (int i = 0; i < 4; i++) {
            // Skip sides that cannot accommodate this stick.
            if (sides[i] + stick > target) {
                continue;
            }
            // Avoid trying sides with identical current lengths.
            boolean duplicateSide = false;
            for (int j = 0; j < i; j++) {
                if (sides[i] == sides[j]) {
                    duplicateSide = true;
                    break;
                }
            }
            if (duplicateSide) {
                continue;
            }
            // Place the current stick on this side.
            sides[i] += stick;
            // Assign the next matchstick.
            if (backtrack(matchsticks, index - 1, sides, target)) {
                return true;
            }
            // Backtrack: remove the current stick.
            sides[i] -= stick;
            // If placing the stick on an empty side fails,
            // trying another empty side is equivalent.
            if (sides[i] == 0) {
                break;
            }
        }
        return false;
    }
}

// Time Complexity :- O(4^n).
// Space Complexity :- O(n).

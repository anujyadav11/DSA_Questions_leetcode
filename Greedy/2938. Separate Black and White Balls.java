/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts minimum swaps to move all zeros left using a greedy pointer tracking each zero's target position and accumulating displacement steps.
/*  "This is the classic bubble sort swap count pattern — count how many 1s each 0 must pass. The last pointer elegantly tracks where the next 0 belongs without simulating actual swaps. 
      cur - last gives exactly the number of 1s between the current 0 and its target position." */

class Solution {
    public long minimumSteps(String s) {
        int n = s.length();
        // tracks the position where next '0' should be placed
        int last = 0;
        long count = 0;
        for (int cur = 0; cur < n; cur++) {
            if (s.charAt(cur) == '0') {
                // steps needed to move this '0' left past all '1's before it
                count += (cur - last);
                last++;
            }
        }
        return count;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

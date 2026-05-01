/*********************************************** JAVA **************************************************/

// Optimal Solution - Validates if locked parentheses string can be made valid by treating unlocked positions as wildcards in two greedy directional passes.
/*  "Two passes cover both failure modes — left-to-right catches unmatched closes, right-to-left catches unmatched opens. Unlocked positions act as wildcards — in left pass they're potential opens, in right pass potential closes. 
      This greedy works because we're checking feasibility of any valid assignment, not finding the specific assignment." */

class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        // odd length string can never be valid parentheses
        if (n % 2 != 0)
            return false;
        int open = 0;
        // left to right pass — treat '(' and unlocked as potential opens
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || locked.charAt(i) == '0')
                open++;
            else
                open--;
            // more closes than available opens — invalid
            if (open < 0)
                return false;
        }
        int close = 0;
        // right to left pass — treat ')' and unlocked as potential closes
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')' || locked.charAt(i) == '0')
                close++;
            else
                close--;
            // more opens than available closes — invalid
            if (close < 0)
                return false;
        }
        return true;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

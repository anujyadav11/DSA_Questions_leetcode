/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds the lexicographically smallest number matching a DI pattern using backtracking with digit reuse tracking and greedy smallest-first digit selection.
/* "Trying digits 1-9 in ascending order guarantees the first valid complete arrangement found is lexicographically smallest — no sorting needed. 
    The used array prevents digit repetition across the entire number. isValid only checks adjacent pairs since the pattern constraint is purely local between consecutive positions." */

class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        // used[1..9] tracks which digits are placed
        boolean[] used = new boolean[10];
        StringBuilder res = new StringBuilder();
        backtrack(pattern, 0, new int[n + 1], used, res);
        return res.toString();
    }
    private boolean backtrack(String pattern, int idx, int[] num, boolean[] used, StringBuilder res) {
        // base case: all n+1 positions filled — build result string
        if (idx == pattern.length() + 1) {
            for (int digit : num)
                res.append(digit);
            return true;
        }
        for (int dig = 1; dig <= 9; dig++) {
            // skip used digits or digits violating pattern constraint
            if (!used[dig] && (idx == 0 || isValid(num[idx - 1], dig, pattern.charAt(idx - 1)))) {
                used[dig] = true;
                num[idx] = dig;
                // early exit if valid arrangement found
                if (backtrack(pattern, idx + 1, num, used, res))
                    return true;
                // backtrack
                num[idx] = 0;
                used[dig] = false;
            }
        }
        return false;
    }
    public boolean isValid(int lastDig, int currDig, char condition) {
        // I requires strictly increasing, D requires strictly decreasing
        return (condition == 'I' && lastDig < currDig) ||
                (condition == 'D' && lastDig > currDig);
    }
}

// Time Complexity :- O(9!). worst case — but early exit via return true makes it effectively O(n) for finding the smallest valid arrangement.
// Space Complexity :- O(n) — num array of size n+1 and call stack of depth n+1

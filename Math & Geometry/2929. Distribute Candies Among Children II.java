/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts 3-child candy distributions within limit by fixing child 1's amount and computing valid range sizes for children 2 and 3 in O(limit).
/* "Fixing one variable converts a 3-variable constraint problem into counting a 1D range — the third child's value is fully determined once the first two are fixed. 
    The bounds for each child come from two constraints: non-negative (≥ 0) and within limit (≤ limit). An O(1) inclusion-exclusion formula using combinations exists for the exact count if needed." */

class Solution {
    public long distributeCandies(int n, int limit) {
        long ways = 0;
        // child 1 can receive between max(0, n-2*limit) and min(n, limit) candies
        int minCh1 = Math.max(0, n - 2 * limit);
        int maxCh1 = Math.min(n, limit);
        for (int i = minCh1; i <= maxCh1; i++) {
            // remaining candies for children 2 and 3
            int remaining = n - i;
            // child 2 range given remaining must split between child 2 and 3
            int minCh2 = Math.max(0, remaining - limit);
            int maxCh2 = Math.min(remaining, limit);
            // number of valid distributions for children 2 and 3
            ways += maxCh2 - minCh2 + 1;
        }
        return ways;
    }
}

// Time Complexity :- O(min(n , limit).
// Space Complexity :- O(1).

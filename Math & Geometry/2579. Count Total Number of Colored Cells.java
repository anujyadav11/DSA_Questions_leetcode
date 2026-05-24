/*********************************************** JAVA **************************************************/

// Optimal Solution - Computes total colored cells in diamond growth pattern using the closed-form formula 1 + 2n(n-1).
/* "Always use 2L not 2 when multiplying large numbers into a long result — 2 * n * (n-1) computes as int first and overflows before assignment to long. 
    The L suffix forces the entire expression to evaluate as long arithmetic. For n up to 10^5, n*(n-1) can reach ~10^10 which far exceeds int range of ~2×10^9." */

class Solution {
    public long coloredCells(int n) {
        // formula: 1 + 2*n*(n-1) = total colored cells after n minutes
        return 1 + 2L * n * (n - 1);
    }
}

// Time Complexity :- O(1).
// Space Complexity :- O(1).

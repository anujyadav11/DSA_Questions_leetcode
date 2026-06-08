/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts valid attendance records of length n using 3D DP tracking absence count and trailing late count, with forward transitions for P/A/L additions.
/* "Always verify MOD value — 100000007 vs 1000000007 is a one-zero difference that silently gives wrong answers. Forward DP (push transitions) is cleaner here than backward (pull)
    — for each current state, push its count to all valid next states. Sum all dp[n][A][L] at the end since any combination of A≤1 and L≤2 is a valid final state." */

class Solution {
    int mod = 1000000007;

    public int checkRecord(int n) {
        // dp[i][A][L] = ways to form length-i string with A absences and L trailing lates
        int[][][] dp = new int[n + 1][2][3];
        // base case: empty string
        dp[0][0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int A = 0; A <= 1; A++) {
                for (int L = 0; L <= 2; L++) {
                    if (dp[i][A][L] == 0) continue;
                    // add 'P' — resets late counter to 0
                    dp[i + 1][A][0] = (dp[i + 1][A][0] + dp[i][A][L]) % mod;
                    // add 'A' — only if no absence used yet
                    if (A < 1)
                        dp[i + 1][A + 1][0] = (dp[i + 1][A + 1][0] + dp[i][A][L]) % mod;
                    // add 'L' — only if consecutive lates < 2
                    if (L < 2)
                        dp[i + 1][A][L + 1] = (dp[i + 1][A][L + 1] + dp[i][A][L]) % mod;
                }
            }
        }
        // sum all valid end states
        int res = 0;
        for (int A = 0; A <= 1; A++)
            for (int L = 0; L <= 2; L++)
                res = (res + dp[n][A][L]) % mod;
        return res;
    }
}

// Time Complexity :- O(n).— three nested loops with constant bounds 2×3=6 states per length
// Space Complexity :- O(n).— 3D dp table of size n×2×3; reducible to O(1) with rolling array

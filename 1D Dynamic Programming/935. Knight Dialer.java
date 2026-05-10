/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts distinct n-length knight dialer sequences using DP on a phone keypad graph, summing predecessor cell counts at each step under modulo.
/* "The adjacency list encodes knight moves on the keypad — hardcode it since the keypad is fixed. Space can be optimized to O(10) by using two rolling arrays instead of storing all n rows
    — prev and curr suffice since each row only depends on the previous. Always mention this optimization after presenting the O(n) space solution." */

public class Solution {
    private static final int M = 1000000007;
    // knight moves from each digit on phone keypad
    private static final List<List<Integer>> adj = Arrays.asList(
            Arrays.asList(4, 6),     // from 0
            Arrays.asList(6, 8),     // from 1
            Arrays.asList(7, 9),     // from 2
            Arrays.asList(4, 8),     // from 3
            Arrays.asList(3, 9, 0),  // from 4
            Arrays.asList(),         // from 5 — no valid knight moves
            Arrays.asList(1, 7, 0),  // from 6
            Arrays.asList(2, 6),     // from 7
            Arrays.asList(1, 3),     // from 8
            Arrays.asList(2, 4)      // from 9
    );
    public int knightDialer(int n) {
        // dp[i][cell] = number of valid sequences of length i+1 ending at cell
        int[][] dp = new int[n][10];
        // base case: sequences of length 1 — one way to be at each cell
        for (int cell = 0; cell < 10; cell++)
            dp[0][cell] = 1;
        // fill dp for lengths 2 to n
        for (int i = 1; i < n; i++) {
            for (int cell = 0; cell <= 9; cell++) {
                int ans = 0;
                // sum ways from all cells that can reach current cell
                for (int nextCell : adj.get(cell))
                    ans = (ans + dp[i - 1][nextCell]) % M;
                dp[i][cell] = ans;
            }
        }
        // sum ways to end at any digit for sequences of length n
        int result = 0;
        for (int cell = 0; cell <= 9; cell++)
            result = (result + dp[n - 1][cell]) % M;
        return result;
    }
}

// Time Complexity :- O(n × 10 × max_moves).
// Space Complexity :- O(n x 10).

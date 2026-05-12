/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds minimum keystrokes to produce n A's using DP, where each state picks the largest factor as copy point and minimises paste operations.
/* "The key insight is that optimal strategy always copies a complete set, then pastes — never copies partial. So for each n, find its largest factor f — copy at f then paste n/f - 1 times. 
    This naturally decomposes to prime factorisation: n = p1 × p2 × ... gives total steps = sum of prime factors." */

class Solution {
    public int minSteps(int n) {
        if (n == 1)
            return 0;
        int[] dp = new int[n + 1];
        // dp[i] = minimum steps to get exactly i A's on screen
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            // start from the largest factor — first valid factor gives the minimum steps
            int factor = i / 2;
            while (factor >= 1) {
                if (i % factor == 0) {
                    // copy all (1 step) + paste (i/factor - 1) times
                    dp[i] = dp[factor] + 1 + (i / factor - 1);
                    break;
                }
                factor--;
            }
        }
        return dp[n];
    }
}

// Time Complexity :- O(n^2 / 2).
// Space Complexity :- O(n).

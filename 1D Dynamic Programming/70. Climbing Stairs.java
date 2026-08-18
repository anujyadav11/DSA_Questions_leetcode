/*********************************************** JAVA **************************************************/

//Optimal Solution - A classic dynamic programming problem in which the number of ways to reach a step equals the sum of the ways to reach the previous two steps.

class Solution {
    public int climbStairs(int n) {
        // Base case: only one way to climb 1 stair
        if (n == 1) return 1;
        // dp[i] will store the number of ways to reach step i
        int[] dp = new int[n + 1];
        // Base cases
        dp[1] = 1; // one way: (1)
        dp[2] = 2; // two ways: (1+1), (2)
        // Fill the DP table
        for (int i = 3; i <= n; i++) {
            // Ways to reach i = ways from (i-1) + ways from (i-2)
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // Result is the number of ways to reach step n
        return dp[n];
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(N).

/*********************************************** JAVA **************************************************/

// One Pass Solution - Solve Climbing Stairs using Fibonacci-style DP with O(1) space.
/* “For every stair, I can arrive from either the previous stair using one step or two stairs below using two steps. 
    Therefore, the number of ways is dp[i-1] + dp[i-2]. Since each state only depends on the previous two states, I optimise the DP array to two variables.” */

class Solution {
    public int climbStairs(int n) {
        // Base cases
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        // Ways to reach the previous two stairs
        int prev2 = 1;
        int prev1 = 2;
        for (int i = 3; i <= n; i++) {
            // Current ways = previous one-step + two-step ways
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

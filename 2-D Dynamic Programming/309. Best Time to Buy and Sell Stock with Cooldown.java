/*********************************************** JAVA **************************************************/

// Optimal Solution - Dynamic programming solution for stock trading with cooldown using buy/sell state transitions. Track two states per day—can buy or must sell—and enforce cooldown by jumping two days after selling.
/* “I use top-down dynamic programming where each state is defined by the current day and whether I’m allowed to buy. If I can buy, 
    I choose between buying or skipping. If I’m holding a stock, I choose between selling or skipping. I memoize each state so every day-state combination is calculated only once.” */

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        // Initialize DP with -1 to mark states as not calculated
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        // Start from day 0 with permission to buy
        return f(0, 1, prices, dp);
    }
    public int f(int ind, int buy, int[] prices, int[][] dp) {
        // No days left
        if (ind >= prices.length)
            return 0;
        // Return already calculated state
        if (dp[ind][buy] != -1)
            return dp[ind][buy];
        if (buy == 1) {
            // Buy today or skip buying
            return dp[ind][buy] = Math.max(
                -prices[ind] + f(ind + 1, 0, prices, dp),
                f(ind + 1, 1, prices, dp)
            );
        }
        // Sell today or skip selling
        return dp[ind][buy] = Math.max(
            prices[ind] + f(ind + 1, 1, prices, dp),
            f(ind + 1, 0, prices, dp)
        );
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        // Number of days
        int n = prices.length;
        // dp[i][1] → max profit starting from day i when we are allowed to buy
        // dp[i][0] → max profit starting from day i when we must sell or skip
        // Extra 2 rows are used to safely handle i+1 and i+2 indexing (cooldown)
        int[][] dp = new int[n + 2][2];
        // Traverse days in reverse (bottom-up DP)
        for (int i = n - 1; i >= 0; i--) {
            // Option 1: Buy today (-prices[i]) and move to sell state
            // Option 2: Skip today and stay in buy state
            dp[i][1] = Math.max(
                    -prices[i] + dp[i + 1][0],
                    dp[i + 1][1]
            );
            // Option 1: Sell today (+prices[i]) and take cooldown (i + 2)
            // Option 2: Skip today and stay in sell state
            dp[i][0] = Math.max(
                    prices[i] + dp[i + 2][1],
                    dp[i + 1][0]
            );
        }
        // Starting at day 0 with permission to buy
        return dp[0][1];
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(N).

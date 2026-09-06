/*********************************************** JAVA **************************************************/

// Optimal Solution - Top-down DP solution to count coin change combinations using memoisation and unbounded choices. Model it as an unbounded knapsack: choose to take the same coin again or skip to the next, caching results to avoid recomputation.
/* “I define a state using the current coin index and the remaining amount. At each coin, I either take it and stay on the same index because coins can be reused, or skip it and move to the next coin. 
    The sum of these two choices gives the number of combinations. I memoize each (index, amount) state so it is calculated only once.” */

class Solution {
    int[][] memo;
    int n;
    public int numberOfWays(int[] coins, int i, int amount) {
        // Exact amount formed → one valid combination
        if (amount == 0) {
            return 1;
        }
        // No coins left or amount becomes negative
        if (i == n || amount < 0) {
            return 0;
        }
        // Return already calculated result
        if (memo[i][amount] != -1) {
            return memo[i][amount];
        }
        // Coin is too large, so skip it
        if (coins[i] > amount) {
            return memo[i][amount] =
                    numberOfWays(coins, i + 1, amount);
        }
        // Take the current coin and stay at the same index
        int take = numberOfWays(
                coins, i, amount - coins[i]
        );
        // Skip the current coin and move to the next coin
        int skip = numberOfWays(
                coins, i + 1, amount
        );
        // Total ways = take + skip
        return memo[i][amount] = take + skip;
    }
    public int change(int amount, int[] coins) {
        n = coins.length;
        // memo[i][amount] stores ways to form amount
        // using coins starting from index i
        memo = new int[coins.length][amount + 1];
        // -1 means the state has not been calculated
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return numberOfWays(coins, 0, amount);
    }
}

// Time Complexity :- O(n * amount).
// Space Complexity :- O(n * amount).

// 1D DP solution :- Count coin combinations using 1D bottom-up DP, reusing each coin while avoiding duplicate permutations.

class Solution {
    public int change(int amount, int[] coins) {
        // dp[i] = number of ways to make amount i
        int dp[] = new int[amount + 1];

        // One way to make amount 0: choose nothing
        dp[0] = 1;

        // Process each coin one by one
        for (int coin : coins) {

            // Build combinations using the current coin
            for (int j = coin; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coin];
            }
        }

        return dp[amount];
    }
}

// Time Complexity :- O(n * amount).
// Space Complexity :- O(amount).

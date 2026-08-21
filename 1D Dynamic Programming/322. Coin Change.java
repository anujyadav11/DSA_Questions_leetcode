/*********************************************** JAVA **************************************************/

// Optimal Solution - Use dynamic programming to compute the minimum number of coins needed to form each amount up to the target. This is an unbounded knapsack problem where each coin can be used unlimited times, solved using bottom-up DP.

class Solution {
    public int coinChange(int[] coins, int amount) {
        // No coins are needed to make amount 0
        if (amount < 1)
            return 0;
        // minDp[i] = minimum coins needed to make amount i
        int[] minDp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            // Mark amount i as initially unreachable
            minDp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                // Use this coin if it can contribute to amount i
                if (coin <= i &&
                    minDp[i - coin] != Integer.MAX_VALUE) {
                    // Take current coin and use best solution for remaining amount
                    minDp[i] = Math.min(minDp[i],1 + minDp[i - coin]);
                }
            }
        }
        // Amount cannot be formed
        if (minDp[amount] == Integer.MAX_VALUE)
            return -1;
        return minDp[amount];
    }
}

// Time Complexity :- O(amount x n).
// Space Complexity :- O(amount).

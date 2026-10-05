/*********************************************** JAVA **************************************************/

// Optimal Solution - Maximize stock trading profit by greedily capturing every positive price difference in O(n) time and O(1) space.
/* “Since multiple transactions are allowed and I can only hold one stock at a time, every positive day-to-day price difference contributes to the maximum profit. 
    Therefore, I greedily add every positive difference.” */

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            // If today's price is higher than yesterday's,
            // take the profit from this upward movement.
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

/*********************************************** JAVA *****************************************/

// Optimal Solution - We use a sliding window where the left pointer tracks the lowest buying price and the right pointer expands to find higher 
                    selling prices, resetting the window whenever a lower price appears to maintain maximum profit.

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // Sliding window pointers
        int left = 0;   // buy day (window start)
        int right = 1;  // sell day (window end)
        int maxProfit = 0;
        // Expand the window by moving the right pointer
        while (right < n) {
            // If the window is profitable, update max profit
            if (prices[right] > prices[left]) {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            } 
            // If not profitable, shrink/reset the window
            else {
                left = right; // move buy day to a lower price
            }
            // Move the window forward
            right++;
        }
        return maxProfit;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

/*********************************************** JAVA **************************************************/

// Optimal Solution -  Solved the Best Time to Buy and Sell Stock problem by tracking the minimum buying price seen so far and updating the maximum achievable profit in a single pass.

class Solution {
    public int maxProfit(int[] prices) {
        // Store the minimum price seen so far
        int buyPrice = prices[0];
        // Track the maximum profit
        int maxProfit = 0;
        for (int price : prices) {
            // Update the buying price if a lower price is found
            if (price < buyPrice) {
                buyPrice = price;
            } else {
                // Calculate profit by selling at the current price
                int currentProfit = price - buyPrice;
                // Update the maximum profit
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }
        return maxProfit;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).


/*********************************************** JAVA **************************************************/

// Optimal Solution - Sort prices and greedily buy the two cheapest chocolates to maximize remaining money.
/* "To maximize remaining money, I minimize spending by selecting the two cheapest chocolates. Sorting makes it easy to pick them." */

class Solution {
    public int buyChoco(int[] prices, int money) {
        // Sort prices to easily get the two cheapest chocolates
        Arrays.sort(prices);
        // Cost of buying the two cheapest chocolates
        int sum = prices[0] + prices[1];
        // If we cannot afford both chocolates, return the original money
        if (sum > money)
            return money;
        // If money is exactly equal to the sum, no money left
        if (sum == money)
            return 0;
        // Otherwise, return the remaining money after purchase
        money = money - sum;
        return money;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(1).

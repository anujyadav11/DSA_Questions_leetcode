/*********************************************** JAVA **************************************************/

// Optimal Solution - Use a monotonic stack to find the next smaller-or-equal price and apply discounts in O(n) time.
/* "This is a Next Smaller Element problem. I use a monotonic stack to keep indices of prices waiting for a discount. When a smaller price appears, I pop from the stack and apply the discount." */

class Solution {
    public int[] finalPrices(int[] prices) {
        // Stack will store indices of items whose discount hasn't been found yet
        Stack<Integer> indexStack = new Stack<>();
        int n = prices.length;
        // Result array to store final prices after discount
        int[] result = new int[n];
        // Traverse through all prices
        for (int currentIndex = 0; currentIndex < n; currentIndex++) {
            // While stack is not empty and current price can act as discount
            // for the item at the top index of the stack
            while (!indexStack.isEmpty() &&
                   prices[currentIndex] <= prices[indexStack.peek()]) {
                // Get the index of the previous item
                int prevIndex = indexStack.pop();
                // Apply discount
                result[prevIndex] = prices[prevIndex] - prices[currentIndex];
            }
            // Push current index to stack
            indexStack.push(currentIndex);
            // Default price (in case no discount appears later)
            result[currentIndex] = prices[currentIndex];
        }
        return result;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

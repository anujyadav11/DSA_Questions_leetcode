/*********************************************** JAVA **************************************************/

// Optimal Solution - Minimizes bookshelf total height using DP where each state tries all valid groupings of consecutive books on the same shelf within width constraint.
/* "The inner loop is the key — it greedily expands the current shelf leftward as long as width allows, tracking the running max height. dp[j-1] + height represents: place books before j optimally, 
    then put books j..i on one shelf. The outer loop's base case handles placing the current book alone — the inner loop finds if grouping with predecessors is better." */

class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;
        // dp[i] = minimum total height to place first i books
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int width = books[i - 1][0];
            int height = books[i - 1][1];
            // base case: place current book alone on new shelf
            dp[i] = dp[i - 1] + height;
            // try placing books j..i on the same shelf
            for (int j = i - 1; j > 0 && width + books[j - 1][0] <= shelf_width; j--) {
                // expand shelf leftward — update max height and total width
                height = Math.max(height, books[j - 1][1]);
                width += books[j - 1][0];
                // update dp[i] if placing books j..i together is better
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
            }
        }
        // return minimum height to shelve all books
        return dp[n];
    }
}

// Time Complexity :- O(n^2).
// Space Complexity :- O(n).

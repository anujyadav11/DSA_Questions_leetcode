/*********************************************** JAVA **************************************************/

// Optimal Solution - Dynamic programming solution to compute edit distance using insert, delete, and replace operations. Define DP on string prefixes and choose the cheapest operation at each mismatch.
/* “I define dp[i][j] as the minimum number of operations required to convert the first i characters of word1 into the first j characters of word2. 
    If the current characters match, I take the diagonal value without adding a cost. Otherwise, I consider replace, delete, and insert, take the minimum, and add one operation.” */

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // costDp[i][j] = minimum operations to convert
        // first i characters of word1 into first j characters of word2
        int[][] costDp = new int[m + 1][n + 1];
        // Convert word1 prefix to an empty string
        // Requires deleting all i characters
        for (int i = 0; i <= m; i++)
            costDp[i][0] = i;
        // Convert empty string to word2 prefix
        // Requires inserting all j characters
        for (int j = 0; j <= n; j++)
            costDp[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Characters already match, so no operation is needed
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    costDp[i][j] = costDp[i - 1][j - 1];
                } else {
                    int topLeft = costDp[i - 1][j - 1]; // Replace
                    int top = costDp[i - 1][j];         // Delete
                    int left = costDp[i][j - 1];        // Insert
                    // Choose the operation with minimum cost
                    costDp[i][j] = Math.min(
                        topLeft,
                        Math.min(top, left)
                    ) + 1;
                }
            }
        }
        return costDp[m][n];
    }
}
// Time Complexity :- O(m * n).
// Space Complexity :- O(m * n).

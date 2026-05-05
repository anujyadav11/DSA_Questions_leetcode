/*********************************************** JAVA **************************************************/

// Optimal Solution - Maximises binary matrix score by fixing first column to all-ones via row flips, then greedily maximising each column's ones count via column flips.
/* "The key insight is that the most significant bit (first column) always contributes more than all other bits combined — so make it all ones first. 
    For the remaining columns, compare countSameBit vs m - countSameBit — countSameBit gives ones after row flips since matching column 0 means the row flip that fixed column 0 also determined this column's value." */

class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        // grid[0].length for columns not grid.length
        int n = grid[0].length;
        // first column is always all 1s after optimal row flips — contributes m * 2^(n-1)
        int score = (int) Math.pow(2, n - 1) * m;
        for (int j = 1; j < n; j++) {
            // count cells where column j matches column 0 (same bit after row flips)
            int countSameBit = 0;
            for (int i = 0; i < m; i++)
                if (grid[i][j] == grid[i][0])
                    countSameBit++;
            // countSameBit = ones in this column after optimal row flips
            int countOnes = countSameBit;
            int countZeros = m - countOnes;
            // flip column if zeros outnumber ones — take max
            int ones = Math.max(countOnes, countZeros);
            score += (int) Math.pow(2, n - j - 1) * ones;
        }
        return score;
    }
}

// Time Complexity :- O(n * m).
// Space Complexity :- O(1).

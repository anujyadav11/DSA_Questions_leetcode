/*********************************************** JAVA **************************************************/

// Optimal Solution - Simulates champagne overflow row by row using a 2D DP grid, splitting excess equally to left and right children until the query glass is reached.
/*  "This is a triangle DP — each cell overflows its excess equally to two children below. The key details are: only propagate when extra > 0, 
      stop at query_row to avoid index issues, and always cap the final answer at 1.0 since a glass can't hold more than it's full." */

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        // 101x101 grid covers all possible rows and glasses (0-indexed up to 100)
        double[][] t = new double[101][101];
        // pour all champagne into the top glass
        t[0][0] = (double) poured;
        // simulate overflow row by row down to query_row
        for (int row = 0; row <= query_row; row++) {
            // each row has exactly row+1 glasses
            for (int col = 0; col <= row; col++) {
                // compute overflow: anything beyond 1 glass splits equally
                double extra = (t[row][col] - 1) / 2.0;
                if (extra > 0) {
                    // left child receives half the overflow
                    t[row + 1][col] += extra;
                    // right child receives other half
                    t[row + 1][col + 1] += extra;
                }
            }
        }
        // glass can hold at most 1.0 unit — cap the result
        return Math.min(1.0, t[query_row][query_glass]);
    }
}

// Time Complexity :- O(query_row ^ 2).
// Space Complexity :- O(1).

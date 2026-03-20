/*********************************************** JAVA **************************************************/

// Optimal Solution - Generates the largest-local-values matrix by finding the maximum in every 3×3 sliding window of an n×n grid.
/*  "Each cell of the output maps to a 3×3 window in the input. I use the top-left corner (i,j) as the anchor and scan 9 fixed cells — making each window O(1), giving O(n²) overall. 
      The key insight is that the result grid shrinks by 2 in each dimension." */

class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] maxLocal = new int[n - 2][n - 2]; // result is (n-2) x (n-2)
        for (int i = 0; i < n - 2; i++) { 
            // iterate over each valid top-left row
            for (int j = 0; j < n - 2; j++) { 
                // iterate over each valid top-left col
                maxLocal[i][j] = findLocalMax(grid, i, j); 
                // find max in 3x3 window
            }
        }
        return maxLocal; // return the result matrix
    }
    public int findLocalMax(int[][] grid, int i, int j) {
        int maxVal = Integer.MIN_VALUE; // initialize to smallest possible value
        for (int x = i; x <= i + 2; x++) { // traverse 3 rows of the window
            for (int y = j; y <= j + 2; y++) { // traverse 3 cols of the window
                maxVal = Math.max(maxVal, grid[x][y]); // track running maximum
            }
        }
        return maxVal; // return max of this 3x3 window
    }
}

// Time Complexity :- O(n ^ 2).
// Space Complexity :- O(n ^ 2).

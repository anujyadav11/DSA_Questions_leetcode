/*********************************************** JAVA **************************************************/

// Optimal Solution - Maximises matrix sum by summing absolute values and subtracting twice the minimum absolute value only when an odd count of negatives forces one to remain.
/* "The key insight is that adjacent flips can move a negative sign anywhere in the matrix — so only the parity of negatives matters, not their positions. Even count → make all positive. Odd count → one negative remains, 
    minimise its cost by placing it on the smallest absolute value. The sum - 2*min formula elegantly handles converting that one element from positive to negative." */

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0;
        int countNeg = 0;
        int smallestAbsVal = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // accumulate absolute values — best case all positive
                sum += Math.abs(matrix[i][j]);
                // count negative numbers
                if (matrix[i][j] < 0) countNeg++;
                // track the smallest absolute value for the odd negative case
                smallestAbsVal = Math.min(smallestAbsVal, Math.abs(matrix[i][j]));
            }
        }
        // even negatives — can flip all to positive via adjacent swaps
        if (countNeg % 2 == 0) return sum;
        // odd negatives — one negative must remain, minimise its impact
        return sum - 2 * smallestAbsVal;
    }
}

// Time Complexity :- O(n^2).
// Space Complexity :- O(1).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds the lucky number in a matrix by checking if the maximum row-minimum equals the minimum column-maximum.
/* "A lucky number must be the smallest in its row and largest in its column simultaneously. The key insight is that if max(rowMins) == min(colMaxes), 
    that single value satisfies both conditions — provably at most one such element exists." */

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        // get matrix dimensions
        int m = matrix.length;
        int n = matrix[0].length;
        // track the maximum among all row-minimums
        int rMinMax = Integer.MIN_VALUE;
        for (int row = 0; row < m; row++) {
            // find minimum element in current row
            int rMin = Integer.MAX_VALUE;
            for (int col = 0; col < n; col++) {
                // update row minimum
                rMin = Math.min(rMin, matrix[row][col]);
            }
            // keep the largest of all row minimums (FIXED: was Math.min)
            rMinMax = Math.max(rMin, rMinMax);
        }
        // track the minimum among all column-maximums
        int cMaxMin = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            // find maximum element in current column
            int cMax = Integer.MIN_VALUE;
            for (int row = 0; row < m; row++) {
                // update column maximum
                cMax = Math.max(cMax, matrix[row][col]);
            }
            // keep the smallest of all column maximums (FIXED: was Math.max)
            cMaxMin = Math.min(cMax, cMaxMin);
        }
        // if they match, that value is the lucky number (FIXED: was new ArrayList<>(cMaxMin))
        if (cMaxMin == rMinMax) return Arrays.asList(cMaxMin);
        // no lucky number found
        return new ArrayList<>();
    }
}

// Time Complexity :- O(m * n).
// Space Complexity :- O(1).

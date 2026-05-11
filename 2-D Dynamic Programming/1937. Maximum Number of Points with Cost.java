/*********************************************** JAVA **************************************************/

// Optimal Solution - Maximizes point collection across rows using left-right DP sweeps that propagate optimal previous-row values with column-distance penalties.
/* "The left-right sweep eliminates the O(n²) inner loop — instead of checking all previous columns for each current column, propagate the running maximum minus distance cost in two linear sweeps. 
    This reduces each row's transition from O(n²) to O(n). Always use Long.MIN_VALUE not Integer.MIN_VALUE when the variable type is long." */

class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        // initialize prev with first row values
        long[] prev = new long[n];
        for (int col = 0; col < n; col++)
            prev[col] = points[0][col];
        for (int i = 1; i < m; i++) {
            long[] curr = new long[n];
            // left[j] = best value reachable from left side at column j
            long[] left = new long[n];
            // right[j] = best value reachable from right side at column j
            long[] right = new long[n];
            // fill left — each step costs 1 (column distance penalty)
            left[0] = prev[0];
            for (int j = 1; j < n; j++)
                left[j] = Math.max(prev[j], left[j - 1] - 1);
            // fill right — each step costs 1
            right[n - 1] = prev[n - 1];
            for (int j = n - 2; j >= 0; j--)
                right[j] = Math.max(prev[j], right[j + 1] - 1);
            // current row: take best from left or right plus current cell value
            for (int j = 0; j < n; j++)
                curr[j] = points[i][j] + Math.max(left[j], right[j]);
            prev = curr;
        }
        // find maximum value in last processed row
        long max = Long.MIN_VALUE;
        for (long val : prev)
            max = Math.max(max, val);
        return max;
    }
}

// Time Complexity :- O(m * n).
// Space Complexity :- O(n).

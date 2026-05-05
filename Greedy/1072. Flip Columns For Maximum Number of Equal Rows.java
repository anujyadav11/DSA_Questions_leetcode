/*********************************************** JAVA **************************************************/

// Optimal Solution - Maximises equal rows after flips by normalising each row relative to its first element, counting the most frequent normalised pattern.
/* "The normalisation insight is key — a row [1,0,1] and its complement [0,1,0] both normalise to SDS and SDS respectively since both start with their own first element. 
    This means both can be flipped to the same target. Counting the most common normalised pattern answers without simulating any flips." */

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix[0].length;
        // maps normalised row pattern to its frequency
        Map<String, Integer> rowPatterns = new HashMap<>();
        for (int[] row : matrix) {
            StringBuilder pattern = new StringBuilder();
            int firstVal = row[0];
            //normalise row — 'S' if same as first element, 'D' if different
            for (int col = 0; col < n; col++)
                pattern.append(row[col] == firstVal ? 'S' : 'D');
            String key = pattern.toString();
            rowPatterns.put(key, rowPatterns.getOrDefault(key, 0) + 1);
        }
        int maxRows = 0;
        // maximum frequency = maximum rows that can be made equal
        for (int count : rowPatterns.values())
            maxRows = Math.max(maxRows, count);
        return maxRows;
    }
}

// Time Complexity :- O(m * n).
// Space Complexity :- O(m * n).

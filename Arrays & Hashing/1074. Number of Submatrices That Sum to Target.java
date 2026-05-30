/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts submatrices summing to target by fixing column boundaries and applying prefix sum HashMap technique on resulting 1D column-sum arrays.
/* "This reduces a 2D problem to repeated 1D 'subarray sum equals k' — a classic HashMap pattern. Row-wise prefix sums enable O(1) column range queries. 
    The three bugs here are all syntax/typo issues — always double-check containsKey spelling, HashMap put requires two arguments, and never compare a method result to map.values()." */

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // build prefix sum for each row
        for (int row = 0; row < rows; row++)
            for (int col = 1; col < cols; col++)
                matrix[row][col] += matrix[row][col - 1];
        int res = 0;
        // fix left column boundary
        for (int sc = 0; sc < cols; sc++) {
            // fix right column boundary
            for (int j = sc; j < cols; j++) {
                // use prefix sum hashmap to count subarrays summing to target
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int cumSum = 0;
                for (int row = 0; row < rows; row++) {
                    // column sum between sc and j for current row
                    cumSum += matrix[row][j] - (sc > 0 ? matrix[row][sc - 1] : 0);
                    if (map.containsKey(cumSum - target))
                        res += map.get(cumSum - target);
                    map.put(cumSum, map.getOrDefault(cumSum, 0) + 1);
                }
            }
        }
        return res;
    }
}

// Time Complexity :- O(cols² × rows).
// Space Complexity :- O(rows).

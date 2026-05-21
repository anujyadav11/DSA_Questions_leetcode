/*********************************************** JAVA **************************************************/

// Optimal Solution - Generates spiral order coordinates by simulating the outward spiral path with growing step sizes, recording only cells within grid bounds.
/* "The spiral pattern has a key property — each step size is used exactly twice (once horizontal, once vertical) before incrementing. 
    The direction order right→down→left→up is critical — wrong order produces a mirror or rotated spiral. Walking outside bounds is intentional — the spiral path continues regardless, we just filter valid cells." */

class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        // FIXED: correct spiral direction order — right, down, left, up
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int n = rows * cols;
        int[][] res = new int[n][2];
        // starting cell is always included first
        res[0][0] = rStart;
        res[0][1] = cStart;
        int count = 1;
        int step = 1;
        int index = 0;
        while (count < n) {
            // each step size is used for two directions before increasing
            for (int times = 0; times < 2; times++) {
                int dr = directions[index % 4][0];
                int dc = directions[index % 4][1];
                // move 'step' cells in current direction
                for (int i = 0; i < step; i++) {
                    rStart += dr;
                    cStart += dc;
                    // only record cell if it falls within grid bounds
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        res[count][0] = rStart;
                        res[count][1] = cStart;
                        count++;
                    }
                }
                // move to next direction
                index++;
            }
            // after every two directions, increase step size
            step++;
        }
        return res;
    }
}

// Time Complexity :- O(max(row, col) ^ 2).
// Space Complexity :- O(row * col).

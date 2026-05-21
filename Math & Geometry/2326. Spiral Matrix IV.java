/*********************************************** JAVA **************************************************/

// Optimal Solution - Fills a matrix in spiral order from a linked list by traversing four boundaries per layer and shrinking inward, leaving unfilled cells as -1.
/* "The boundary shrink order matters — increment topRow after top traversal, decrement rightCol after right traversal, and so on. Moving col < rightCol vs col <= rightCol is the classic off-by-one in spiral problems 
    — the top-right corner belongs to the top row traversal, not the right column traversal. Inline null check && head != null in loop condition is cleaner than breaking mid-loop." */

class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        // fill with -1 — default for unfilled cells
        for (int[] row : matrix)
            Arrays.fill(row, -1);
        int topRow = 0, bottomRow = m - 1;
        int leftCol = 0, rightCol = n - 1;
        while (head != null) {
            // traverse top row left to right <= rightCol to include corner
            for (int col = leftCol; col <= rightCol && head != null; col++) {
                matrix[topRow][col] = head.val;
                head = head.next;
            }
            topRow++;
            // traverse right column top to bottom
            for (int row = topRow; row <= bottomRow && head != null; row++) {
                matrix[row][rightCol] = head.val;
                head = head.next;
            }
            rightCol--;
            // traverse bottom row right to left
            for (int col = rightCol; col >= leftCol && head != null; col--) {
                matrix[bottomRow][col] = head.val;
                head = head.next;
            }
            bottomRow--;
            // traverse left column bottom to top
            for (int row = bottomRow; row >= topRow && head != null; row--) {
                matrix[row][leftCol] = head.val;
                head = head.next;
            }
            leftCol++;
        }
        return matrix;
    }
}

// Time Complexity :- O(m * n).
// Space Complexity :- O(m * n).

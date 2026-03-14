/*********************************************** JAVA **************************************************/

// Optimal Solution - Use DFS with BST pruning to sum nodes whose values lie within the given range.
/* "Since it's a BST, I prune unnecessary branches. If the node value is smaller than low, I only explore the right subtree; if larger than high, I only explore the left subtree." */

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        // Base case: if the node is null, contribute 0 to the sum
        if (root == null)
            return 0;
        int sum = 0; // Store sum of valid nodes
        // If current value is greater than low,
        // the left subtree might contain values within range
        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }
        // If current node lies within the range, include it in sum
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        // If current value is less than high,
        // the right subtree might contain values within range
        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }
        return sum;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(h).

/*************************************************** JAVA ***********************************************/

// Optimal Solution - We compute subtree heights bottom-up and immediately return -1 whenever a node is unbalanced to avoid unnecessary traversal.

class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
    private int getHeight(TreeNode node) {
        // Empty tree has height 0
        if (node == null) {
            return 0;
        }
        // Get height of left subtree
        int left = getHeight(node.left);
        // If left subtree is unbalanced, propagate -1
        if (left == -1) {
            return -1;
        }
        // Get height of right subtree
        int right = getHeight(node.right);
        // If right subtree is unbalanced, propagate -1
        if (right == -1) {
            return -1;
        }
        // Current node is unbalanced
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        // Return height of current subtree
        return 1 + Math.max(left, right);
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(H). height of the tree.

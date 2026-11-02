/*********************************************** JAVA **************************************************/

// Optimal Solution - Solved Delete Node in BST using iterative search and subtree reconnection with O(h) time and O(h) worst-case auxiliary space due to recursive rightmost-node traversal.
/* "I first search for the target node using the BST ordering property. Once found, I handle deletion based on its children. If it has two children, 
    I find the rightmost node in its left subtree and attach the original right subtree there. I then promote the left subtree, preserving the BST ordering." */

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        // If the tree is empty, nothing to delete.
        if (root == null) {
            return null;
        }
        // If the root itself is the node to delete.
        if (root.val == key) {
            return helper(root);
        }
        // Preserve the original root.
        TreeNode dummy = root;
        // Search for the node to delete.
        while (root != null) {
            if (root.val > key) {
                // Target is the left child.
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                // Target is the right child.
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        // Return the updated BST root.
        return dummy;
    }
    // Handles deletion of a node once it is found.
    public TreeNode helper(TreeNode root) {
        // Case 1: No left child.
        if (root.left == null) {
            return root.right;
        }
        // Case 2: No right child.
        if (root.right == null) {
            return root.left;
        }
        // Case 3: Both children exist.
        TreeNode rightChild = root.right;
        // Find the rightmost node in the left subtree.
        TreeNode lastRight = findLastRight(root.left);
        // Attach the original right subtree.
        lastRight.right = rightChild;
        // Promote the left subtree.
        return root.left;
    }
    // Finds the maximum-valued node in a subtree.
    public TreeNode findLastRight(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        return findLastRight(root.right);
    }
}

// Time Complexity :- O(h).
// Space Complexity :- O(h). worst Case

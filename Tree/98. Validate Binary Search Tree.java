/*********************************************** JAVA **************************************************/

// Optimal Solution - Validate a BST using DFS with dynamically narrowed min/max bounds for every subtree.
/* “I validate the tree using DFS while maintaining the valid range for every node. Initially the range is negative infinity to positive infinity. 
    For the left subtree, the upper bound becomes the current node’s value, and for the right subtree, the lower bound becomes the current node’s value. 
    If any node falls outside its allowed range, the tree is invalid.” */

class Solution {
    public boolean isValidBST(TreeNode root) {
        // Initially, the root can contain any valid integer value.
        // We use long boundaries so that Integer.MIN_VALUE
        // and Integer.MAX_VALUE are handled correctly.
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean validate(TreeNode root, long min, long max) {
        // An empty subtree is a valid BST.
        if (root == null) {
            return true;
        }
        // Current node must lie strictly inside the allowed range.
        // BST does not allow duplicate values in this problem.
        if (root.val <= min || root.val >= max) {
            return false;
        }
        // For the left subtree:
        // Every value must be smaller than the current node.
        boolean left = validate(root.left,min,root.val);
        // For the right subtree:
        // Every value must be greater than the current node.
        boolean right = validate(root.right,root.val,max);
        // Both subtrees must satisfy the BST property.
        return left && right;
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(H).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Implemented iterative BST insertion using ordered traversal with O(h) time and O(1) auxiliary space.
/* "I iteratively traverse the BST using its ordering property. If the target value is greater than or equal to the current node, 
    I move right; otherwise, I move left. Once I find a null child in the appropriate direction, I insert the new node and return the original root." */

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // If the tree is empty, create the root node.
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while (true) {
            // If value is greater than or equal to current node,
            // move towards the right subtree.
            if (cur.val <= val) {
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    // Insert at the first available right position.
                    cur.right = new TreeNode(val);
                    break;
                }
            } else {
                // If value is smaller, move towards the left subtree.
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    // Insert at the first available left position.
                    cur.left = new TreeNode(val);
                    break;
                }
            }
        }
        // Return the original root.
        return root;
    }
}

// Time Complexity :- O(h).
// Space Complexity :- O(1).

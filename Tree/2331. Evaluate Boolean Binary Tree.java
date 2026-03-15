/*********************************************** JAVA **************************************************/

// Optimal Solution - Evaluate a boolean expression tree using DFS by recursively applying OR and AND operations.
/* "This tree represents a boolean expression. Leaf nodes return true or false, and internal nodes apply OR or AND to the results of their children using a DFS traversal." */

class Solution {
    public boolean evaluateTree(TreeNode root) {
        // If the node is a leaf node
        // Leaf nodes contain either 0 (false) or 1 (true)
        if (root.left == null && root.right == null) {
            return root.val != 0; // Convert integer value to boolean
        }
        // If the node value is 2 → it represents OR operation
        if (root.val == 2) {
            // Evaluate left and right subtree and apply OR
            return evaluateTree(root.left) | evaluateTree(root.right);
        }
        // Otherwise the node value is 3 → it represents AND operation
        return evaluateTree(root.left) & evaluateTree(root.right);
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(h).

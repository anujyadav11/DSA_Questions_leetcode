/*********************************************** JAVA **************************************************/

// Optimal Solution - Implemented recursive postorder DFS to remove target-valued leaf nodes, including newly formed leaves, in O(n) time and O(h) auxiliary space.
/* "I solve this problem using recursive postorder DFS. I first recursively process the left and right subtrees, updating the child references with their returned results. 
    Then I check whether the current node has become a leaf and whether its value matches the target. If both conditions hold, I return null to delete it. 
    Processing children first also handles cases where deleting a leaf creates a new target-valued leaf at its parent." */

class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        // Base case: an empty node requires no processing.
        if (root == null) {
            return null;
        }
        // First process the left subtree.
        root.left = removeLeafNodes(root.left, target);
        // Then process the right subtree.
        root.right = removeLeafNodes(root.right, target);
        // After processing children, check whether the current node
        // has become a leaf with the target value.
        if (root.left == null &&
            root.right == null &&
            root.val == target) {
            // Delete the current node by returning null.
            return null;
        }
        // Keep the current node.
        return root;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(h).

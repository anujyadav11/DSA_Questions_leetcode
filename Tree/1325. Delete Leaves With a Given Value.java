/*********************************************** JAVA **************************************************/

// Optimal Solution - Recursively removes target-valued leaf nodes bottom-up using post-order DFS, allowing newly exposed leaves to be evaluated after their children are pruned.
/* "Post-order is essential here — processing children first means a node only checks itself as a leaf after its subtree is fully pruned. This handles cascading deletions automatically: 
    if removing a leaf makes its parent a target leaf, the parent check happens naturally on the way back up the recursion." */

class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        // base case: null node — nothing to remove
        if (root == null) return null;
        // post-order: process children before parent
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        // after children removed, check if current node became a target leaf
        if (root.left == null && root.right == null && root.val == target)
            return null;
        // keep node — not a target leaf
        return root;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n). n is the size of the recursion stack.

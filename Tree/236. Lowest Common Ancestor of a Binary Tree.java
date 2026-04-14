/*********************************************** JAVA **************************************************/

// Optimal Solution - Use recursion to find nodes in subtrees and return the node where both sides are non-null as the LCA.
/* “If both nodes are found in different subtrees of a node, that node is their lowest common ancestor.” */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case:
        // If node is null OR matches p or q → return it
        if (root == null || root == p || root == q)
            return root;
        // Search in left subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // Search in right subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // If one side is null → return the other side
        if (left == null)
            return right;
        else if (right == null)
            return left;
        // If both sides returned non-null → current node is LCA
        else
            return root;
    }
}

// Time Complexity :- O(n). n = because of we are going to every node of the tree.
// Space Complexity :- O(h). h = height of the tree in the worst case.

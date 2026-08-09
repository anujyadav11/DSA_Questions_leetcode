/*********************************************** JAVA **************************************************/

// Optimal Solution - Recursively search both subtrees and return the node where paths to p and q diverge, which is their lowest common ancestor.

/*“Because this is a BST, I don’t need to search both subtrees. If both nodes are smaller than the current node, their LCA must be in the left subtree. 
   If both are larger, it must be in the right subtree. Otherwise, the current node is where their paths split, so it is the LCA.”*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // If the tree is empty, or we have reached p or q,
        // the current node is the answer for this recursive path.
        if (root == null || root == p || root == q) {
            return root;
        }
        // Both p and q are smaller than root.
        // Therefore, both must be in the left subtree.
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // Both p and q are greater than root.
        // Therefore, both must be in the right subtree.
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // Otherwise, p and q are on different sides of root,
        // or root itself is one of p/q.
        // Therefore, root is their Lowest Common Ancestor.
        return root;
    }
}

// Time Complexity :- O(H).h = height of the tree.
// Space Complexity :- O(H).

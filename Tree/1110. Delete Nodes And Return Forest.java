/*********************************************** JAVA **************************************************/

// Optimal Solution - Builds a forest after node deletions using post-order DFS, promoting deleted nodes' children as new tree roots and returning null to detach deleted nodes from parents.
/* "Post-order is critical — children must be processed before the parent so that when a node is deleted, its children are already correctly formed subtrees ready to be added as forest roots. 
    The return null propagates deletion upward automatically, cleanly detaching the node from its parent without extra bookkeeping." */

class Solution {
    public TreeNode dfs(TreeNode root, Set<Integer> toDelete, List<TreeNode> forest) {
        // base case: null node
        if (root == null)
            return null;
        // post-order: process children before deciding on current node
        root.left = dfs(root.left, toDelete, forest);
        root.right = dfs(root.right, toDelete, forest);
        // current node not deleted — keep it in its current tree
        if (!toDelete.contains(root.val))
            return root;
        // current node deleted — its children become new forest roots
        if (root.left != null)
            forest.add(root.left);
        if (root.right != null)
            forest.add(root.right);
        // detach children and remove current node
        root.left = null;
        root.right = null;
        return null;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        // build deletion set for O(1) lookup
        Set<Integer> set = new HashSet<>();
        for (int val : to_delete)
            set.add(val);
        List<TreeNode> forest = new ArrayList<>();
        // DFS returns null if root itself is deleted
        root = dfs(root, set, forest);
        // if root survived deletion — add it as a forest tree
        if (root != null)
            forest.add(root);
        return forest;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

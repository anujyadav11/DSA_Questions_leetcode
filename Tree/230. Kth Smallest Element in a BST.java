/*********************************************** JAVA **************************************************/

// Optimal Solution - Use inorder traversal of the BST to visit nodes in sorted order and return the kth visited node.
/* “Since this is a BST, inorder traversal visits nodes in ascending order. I maintain a counter pos that increments whenever I visit a node.
    When pos becomes equal to k, the current node is the kth smallest element. I also propagate the found node back through recursion so that traversal stops early.” */

class Solution {
    // Keeps track of how many nodes we have visited
    // during inorder traversal.
    int pos = 0;
    public int kthSmallest(TreeNode root, int k) {
        // Find the kth node using inorder traversal
        TreeNode node = inOrder(root, k);
        // If kth node doesn't exist
        return node == null ? -1 : node.val;
    }
    public TreeNode inOrder(TreeNode root, int k) {
        // Reached an empty subtree
        if (root == null) {
            return null;
        }
        // First visit the left subtree.
        // In a BST, all left values are smaller than root.
        TreeNode left = inOrder(root.left, k);
        // If the kth smallest node was already found
        // in the left subtree, return it immediately.
        if (left != null) {
            return left;
        }
        // We are now visiting the current node.
        pos++;
        // If this is the kth visited node,
        // it is the kth smallest element.
        if (pos == k) {
            return root;
        }
        // Continue searching in the right subtree.
        return inOrder(root.right, k);
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(H).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Serialise both trees using preorder traversal and check whether the serialised subtree exists inside the serialised main tree.
/* “I serialise both trees using preorder traversal, including null nodes to preserve their structure. 
    Then I check whether the serialisation of subRoot is contained in the serialisation of root. If it is, then subRoot exists as a subtree of root.” */

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Serialize the complete tree using preorder traversal
        String fullTree = preOrderTraversal(root);
        // Serialize the subtree using preorder traversal
        String subTree = preOrderTraversal(subRoot);
        // If the serialised subtree exists inside the serialised
        // complete tree, then subRoot is a subtree of root
        return (fullTree.contains(subTree));
    }
    public String preOrderTraversal(TreeNode root) {
        // Represent a null node with "null"
        // This helps preserve the tree structure
        if (root == null)
            return "null";
        // "^" is used as a delimiter/marker before each node value
        StringBuilder sb = new StringBuilder("^");
        // Add current node's value
        sb.append(root.val);
        //Serialise the left subtree
        sb.append(preOrderTraversal(root.left));
        //Serialise the right subtree
        sb.append(preOrderTraversal(root.right));
        return sb.toString();
    }
}

// Time Complexity :- O(N * M).
// Space Complexity :- O(N + M).

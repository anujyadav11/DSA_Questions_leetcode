/*********************************************** JAVA **************************************************/

// Optimal Solution - Use DFS to collect leaf sequences of two trees and compare them for equality.
/* "I traverse both trees using DFS and record their leaf nodes in order. If the two sequences are identical, the trees are leaf-similar." */

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // Lists to store leaf node values of both trees
        List<Integer> leafList1 = new ArrayList<>();
        List<Integer> leafList2 = new ArrayList<>();
        // Collect leaf nodes from the first tree
        dfs(root1, leafList1);
        // Collect leaf nodes from the second tree
        dfs(root2, leafList2);
        // Compare both leaf sequences
        return leafList1.equals(leafList2);
    }
    public void dfs(TreeNode root, List<Integer> leafList){
        // Base case: if node is null, return
        if(root == null){
            return;
        }
        // If current node is a leaf node (no children)
        if(root.left == null && root.right == null){
            // Add leaf value to the list
            leafList.add(root.val);
            return;
        }
        // Traverse left subtree
        dfs(root.left, leafList);
        // Traverse right subtree
        dfs(root.right, leafList);
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

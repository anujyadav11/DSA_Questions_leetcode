/*********************************************** JAVA **************************************************/

// Optimal Solution - Traverse the tree using DFS while tracking the maximum value on the path to count nodes that are not smaller than any of their ancestors.
/* “I traverse the tree using DFS and carry the maximum value seen on the path from the root. For each node, if its value is greater than or equal to that maximum, 
    it is a good node. I increment the count and update the maximum before recursively processing its children.” */
    
class Solution {
    public int goodNodes(TreeNode root) {
        // Start DFS with the smallest possible value
        // so the root will always be considered a good node.
        return dfs(root, Integer.MIN_VALUE);
    }
    public int dfs(TreeNode root, int maxSoFar) {
        // Reached beyond a leaf node
        // No good node here
        if (root == null) {
            return 0;
        }
        int res = 0;
        // A node is good if its value is greater than
        // or equal to every value on the path from root to itself.
        if (root.val >= maxSoFar) {
            res++;
            // Update the maximum value seen on this path
            maxSoFar = root.val;
        }
        // Count good nodes in the left subtree
        res += dfs(root.left, maxSoFar);
        // Count good nodes in the right subtree
        res += dfs(root.right, maxSoFar);
        return res;
    }
}

//Time Complexity :- O(N). Number of nodes in the tree.
// Space Complexity :- O(H). Height of the tree.

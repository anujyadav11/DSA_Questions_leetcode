/*********************************************** JAVA **************************************************/

// Optimal Solution - Implemented recursive DFS using Root → Left → Right traversal with O(n) time and O(h) auxiliary space.
/* "I use recursive Depth-First Search to perform preorder traversal. For each node, I first add its value to the result list, then recursively traverse its left subtree followed by its right subtree. 
    The recursion terminates when a null node is encountered. Every node is visited exactly once, giving O(n) time complexity and O(h) auxiliary space for the recursion stack." */

class Solution {
    // Method to perform preorder traversal of a binary tree
    public List<Integer> preorderTraversal(TreeNode root) {
        // Create a list to store the result of preorder traversal
        List<Integer> result = new ArrayList<>();
        // Call the helper method to perform the actual traversal
        dfs(root, result);
        // Return the final result
        return result;
    }
    // Helper method for recursive depth-first search (DFS)
    // Traverses the binary tree in preorder fashion: current node, left subtree, right subtree
    private void dfs(TreeNode node, List<Integer> result) {
        // Base case: if the current node is null, return
        if (node == null) {
            return;
        }
        // Add the value of the current node to the result list
        result.add(node.val);
        // Recursively traverse the left subtree
        dfs(node.left, result);
        // Recursively traverse the right subtree
        dfs(node.right, result);
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // Store the preorder traversal result.
        List<Integer> result = new ArrayList<>();
        // Handle an empty tree.
        if (root == null) {
            return result;
        }
        // Stack simulates recursive DFS.
        Stack<TreeNode> stack = new Stack<>();
        // Start traversal from the root.
        stack.push(root);
        while (!stack.isEmpty()) {
            // Process the current node.
            TreeNode node = stack.pop();
            // Visit the root.
            result.add(node.val);
            // Push right first so that left is processed first.
            if (node.right != null) {
                stack.push(node.right);
            }
            // Push left second.
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(h).

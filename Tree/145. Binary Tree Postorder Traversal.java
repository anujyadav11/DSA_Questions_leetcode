/*********************************************** JAVA **************************************************/

// Optimal Solution - Implemented recursive DFS using Left → Right → Root traversal with O(n) time and O(h) auxiliary space.
/* "I use recursive Depth-First Search for postorder traversal. For each node, I first recursively process its left subtree, then its right subtree, and finally add the current node to the result. 
    This ensures that both children are processed before their parent. Every node is visited exactly once, resulting in O(n) time complexity and O(h) auxiliary space." */

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        // Store the postorder traversal result.
        List<Integer> res = new ArrayList<>();
        // Start recursive DFS from the root.
        dfs(root, res);
        return res;
    }
    private void dfs(TreeNode node, List<Integer> res) {
        // Base case: stop when the current node is null.
        if (node == null) {
            return;
        }
        // Step 1: Traverse the left subtree.
        dfs(node.left, res);
        // Step 2: Traverse the right subtree.
        dfs(node.right, res);
        // Step 3: Visit the current node (Root).
        res.add(node.val);
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(h).

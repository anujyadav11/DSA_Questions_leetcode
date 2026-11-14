/*********************************************** JAVA **************************************************/

// Optimal Solution - Implemented Tree DP using postorder DFS and include/exclude states to maximize the amount robbed without selecting adjacent parent-child nodes, achieving O(n) time and O(h) auxiliary space.
/* "I solve this using tree dynamic programming with postorder DFS. For each node, I maintain two states: the maximum amount when robbing that node and the maximum amount when skipping it. 
    If I rob the current node, I must skip both children. If I skip it, I can independently choose the better result from each child. I calculate these states bottom-up and return the maximum of the two root states." */

class Solution {
    public int rob(TreeNode root) {
        // Get the two possible maximum robbery amounts for the root.
        int[] options = travel(root);
        // Return the better option.
        return Math.max(options[0], options[1]);
    }
    private int[] travel(TreeNode root) {
        // Base case: an empty subtree contributes zero.
        if (root == null) {
            return new int[2];
        }
        // Calculate the optimal results for both subtrees.
        int[] leftNode = travel(root.left);
        int[] rightNode = travel(root.right);
        // options[0]: Maximum money when robbing the current node.
        // options[1]: Maximum money when NOT robbing the current node.
        int[] options = new int[2];
        // If we rob the current node, we cannot rob either child.
        options[0] = root.val + leftNode[1] + rightNode[1];
        // If we skip the current node, each child can be robbed or skipped.
        options[1] =
            Math.max(leftNode[0], leftNode[1]) +
            Math.max(rightNode[0], rightNode[1]);
        return options;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(h).

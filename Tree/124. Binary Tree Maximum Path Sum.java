/*********************************************** JAVA **************************************************/

//Optimal Solution - Use DFS to compute the maximum downward path from each node while tracking the global maximum path sum that may pass through any node.
/* “I use postorder DFS because a node’s best path depends on the best paths from its children. For each node, I calculate the maximum contribution from the left and right subtrees, 
    ignoring negative contributions. A path passing through the current node can use both sides, so I update the global answer with left + root + right. 
    However, when returning to the parent, I can only return one branch, so I return root + max(left, right). This distinction allows us to find the maximum path anywhere in the tree.” */

class Solution {
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
    public int solve(TreeNode root) {
        if (root == null) return 0;
        // Ignore negative paths because they reduce the sum
        int l = Math.max(0, solve(root.left));
        int r = Math.max(0, solve(root.right));
        // Path passing through the current node
        int subRoot = l + r + root.val;
        // Best path that can be extended to the parent
        int singlePath = Math.max(l, r) + root.val;
        // Update global maximum
        maxSum = Math.max(maxSum, subRoot);
        // Return only one side because a parent cannot
        // use both left and right branches simultaneously
        return singlePath;
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(H).

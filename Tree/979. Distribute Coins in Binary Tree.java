/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts minimum coin distribution moves using post-order DFS, summing absolute excess coin flow across every tree edge.
/* "The key insight is that each edge carries |excess| moves — excess being surplus or deficit coins that must flow through that edge. 
    Post-order ensures children report their excess before the parent accumulates it. Returning excess not moves is critical — 
    The return value represents coins flowing upward through the current edge, not the global counter." */

class Solution {
    int moves = 0;
    public int distributeCoins(TreeNode root) {
        moves = 0;
        dfs(root);
        return moves;
    }
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        // get excess coins flowing from left and right subtrees
        int leftExcess = dfs(root.left);
        int rightExcess = dfs(root.right);
        // excess at current node = coins from children + own coins - 1 (keep 1)
        int excess = leftExcess + rightExcess + (root.val - 1);
        // each unit of excess requires one move through this edge
        moves += Math.abs(excess);
        // return excess coins (not global moves) to parent
        return excess;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(h).

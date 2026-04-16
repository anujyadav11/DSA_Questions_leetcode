/*********************************************** JAVA **************************************************/

// Optimal Solution - Use postorder traversal to track leaf distances and count valid pairs by combining left and right subtrees.
/* “I use postorder traversal to collect leaf distances and combine left and right subtree distances to count valid pairs.” */

class Solution {
    int res = 0;
    public int[] dfs(TreeNode root, int distance) {
        // Distance array: index = distance from current node
        int[] leafDist = new int[distance + 1];
        // Base case
        if (root == null)
            return leafDist;
        // Leaf node → distance 1
        if (root.left == null && root.right == null) {
            leafDist[1] = 1;
            return leafDist;
        }
        int[] leftLeafDist = dfs(root.left, distance);
        int[] rightLeafDist = dfs(root.right, distance);
        // Count valid pairs
        for (int d1 = 1; d1 <= distance; d1++) {
            for (int d2 = 1; d2 <= distance; d2++) {
                
                if (d1 + d2 <= distance) {
                    res += leftLeafDist[d1] * rightLeafDist[d2];
                }
            }
        }
        // Build current node distances
        for (int d = 2; d <= distance; d++) {
            leafDist[d] = leftLeafDist[d - 1] + rightLeafDist[d - 1];
        }
        return leafDist;
    }
    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return res;
    }
}

// Time Complexity :- O(n * n^2).
// Space Complexity :- O(n * d).

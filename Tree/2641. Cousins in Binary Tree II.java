/*********************************************** JAVA **************************************************/

// Optimal Solution - Replaces each tree node's value with the sum of its cousin nodes using BFS level-order processing with sibling sum pre-computation per parent.
/* "The two-step value update is the key — at each parent, temporarily store sibling sum in children. When those children are processed in the next level, levelSum - 
    cur.val correctly computes the cousin sum since cur.val currently holds the sibling sum. Always accumulate nextLevelSum from original values before modifying them — 
    Modification order matters here." */

class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null)
            return root;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        // root has no cousins — its value becomes 0
        int levelSum = root.val;
        while (!que.isEmpty()) {
            int n = que.size();
            int nextLevelSum = 0;
            while (n-- > 0) {
                TreeNode cur = que.poll();
                // replace current node value with level sum minus its own value
                cur.val = levelSum - cur.val;
                // sibling sum = sum of current node's children (they share the same parent)
                int siblingSum = (cur.left != null ? cur.left.val : 0)
                        + (cur.right != null ? cur.right.val : 0);
                if (cur.left != null) {
                    // accumulate next level sum before modifying value
                    nextLevelSum += cur.left.val;
                    // child's new value = sibling sum (cousin values added later via levelSum)
                    cur.left.val = siblingSum;
                    que.add(cur.left);
                }
                if (cur.right != null) {
                    nextLevelSum += cur.right.val;
                    cur.right.val = siblingSum;
                    que.add(cur.right);
                }
            }
            levelSum = nextLevelSum;
        }
        return root;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(w).— queue holds at most one level's nodes, where w is the maximum width

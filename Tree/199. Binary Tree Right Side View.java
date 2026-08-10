/*********************************************** JAVA **************************************************/

// Optimal Solution - Use level-order traversal and record the last node at each level to obtain the binary tree’s right-side view.
/* “I use BFS because I need to process the tree level by level. For each level, I record its size and process exactly that many nodes from left to right. 
    The last node processed at that level is the rightmost node, so I add its value to the result.” */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // Stores the rightmost value from each level
        List<Integer> res = new ArrayList<>();
        // Empty tree has no visible nodes
        if (root == null)
            return res;
        // Queue for level-order traversal
        Queue<TreeNode> que = new LinkedList<>();
        // Start BFS from root
        que.offer(root);
        while (!que.isEmpty()) {
            // Number of nodes at the current level
            int size = que.size();
            // Will store the value of the last node
            // processed at this level
            int lastVal = 0;
            // Process all nodes in the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                // Since nodes are processed from left to right,
                // the last node is the rightmost node of this level
                lastVal = node.val;
                // Add left child for the next level
                if (node.left != null) {
                    que.offer(node.left);
                }
                // Add right child for the next level
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            // Add the rightmost node of this level
            res.add(lastVal);
        }
        return res;
    }
}

// Time Complexity :- O(N). Number of nodes in the tree.
// Space Complexity :- O(N).

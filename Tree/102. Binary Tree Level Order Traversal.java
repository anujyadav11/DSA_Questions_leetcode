/*********************************************** JAVA **************************************************/

// Optimal Solution - Perform a breadth-first traversal using a queue to collect nodes level by level in a binary tree.
/* “I use BFS because level-order traversal naturally maps to a queue. At the beginning of each level, I store the current queue size. 
    I then process exactly that many nodes, add their values to the current level list, and push their children into the queue for the next level. 
    After processing the level, I add the list to the result.” */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // If tree is empty, return an empty result
        if (root == null) {
            return new ArrayList<>();
        }
        // Stores the final level-order traversal
        List<List<Integer>> res = new ArrayList<>();
        // Queue is used for BFS
        Queue<TreeNode> que = new LinkedList<>();
        // Start BFS from root
        que.offer(root);
        while (!que.isEmpty()) {
            // Number of nodes present at the current level
            int size = que.size();
            // One list represents one complete level
            List<Integer> temp = new ArrayList<>();
            // Process all nodes of the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                // Add current node to this level
                temp.add(node.val);
                // Add left child for the next level
                if (node.left != null) {
                    que.offer(node.left);
                }
                // Add right child for the next level
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            // Add the completed level to the result
            res.add(temp);
        }
        return res;
    }
}

// Time Complexity :- O(N).
//  Space Complexity :- O(N).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Perform BFS and reverse node values at odd levels using two-pointer technique.
/* “I perform level order traversal and reverse values at odd levels without modifying the tree structure.” */

class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        int level = 0;  // Track current level
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            ArrayList<TreeNode> list = new ArrayList<>();
            // Process current level
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                // Add children for next level
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }   
                // Collect nodes only for odd levels
                if (level % 2 != 0) {
                    list.add(node);
                }
            }
            // Reverse values for odd levels
            if (level % 2 != 0) {
                int l = 0;
                int r = list.size() - 1;
                while (l < r) {  
                    int temp = list.get(l).val;
                    list.get(l).val = list.get(r).val;
                    list.get(r).val = temp;
                    l++;
                    r--;
                }
            }
            // Move to next level (IMPORTANT FIX)
            level++;
        }
        return root;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

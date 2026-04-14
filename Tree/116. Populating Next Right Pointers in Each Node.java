/*********************************************** JAVA **************************************************/

// Optimal Solution - Connects each tree node to its level-order next using BFS with null separators to reset the prev pointer between levels.
/* "The null separator pattern is clean for level-order problems — it signals end-of-level without tracking counts. setting prev to the null separator would break the next level's chain by starting with prev = null correctly, 
    but the original bug was linking last node to first node of next level via prev.next = curr before resetting." */

class Solution {
    public Node connect(Node root) {
        // empty tree or leaf node — nothing to connect
        if (root == null || root.left == null) return root;
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        que.offer(null);
        Node prev = null;
        while (!que.isEmpty()) {
            Node curr = que.poll();
            if (curr == null) {
                // end of level — reset prev for next level
                prev = null;
                // add next level separator if more nodes remain
                if (!que.isEmpty())
                    que.offer(null);
            } else {
                // add children to queue for next level
                if (curr.left != null) que.offer(curr.left);
                if (curr.right != null) que.offer(curr.right);
                // link previous node to current at same level
                if (prev != null) prev.next = curr;
                prev = curr;
            }
        }
        return root;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

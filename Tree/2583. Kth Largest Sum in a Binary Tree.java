/*********************************************** JAVA **************************************************/

// Optimal Solution - Use BFS to compute level sums and a min-heap to track the kth largest sum.
/* “I compute level sums using BFS and maintain a min-heap of size k to efficiently track the kth largest value.” */

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        // Queue for level order traversal (BFS)
        Queue<TreeNode> que = new LinkedList<>();
        // Min-heap to keep track of top k largest sums
        PriorityQueue<Long> pq = new PriorityQueue<>();
        que.offer(root);
        // Perform BFS level by level
        while (!que.isEmpty()) {
            int size = que.size();  // Number of nodes at current level
            long sum = 0;           // Sum of current level
            // Process current level
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                sum += node.val;  // Add node value
                // Add children to the queue
                if (node.left != null)
                    que.offer(node.left);
                
                if (node.right != null)
                    que.offer(node.right);
            }
            // Add level sum to min-heap
            pq.offer(sum);
            // Maintain only k largest sums
            if (pq.size() > k) {
                pq.poll();  // Remove smallest
            }
        }
        // If fewer than k levels exist
        if (pq.size() < k)
            return -1;
        // Top of min-heap = kth largest sum
        return pq.peek();
    }
}

// Time Complexity :- O(n l log k). n is the number of nodes, and l is the number of levels.
// Space Complexity :- O(w + k). w is the width of the tree.

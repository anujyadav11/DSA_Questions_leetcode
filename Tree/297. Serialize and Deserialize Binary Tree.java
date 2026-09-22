/*********************************************** JAVA **************************************************/

// Optimal Solution - BFS-based serialization and deserialization of binary tree preserving null structure. Use level-order traversal and include null markers to reconstruct exact tree shape.
/* “I use level-order traversal to serialize the tree and explicitly store null children as n. This is necessary because without null markers, different tree structures could produce the same serialized representation. 
    During deserialization, I read the values from left to right and maintain a queue of parent nodes. For each parent, I assign the next two values as its left and right children, adding non-null children back to the queue. 
    Because both operations use the same BFS ordering and null representation, the original tree structure is reconstructed.” */

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (sb.length() > 0)
                sb.append(',');
            // Store null nodes explicitly
            if (node == null) {
                sb.append('n');
            } else {
                sb.append(node.val);
                // Process children in level-order
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sb.toString();
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty())
            return null;
        String[] parts = data.split(",");
        // First value is the root
        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < parts.length) {
            TreeNode parent = q.poll();
            // Create left child if it is not null
            if (i < parts.length && !parts[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(parts[i]));
                parent.left = left;
                q.offer(left);
            }
            i++;
            // Create right child if it is not null
            if (i < parts.length && !parts[i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(parts[i]));
                parent.right = right;
                q.offer(right);
            }
            i++;
        }
        return root;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

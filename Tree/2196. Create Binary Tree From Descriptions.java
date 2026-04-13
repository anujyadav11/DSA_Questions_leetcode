/*********************************************** JAVA **************************************************/

// Optimal Solution - Constructs a binary tree from parent-child descriptions using a HashMap for node reuse and a HashSet to identify the root as the only non-child node.
/* "putIfAbsent is key — it prevents overwriting existing nodes when the same value appears as both parent and child across different descriptions. 
    Root detection via child set is elegant — in any valid tree, exactly one node has no parent, so scanning parents against the child set always finds it in O(n)." */

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        // map stores all created nodes by their value
        Map<Integer, TreeNode> map = new HashMap<>();
        // tracks all child nodes — root is the only non-child
        Set<Integer> childSet = new HashSet<>();
        for (int[] des : descriptions) {
            int parent = des[0];
            int child = des[1];
            int isLeft = des[2];
            // create nodes if not already created
            map.putIfAbsent(parent, new TreeNode(parent));
            map.putIfAbsent(child, new TreeNode(child));
            // link child to parent on the correct side
            if (isLeft == 1)
                map.get(parent).left = map.get(child);
            else
                map.get(parent).right = map.get(child);
            // mark as child — root will never appear here
            childSet.add(child);
        }
        // root is the only node that never appears as a child
        for (int[] des : descriptions) {
            int parent = des[0];
            if (!childSet.contains(parent))
                return map.get(parent);
        }
        // should never reach here with valid input
        return null;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

/*********************************************** JAVA **************************************************/

// Recursive Solution - Recursively compare corresponding nodes, values, and subtree structures to determine whether two binary trees are identical.

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both nodes are null, they are identical at this position
        if (p == null && q == null) {
            return true;
        }
        // If only one node is null, the structures are different
        if (p == null || q == null) {
            return false;
        }
        // Current values must match
        // AND left subtrees must match
        // AND right subtrees must match
        return (p.val == q.val)
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(H).

//Iterative Solution - Compare two binary trees level-by-level using BFS to ensure identical structure and node values.

class Solution {
    public boolean isSameTree(TreeNode a, TreeNode b) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(a);
        q.add(b);
        while (!q.isEmpty()) {
            TreeNode first = q.poll();
            TreeNode second = q.poll();
            // If both nodes are null, they match at this position
            if (first == null && second == null)
                continue;
            // If one is null or values differ, trees are not the same
            if (first == null || second == null || first.val != second.val)
                return false;
            // Push children in the same order for both trees
            q.add(first.left);
            q.add(second.left);
            q.add(first.right);
            q.add(second.right);
        }
        return true;
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(N).

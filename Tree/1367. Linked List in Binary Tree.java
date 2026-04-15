/*********************************************** JAVA **************************************************/

// Optimal Solution - Use DFS to try matching the linked list starting from every tree node.
/* “I try each tree node as a starting point and use DFS to check if the linked list matches a downward path.” */

class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        // If tree is empty → no match
        if (root == null)
            return false;
        // If current node matches head, try to match full path
        if (head.val == root.val) {
            if (dfs(head, root))
                return true;
        }
        // Otherwise check left and right subtree
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    // DFS to match linked list path
    public boolean dfs(ListNode head, TreeNode root) {
        // If list is fully matched
        if (head == null)
            return true;
        // If tree ends before list → fail
        if (root == null)
            return false;
        // Values must match
        if (head.val != root.val)
            return false;
        // Continue matching in both directions
        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }
}

// Time Complexity :- O(n * l). n is number of nodes in tree and l length of linked list
// Space Complexity :- O(h). h is height of the binary tree.

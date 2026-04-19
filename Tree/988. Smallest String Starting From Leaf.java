/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds the lexicographically smallest root-to-leaf string using DFS with prepend-and-backtrack on a StringBuilder, comparing at each leaf node.
/* "Two Java gotchas here — never use == for String content comparison, always use .equals() or .isEmpty(). And StringBuilder.insert(0, c) builds the leaf-to-root string naturally since we prepend each ancestor,
    but it's O(n) per insert — appending then reversing at leaves is O(1) per character and more efficient for deep trees." */

class Solution {
    String smallestString = "";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return smallestString;
    }
    public void dfs(TreeNode root, StringBuilder curString) {
        if (root == null) return;
        // prepend current character to build root-to-leaf path in reverse
        curString.insert(0, (char) (root.val + 'a'));
        if (root.left == null && root.right == null) {
            if (smallestString.isEmpty() || smallestString.compareTo(curString.toString()) > 0)
                smallestString = curString.toString();
            // backtrack — remove prepended character before returning
            curString.deleteCharAt(0);
            return;
        }
        // recurse left subtree then backtrack
        if (root.left != null) {
            dfs(root.left, curString);
        }
        // recurse right subtree then backtrack
        if (root.right != null) {
            dfs(root.right, curString);
        }
        // backtrack current node's character after both children explored
        curString.deleteCharAt(0);
    }
}

// Time Complexity :- O(n * h). n = nodes of the tree, h = height of the tree.
// Space Complexity :- O(h).

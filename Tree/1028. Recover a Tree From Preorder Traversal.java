/*********************************************** JAVA **************************************************/

// Optimal Solution - Reconstructs preorder tree from dash-depth-encoded string by recursively matching dash count to depth and parsing node values with a shared index pointer.
/* "The int[] index array is the Java pass-by-reference trick for a shared mutable pointer — a single int would be copied. The key insight is peeking at dash count without consuming
    — if it doesn't match current depth, immediately return null so the parent can handle it. This avoids backtracking entirely." */

class Solution {
    private int n;
    private TreeNode solve(String traversal, int[] index, int depth) {
        // base case: reached end of string
        if (index[0] >= n) return null;
        int j = index[0];
        // count consecutive dashes from current position
        while (j < n && traversal.charAt(j) == '-')
            j++;
        int dash = j - index[0];
        // dash count must match current depth — otherwise belongs to ancestor
        if (depth != dash) return null;
        // consume dashes
        index[0] += dash;
        // parse node value (may be multi-digit)
        int value = 0;
        while (index[0] < n && Character.isDigit(traversal.charAt(index[0])))
            value = value * 10 + (traversal.charAt(index[0]++) - '0');
        TreeNode root = new TreeNode(value);
        // recursively build left then right subtree at depth+1
        root.left = solve(traversal, index, depth + 1);
        root.right = solve(traversal, index, depth + 1);
        return root;
    }
    public TreeNode recoverFromPreorder(String traversal) {
        n = traversal.length();
        // index array used as a pass-by-reference pointer
        int[] index = {0};
        return solve(traversal, index, 0);
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(h).

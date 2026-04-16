/*********************************************** JAVA **************************************************/

// Optimal Solution - Construct tree using preorder for root selection and postorder for subtree boundary detection.
/* “I use preorder to identify roots and postorder to determine subtree sizes, enabling recursive construction.” */

class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = postorder.length;
        // Store value → index in postorder for quick lookup
        for (int i = 0; i < n; i++) {
            map.put(postorder[i], i);
        }
        return recur(0, n - 1, 0, n - 1, preorder, postorder);
    }
    public TreeNode recur(int i1, int i2, int j1, int j2,
                          int[] preorder, int[] postorder) {
        // Correct base case
        if (i1 > i2 || j1 > j2)
            return null;
        // First element in preorder is root
        TreeNode root = new TreeNode(preorder[i1]);
        // If only one node
        if (i1 == i2)
            return root;
        // Next element in preorder = left subtree root
        int leftRootVal = preorder[i1 + 1];
        // Find left subtree size using postorder
        int r = map.get(leftRootVal);
        int size = r - j1 + 1;
        // Build left subtree
        root.left = recur(i1 + 1, i1 + size, j1, r, preorder, postorder);
        // Build right subtree
        root.right = recur(i1 + size + 1, i2, r + 1, j2 - 1, preorder, postorder);
        return root;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

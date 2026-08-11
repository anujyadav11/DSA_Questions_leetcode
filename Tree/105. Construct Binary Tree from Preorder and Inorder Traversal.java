/*********************************************** JAVA **************************************************/

// Optimal Solution - Reconstruct the binary tree by using preorder to identify roots and a HashMap of inorder positions to recursively split left and right subtrees.
/* “Preorder tells me the root because its first element is always the root of the current subtree. I use a HashMap to find that root’s position in inorder in O(1). 
    Everything before that position belongs to the left subtree, and everything after it belongs to the right subtree. 
    I recursively construct both subtrees while calculating the corresponding preorder index.” */

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Store each value's index in inorder.
        // This allows us to find the root position in O(1).
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return splitTree(preorder,inOrderMap,0,0,inorder.length - 1);
    }
    public TreeNode splitTree(int[] preOrder,Map<Integer, Integer> inOrderMap,int rootIdx,int left,int right) {
        // Create the current root.
        // In preorder, the first element of a subtree is its root.
        TreeNode root = new TreeNode(preOrder[rootIdx]);
        // Find the root's position in inorder.
        int mid = inOrderMap.get(preOrder[rootIdx]);
        // Everything before mid belongs to the left subtree.
        if (mid > left) {
            root.left = splitTree(
                preOrder,
                inOrderMap,
                // The next element in preorder is the root
                // of the left subtree.
                rootIdx + 1,
                // Left subtree starts at the current left boundary.
                left,
                // Left subtree ends just before the root.
                mid - 1);
        }
        // Everything after mid belongs to the right subtree.
        if (mid < right) {
            root.right = splitTree(
                preOrder,
                inOrderMap,
                // Skip all nodes belonging to the left subtree.
                // Number of nodes in left subtree = mid - left.
                // +1 skips the root itself.
                rootIdx + (mid - left) + 1,
                // Right subtree starts immediately after mid.
                mid + 1,
                // Right subtree ends at the current right boundary.
                right
            );
        }
        return root;
    }
}
// Time Complexity :- O(n).
// Space Complexity :- O(n).

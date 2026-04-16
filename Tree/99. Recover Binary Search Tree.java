/*********************************************** JAVA **************************************************/

// Optimal Solution - Recovers a BST with two swapped nodes by detecting inorder violations and swapping either adjacent (first-middle) or non-adjacent (first-last) node pairs.
/* "The key insight is that swapping two BST nodes creates exactly one or two inorder violations. One violation means adjacent swap — fix with first and middle. 
    Two violations mean non-adjacent swap — fix with first and last. Morris traversal can reduce space to O(1) if the interviewer asks for optimization." */

class Solution {
    // first and last track the two swapped nodes when they are far apart
    private TreeNode first;
    private TreeNode prev;
    // middle tracks second swapped node when they are adjacent
    private TreeNode middle;
    private TreeNode last;
    public void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        // violation found: current value is less than previous in inorder
        if (prev != null && root.val < prev.val) {
            if (first == null) {
                // first violation — prev is the first swapped node
                first = prev;
                // tentatively mark current as second swapped node
                middle = root;
            } else {
                // second violation — current is the actual second swapped node
                last = root;
            }
        }
        prev = root;
        inOrder(root.right);
    }
    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        // initialize prev to MIN_VALUE so first node never triggers violation
        prev = new TreeNode(Integer.MIN_VALUE);
        inOrder(root);
        if (first != null && last != null) {
            // non-adjacent swap — exchange first and last
            int t = first.val;
            first.val = last.val;
            last.val = t;
        } else if (first != null && middle != null) {
            // adjacent swap — exchange first and middle
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(h).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Validates even-odd tree property level by level using BFS, checking odd/even value parity and strict monotonicity direction per level.
/*  "The two conditions per level — value parity and strict ordering — can be checked together in one pass using prev as a running comparator. 
    Separating the even/odd level logic into two clear if blocks is cleaner than one compound boolean — easier to debug and explain in interviews. 
    Sentinel values MIN_VALUE and MAX_VALUE handle the first element of each level without special casing." */

class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        // start at level 0 which is even-indexed
        boolean isEven = true;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            // even levels need strictly increasing odd values — start prev at MIN
            // odd levels need strictly decreasing even values — start prev at MAX
            int prev = isEven ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                int cur = node.val;
                if (isEven) {
                    // even level: must be an odd value and strictly increasing
                    if (cur % 2 == 0 || cur <= prev)
                        return false;
                } else {
                    // odd level: must be an even value and strictly decreasing
                    if (cur % 2 != 0 || cur >= prev)
                        return false;
                }
                prev = cur;
                // enqueue children for next level
                if (node.left != null)
                    que.offer(node.left);
                if (node.right != null)
                    que.offer(node.right);
            }
            // flip level parity after processing each level
            isEven = !isEven;
        }
        return true;
    }
}

// Time Complexity :- O(n). n is the size of the nodes in the tree.
// Space Complexity :- O(w). and w is the width of the tree.

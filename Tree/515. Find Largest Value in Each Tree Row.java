/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds the largest value per tree level using DFS with depth tracking, initializing each level on first visit and updating the maximum on subsequent visits.
/* "DFS and BFS both work here — BFS is more intuitive for level-order problems but DFS is elegant with depth indexing. The depth == res.size() condition is a clean way to detect the first visit to a new level without a separate data structure. 
    BFS uses O(w) queue space where w is max width — DFS uses O(h) stack space — for wide shallow trees DFS wins on space." */

class Solution {
    List<Integer> res = new ArrayList<>();
    public void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (depth == res.size())
            // first node at this depth — initialize level maximum
            res.add(root.val);
        else
            // update maximum for this depth level
            res.set(depth, Math.max(res.get(depth), root.val));
        // recurse on both subtrees with incremented depth
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 0);
        return res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(h).

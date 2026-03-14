/*********************************************** JAVA **************************************************/

// Optimal Solution - Perform postorder traversal of an N-ary tree using DFS recursion.
/* "Postorder means we process children before the node. So I perform DFS and recursively visit all children first, then add the node value to the result." */

class Solution {
    public List<Integer> postorder(Node root) {
        // List to store the postorder traversal result
        List<Integer> result = new ArrayList<>();
        // Start DFS traversal
        dfs(root, result);
        // Return the traversal result
        return result;
    }
    public void dfs(Node root, List<Integer> result){
        // Base case: if node is null, return
        if(root == null) return;
        // Traverse all children first
        for(Node child : root.children){
            dfs(child, result);
        }
        // After visiting children, add the current node value
        result.add(root.val);
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(h).

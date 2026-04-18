/*********************************************** JAVA **************************************************/

// Optimal Solution - Validates binary tree structure using in-degree checks for single parentage, unique root detection, and DFS cycle/connectivity verification.
/*  "This version is cleaner than the previous — handling -1 inside DFS removes noise from the caller. The four validation pillars are: no multi-parent (indegree), 
    unique root (indegree=0), no cycles (visited check in DFS), full connectivity (post-DFS visited scan). Miss any one and the tree is invalid." */

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] indegree = new int[n];
        // step 1: compute indegree — each child increments its parent count
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                // node already has a parent — invalid
                if (++indegree[leftChild[i]] > 1) return false;
            }
            if (rightChild[i] != -1) {
                // node already has a parent — invalid
                if (++indegree[rightChild[i]] > 1) return false;
            }
        }
        // step 2: find root — exactly one node with indegree 0
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                // multiple roots — invalid
                if (root != -1) return false;
                root = i;
            }
        }
        // no root found — all nodes in a cycle
        if (root == -1) return false;
        // step 3: DFS from root — detect cycles and validate structure
        boolean[] visited = new boolean[n];
        if (!dfs(root, leftChild, rightChild, visited)) return false;
        // step 4: all nodes must be reachable from root
        for (boolean v : visited)
            if (!v) return false;
        return true;
    }
    private boolean dfs(int node, int[] leftChild, int[] rightChild, boolean[] visited) {
        // base case: null child — valid leaf boundary
        if (node == -1) return true;
        // already visited — cycle detected
        if (visited[node]) return false;
        visited[node] = true;
        // recursively validate both subtrees
        return dfs(leftChild[node], leftChild, rightChild, visited) &&
               dfs(rightChild[node], leftChild, rightChild, visited);
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Maximizes k-divisible tree components using post-order DFS that cuts subtrees when their sum is divisible by k, returning 0 upward to prevent double-counting.
/* "The greedy cut is the key — when a subtree sums to a multiple of k, cutting it is always optimal. Returning 0 to the parent is the cut mechanism — 
    it prevents the valid component's sum from contributing to the parent's total. Post-order ensures all children are resolved before checking the current node's subtree sum." */

class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        // build undirected adjacency list
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        // comp[0] tracks number of valid components found
        int[] comp = new int[1];
        dfs(0, -1, adj, values, k, comp);
        return comp[0];
    }

    public long dfs(int curNode, int parentNode, List<Integer>[] adj, int[] values, int k, int[] comp) {
        // accumulate subtree sum
        long sum = values[curNode];
        for (int ngr : adj[curNode]) {
            if (ngr != parentNode)
                sum += dfs(ngr, curNode, adj, values, k, comp);
        }
        // if subtree sum divisible by k — cut this component
        if (sum % k == 0) {
            comp[0]++;
            // return 0 so parent doesn't include this component's sum
            return 0;
        }
        return sum;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

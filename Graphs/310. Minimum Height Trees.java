/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds minimum height tree roots by iteratively trimming leaf nodes inward until 1 or 2 center nodes remain using BFS topological peeling.
/* "MHT roots are always the tree's center — at most 2 exist in any tree. Leaf trimming converges to the center because leaves are always farthest from the center. 
    The n > 2 stopping condition is key — any tree has at most 2 centroid nodes, so we stop when only they remain." */

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // handle single node edge case — it is its own root
        if (n == 1) return Collections.singletonList(0);
        // build adjacency list and degree count
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            indegree[u]++;
            indegree[v]++;
            // computeIfAbsent instead of put().add()
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        Queue<Integer> que = new LinkedList<>();
        // start with all leaf nodes (degree 1)
        for (int i = 0; i < n; i++)
            if (indegree[i] == 1) que.offer(i);
        // trim leaves layer by layer until 1 or 2 nodes remain
        while (n > 2) {
            int size = que.size();
            n -= size;
            while (size-- > 0) {
                int u = que.poll();
                // adj.get(u) instead of adj[u]
                for (int v : adj.get(u)) {
                    indegree[v]--;
                    // indegree typo corrected
                    if (indegree[v] == 1)
                        que.offer(v);
                }
            }
        }
        // remaining nodes in queue are MHT roots
        List<Integer> res = new ArrayList<>();
        while (!que.isEmpty())
            res.add(que.poll());
        return res;
    }
}

// Time Complexity :- O(v + e).
// Space Complexity :- O(v + e).

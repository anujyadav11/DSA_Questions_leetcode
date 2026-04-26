/*********************************************** JAVA **************************************************/

// Optimal Solution - Tracks shortest path after each road addition by running BFS from source to destination on an incrementally updated adjacency map.
/* "BFS after each query is O(k×n) — acceptable for small constraints. For larger inputs, mention bidirectional BFS or incremental shortest path algorithms like D-SLF. 
    The adj.clear() at the start is important if the solution object is reused — always reset shared state before building the graph." */

class Solution {
    public Map<Integer, List<Integer>> adj = new HashMap<>();
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        adj.clear();
        // build initial linear chain 0 -> 1 -> 2 -> ... -> n-1
        for (int i = 0; i < n - 1; i++)
            adj.computeIfAbsent(i, k -> new ArrayList<>()).add(i + 1);
        int k = queries.length;
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            // add new edge from query
            adj.computeIfAbsent(queries[i][0], k1 -> new ArrayList<>()).add(queries[i][1]);
            // BFS from 0 to n-1 after each query
            res[i] = bfs(n);
        }
        return res;
    }
    public int bfs(int n) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] vis = new boolean[n];
        que.offer(0);
        vis[0] = true;
        int level = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                int node = que.poll();
                // reached destination — return current level as shortest distance
                if (node == n - 1) return level;
                for (int nbr : adj.getOrDefault(node, new ArrayList<>())) {
                    if (!vis[nbr]) {
                        que.offer(nbr);
                        vis[nbr] = true;
                    }
                }
            }
            level++;
        }
        // destination unreachable — should not happen with valid input
        return -1;
    }
}

// Time Complexity :- O(k * (n + e). - k queries each triggering BFS over n nodes and e edges
// Space Complexity :- O(n + e).

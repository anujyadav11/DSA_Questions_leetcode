/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds minimum course completion time using topological BFS, propagating maximum cumulative time through dependency edges.
/* "Two indexing bugs in one — 1-indexed nodes with 0-indexed arrays causes wrong indegree checks and off-by-one time lookups. Always align array sizes and loop bounds to the node numbering scheme. 
    getOrDefault prevents NullPointerException for leaf nodes with no outgoing edges — a common oversight when adjacency lists are built only for nodes with edges." */

class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        // build adjacency list — nodes are 1-indexed
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[n + 1];
        for (int[] edge : relations) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            indegree[edge[1]]++;
        }
        Queue<Integer> que = new LinkedList<>();
        // maxTime[i] = minimum time to complete course i (1-indexed)
        int[] maxTime = new int[n + 1];
        // loop from 1 to n for 1-indexed nodes
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                que.add(i);
                maxTime[i] = time[i - 1];
            }
        }
        while (!que.isEmpty()) {
            int u = que.poll();
            //  use getOrDefault to handle nodes with no outgoing edges
            for (int v : adj.getOrDefault(u, new ArrayList<>())) {
                maxTime[v] = Math.max(maxTime[v], maxTime[u] + time[v - 1]);
                if (--indegree[v] == 0)
                    que.add(v);
            }
        }
        // return max completion time across all courses
        int res = 0;
        for (int i = 1; i <= n; i++)
            res = Math.max(res, maxTime[i]);
        return res;
    }
}

// Time Complexity :- O(n + e).— BFS visits all nodes and edges once
// Space Complexity :- O(n + e).— adjacency map, indegree array, maxTime array

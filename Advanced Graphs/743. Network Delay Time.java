/*********************************************** JAVA **************************************************/

// Optimal Solution - Dijkstra-based solution using a min-heap to compute network delay time from a single source. Use Dijkstra to find the shortest time from the source to all nodes, then take the maximum distance—if any node is unreachable, return -1.
/* “I model the directed weighted graph using an adjacency list and run Dijkstra from the source node k. The shortest distance to each node represents the time required for the signal to reach it. 
    Since the signal must reach every node, the network delay is the maximum of these shortest distances. If any node remains unreachable, I return -1.” */

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // Convert nodes from 1-based to 0-based
        for (int[] time : times) {
            int u = time[0] - 1;
            int v = time[1] - 1;
            int w = time[2];
            adj.get(u).add(new int[] { v, w });
        }
        // Find shortest time from source k
        int minTime[] = dijkstra(k - 1, n, adj);
        // The answer is the maximum shortest distance
        int res = Integer.MIN_VALUE;
        for (int time : minTime) {
            res = Math.max(res, time);
        }
        // If some node is unreachable
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
    public int[] dijkstra(int src, int n, List<List<int[]>> adj) {
        // {node, distance}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            new Comparator<int[]>() {
                public int compare(int[] p1, int[] p2) {
                    return p1[1] - p2[1];
                }
            }
        );
        // Shortest known distance to every node
        int time[] = new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[src] = 0;
        pq.offer(new int[] { src, 0 });
        while (!pq.isEmpty()) {
            int pair[] = pq.poll();
            int u = pair[0];
            int d = pair[1];
            // Ignore stale priority queue entry
            if (d > time[u])continue;
            // Relax all neighbors
            for (int neigh[] : adj.get(u)) {
                int v = neigh[0];
                int w = neigh[1];
                if (time[u] + w < time[v]) {
                    time[v] = time[u] + w;
                    pq.offer(new int[] { v, time[v] });
                }
            }
        }
        return time;
    }
}

// Time Complexity :- O(E log V).
// Space Complexity :- O(E + V).

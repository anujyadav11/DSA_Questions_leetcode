/*********************************************** JAVA **************************************************/

// Optimal Solution - Prim’s algorithm using a min-heap to compute the minimum cost to connect all points via Manhattan distance. Model points as a complete graph with Manhattan distances and apply Prim’s MST algorithm to greedily connect the closest unvisited point each time.
/* “This is a Minimum Spanning Tree problem because we need to connect all points with minimum total cost. I construct a complete undirected graph where each point is a vertex and the edge weight is the Manhattan distance between two points. 
    I then use Prim’s algorithm with a min-heap. Starting from vertex 0, I repeatedly select the minimum-weight edge that connects a new vertex to the current MST. 
    The sum of those selected edge weights is the minimum cost to connect all points.” */

class Solution {
    // Prim's Algorithm to find the minimum cost MST
    public int minMST(List<List<int[]>> adj, int V) {
        // Min-heap storing {weight, vertex}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );
        // Start from vertex 0 with cost 0
        pq.offer(new int[] { 0, 0 });
        // Tracks whether a vertex is already included in MST
        boolean[] inMST = new boolean[V];
        int sum = 0;
        while (!pq.isEmpty()) {
            // Get the edge with minimum weight
            int[] pair = pq.poll();
            int wt = pair[0];
            int node = pair[1];
            // If this vertex is already part of MST,
            // ignore this entry
            if (inMST[node])
                continue;
            // Add vertex to MST
            inMST[node] = true;
            // Add the edge weight to MST cost
            sum += wt;
            // Explore all neighbors of this vertex
            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0];
                int nextWeight = neighbor[1];
                // If neighbor is not already in MST,
                // add it as a candidate edge
                if (!inMST[nextNode]) {
                    pq.offer(new int[] { nextWeight, nextNode });
                }
            }
        }
        return sum;
    }
    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        // Adjacency list
        // adj[i] contains {neighbor, distance}
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // Build a complete graph.
        // Every point can connect to every other point.
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                // Manhattan distance
                int distance = Math.abs(x1 - x2)
                             + Math.abs(y1 - y2);
                // Undirected graph
                adj.get(i).add(new int[] { j, distance });
                adj.get(j).add(new int[] { i, distance });
            }
        }
        // Find minimum cost to connect all points
        return minMST(adj, V);
    }
}

// Time Complexity :- O(N² log N).
// Space Complexity :- O(N²).

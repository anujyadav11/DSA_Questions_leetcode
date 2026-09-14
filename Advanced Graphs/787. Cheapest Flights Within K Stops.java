/*********************************************** JAVA **************************************************/

//Optimal Solution - BFS-based solution with cost relaxation to find the cheapest flight within at most k stops. Use BFS up to k levels and relax edges like Bellman-Ford, ensuring we only consider paths with valid stop counts.

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // distance[i] = minimum cost to reach city i within allowed stops so far
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        // Adjacency list: u -> list of {v, cost}
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];
            adj.computeIfAbsent(u, key -> new ArrayList<>())
               .add(new int[]{v, cost});
        }
        // Queue stores {currentCity, totalCostSoFar}
        Queue<int[]> queue = new LinkedList<>();
        // Start BFS from source with cost 0
        queue.offer(new int[]{src, 0});
        distance[src] = 0;
        // Level represents number of edges (stops) used
        int level = 0;
        // BFS level-by-level up to k stops
        while (!queue.isEmpty() && level <= k) {
            int size = queue.size();
            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int u = current[0];
                int d = current[1];
                // Traverse all outgoing flights
                List<int[]> neighbors = adj.getOrDefault(u, Collections.emptyList());
                for (int[] neighbor : neighbors) {
                    int v = neighbor[0];
                    int cost = neighbor[1];
                    // Relax edge if a cheaper cost is found
                    if (distance[v] > d + cost) {
                        distance[v] = d + cost;
                        queue.offer(new int[]{v, d + cost});
                    }
                }
            }
            // Move to next stop level
            level++;
        }
        // If destination unreachable within k stops, return -1
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}
// Time Complexity :- O(K * E).
// Space Complexity :- O(V + E).

//Optimal Solution - Uses Bellman-Ford-style DP to find the cheapest route within at most K + 1 flights in O(K·E) time and O(V) space.

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // price[i] = minimum cost to reach node i
        // using flights from previous iterations
        int price[] = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);
        // Cost to reach source is 0
        price[src] = 0;
        // We can take at most k + 1 flights
        // because k stops means k + 1 edges/flights.
        for (int i = 0; i < k + 1; i++) {
            // Copy previous state.
            // This prevents using more than one new flight
            // during the current iteration.
            int[] temp = Arrays.copyOf(price, n);
            // Try relaxing every flight
            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int w = flight[2];
                // If u is reachable and going through this flight
                // gives a cheaper price for v, update it.
                if (price[u] != Integer.MAX_VALUE &&
                    price[u] + w < temp[v]) {
                    temp[v] = price[u] + w;
                }
            }
            // Move to the next iteration
            price = temp;
        }
        // Destination unreachable
        return (price[dst] == Integer.MAX_VALUE)
                ? -1
                : price[dst];
    }
}

// Time Complexity :- O(K * E).
// Space Complexity :- O(V).

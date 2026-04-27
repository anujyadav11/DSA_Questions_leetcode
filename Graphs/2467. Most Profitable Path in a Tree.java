/*********************************************** JAVA **************************************************/

// Optimal Solution - Maximizes Alice's path income by first mapping Bob's timed path to node 0, then DFS exploring all Alice's leaf paths with arrival-time-based collection rules.
/* "Two-phase DFS is key — Bob's path is deterministic (only one path in a tree) so find it first with timestamps. Alice then explores all leaf paths using Bob's timestamps to determine collection amount at each node. 
    The backtracking in Bob's DFS correctly removes nodes not on his actual path to node 0." */

class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    // bobMap stores the time Bob reaches each node on his path to node 0
    Map<Integer, Integer> bobMap = new HashMap<>();
    int aliceIncome;
    boolean DFSBob(int curr, int t, boolean[] visited) {
        visited[curr] = true; 
        // record time Bob arrives at this node
        bobMap.put(curr, t);
        // reached node 0 — path found
        if (curr == 0) return true;
        for (int nbr : adj.getOrDefault(curr, new ArrayList<>())) {
            if (!visited[nbr]) {
                if (DFSBob(nbr, t + 1, visited))
                    return true;
            }
        }
        // this node not on Bob's path — remove it
        bobMap.remove(curr);
        return false;
    }
    void DFSAlice(int curr, int t, int income, boolean[] visited, int[] amount) {
        visited[curr] = true;
        if (!bobMap.containsKey(curr) || t < bobMap.get(curr))
            // Alice arrives before Bob — collect full amount
            income += amount[curr];
        else if (t == bobMap.get(curr))
            // Alice and Bob arrive simultaneously — split amount
            income += amount[curr] / 2;
        // Bob arrives first — Alice collects nothing from this node
        // leaf node check: only one neighbor and not root
        if (adj.getOrDefault(curr, new ArrayList<>()).size() == 1 && curr != 0)
            aliceIncome = Math.max(aliceIncome, income);
        for (int nbr : adj.getOrDefault(curr, new ArrayList<>())) {
            if (!visited[nbr])
                DFSAlice(nbr, t + 1, income, visited, amount);
        }
    }
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        aliceIncome = Integer.MIN_VALUE;
        // build undirected adjacency list
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        // find Bob's path and record arrival times
        boolean[] visited = new boolean[n];
        DFSBob(bob, 0, visited);
        // find Alice's best income path from root
        Arrays.fill(visited, false);
        DFSAlice(0, 0, 0, visited, amount);
        return aliceIncome;
    }
}

// Time Complexity :- O(n).— each node visited once per DFS; two passes total
// Space Complexity :- O(n). — adjacency map, bobMap, visited array all scale with n

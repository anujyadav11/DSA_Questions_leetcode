/*********************************************** JAVA **************************************************/

//Optimal Solution - Hierholzer’s algorithm to find lexicographically smallest Eulerian path in directed graph. This is an Eulerian path problem — use post-order DFS and reverse the result to reconstruct itinerary.
/* “This is an Eulerian path problem because every ticket must be used exactly once. I build a directed adjacency list and sort each destination list in reverse lexicographical order so that I can remove the smallest destination from the end in O(1). 
    I then use Hierholzer’s algorithm: DFS consumes all outgoing edges first and adds the airport to the result only after all its edges are used. Because the result is constructed in reverse order, I reverse it at the end.” */

class Solution {
    // Adjacency list:
    // Source airport -> list of destination airports
    Map<String, List<String>> graph;
    // Stores the itinerary in reverse order during DFS
    List<String> res;
    public List<String> findItinerary(List<List<String>> tickets) {
        res = new ArrayList<>();
        graph = new HashMap<>();
        // Build the directed graph
        for (List<String> ticket : tickets) {
            // Add destination to the source airport's list
            graph.computeIfAbsent(
                ticket.get(0),
                k -> new ArrayList<>()
            ).add(ticket.get(1));
        }
        // Sort destinations in reverse lexicographical order.
        // This allows us to remove the smallest destination
        // efficiently from the end of the list.
        for (List<String> to : graph.values()) {
            to.sort(Collections.reverseOrder());
        }
        // Start the Eulerian path from JFK
        dfs("JFK");
        // DFS adds airports after consuming all outgoing edges,
        // so the result is built in reverse order.
        Collections.reverse(res);
        return res;
    }
    public void dfs(String from) {
        List<String> to = graph.get(from);
        // Continue while there are unused tickets
        // leaving the current airport.
        while (to != null && !to.isEmpty()) {
            // Since destinations are reverse sorted,
            // the smallest destination is at the end.
            // remove(last) is O(1) for ArrayList.
            String nextTo = to.remove(to.size() - 1);
            // Continue traversing using this ticket.
            dfs(nextTo);
        }
        // Add the airport only after all outgoing tickets
        // have been consumed.
        res.add(from);
    }
}

// Time Complexity :- O(E log E).
// Space Complexity :- O(V + E).

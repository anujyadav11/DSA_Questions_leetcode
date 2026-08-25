/*********************************************** JAVA **************************************************/

// Optimal Solution - Clone an undirected graph using DFS and a hashmap to avoid re-cloning nodes. use DFS with a hashmap to ensure each node is cloned once and shared neighbors are handled correctly.
/* “I use a HashMap to maintain a mapping between each original node and its clone. I first clone the starting node and store it in the map. During DFS, if a neighbor hasn’t been cloned, I create its clone, store it, connect it, and recursively process it. 
    If the neighbor has already been cloned, I simply reuse the existing clone. This prevents infinite recursion in cyclic graphs and preserves the original graph structure.” */

class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        // Empty graph
        if (node == null) {
            return null;
        }
        // Create clone of the starting node
        Node clone_node = new Node(node.val);
        map.put(node, clone_node);
        // Clone the rest of the graph
        dfs(node, clone_node, map);
        return clone_node;
    }
    public void dfs(Node node, Node clone_node, Map<Node, Node> map) {
        // Visit every neighbor
        for (Node n : node.neighbors) {
            // Clone neighbor if not visited yet
            if (!map.containsKey(n)) {
                Node clone = new Node(n.val);
                map.put(n, clone);
                // Connect cloned nodes
                clone_node.neighbors.add(clone);
                // Recursively clone neighbors
                dfs(n, clone, map);
            } else {
                // Neighbor already cloned, reuse it
                clone_node.neighbors.add(map.get(n));
            }
        }
    }
}

// Time Complexity :- O(V + E). v = number of vertex and e = number of edges
// Space Complexity :- O(V). space we used in map

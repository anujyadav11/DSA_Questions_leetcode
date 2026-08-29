/*********************************************** JAVA **************************************************/

// Optimal Solution - Use Union-Find with path compression to detect the redundant edge that forms a cycle. If two nodes already belong to the same set, adding that edge forms a cycle, making it redundant.
/* “I use Disjoint Set Union to maintain connected components. Initially every node belongs to its own component. For each edge, I find the roots of its two endpoints. If the roots are different, I merge the components using union by size. 
    If the roots are already equal, the two nodes are already connected, so adding this edge creates a cycle, making it the redundant connection.” */

class Solution {
    int totalNodes;
    public int[] findRedundantConnection(int[][] edges) {
        // Number of nodes = number of edges for this problem
        totalNodes = edges.length;
        int[] res = new int[2];
        // Initialize DSU with all nodes
        DisjointSet dsu = new DisjointSet(totalNodes);
        for (int[] edge : edges) {
            // Convert 1-based node values to 0-based indices
            // If union fails, both nodes are already connected,
            // so this edge creates a cycle.
            if (!dsu.unionBySize(edge[0] - 1, edge[1] - 1)) {
                res = edge;
            }
        }
        return res;
    }
}
class DisjointSet {
    int parent[];
    int size[];
    DisjointSet(int nodes) {
        // Initially every node is its own parent
        this.parent = new int[nodes];
        this.size = new int[nodes];

        for (int i = 0; i < nodes; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int findRootParent(int node) {
        // Node is the root of its component
        if (node == parent[node]) {
            return node;
        }
        // Path compression
        parent[node] = findRootParent(parent[node]);
        return parent[node];
    }
    public boolean unionBySize(int node1, int node2) {
        // Find the roots of both nodes
        int rootParent1 = findRootParent(node1);
        int rootParent2 = findRootParent(node2);
        // Same root means adding this edge creates a cycle
        if (rootParent1 == rootParent2) {
            return false;
        }
        // Attach smaller component under larger component
        if (size[rootParent1] < size[rootParent2]) {
            parent[rootParent1] = rootParent2;
            size[rootParent2] += size[rootParent1];
        } else {
            parent[rootParent2] = rootParent1;
            size[rootParent1] += size[rootParent2];
        }
        return true;
    }
}

// Time Complexity :- O(E).
// Space Complexity :- O(V).

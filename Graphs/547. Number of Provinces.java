/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts provinces (connected components) in a city network using DFS on an adjacency matrix, incrementing count for each unvisited starting node.
/* "This is a classic connected components problem on an adjacency matrix. Each outer loop iteration that finds an unvisited node represents a new province — DFS marks all reachable cities. 
    Union-Find is an elegant alternative with O(n²α(n)) time and O(n) space — mention it as a follow-up to show breadth." */

class Solution {
    int n;
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                // new unvisited node — new province found
                count++;
                dfs(isConnected, i, vis);
            }
        }
        return count;
    }
    public void dfs(int[][] isConnected, int u, boolean[] vis) {
        // mark current city as visited
        vis[u] = true;
        for (int v = 0; v < n; v++) {
            // visit all directly connected unvisited cities
            if (!vis[v] && isConnected[u][v] == 1)
                dfs(isConnected, v, vis);
        }
    }
}

// Time Complexity :- O(n^2).
// Space Complexity :- O(n).

// BFS solution 
class Solution {
    int n;

    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                bfs(isConnected, i, vis);
                count++;
            }
        }
        return count;
    }
    public void bfs(int[][] nums, int i, boolean[] vis) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(i);
        vis[i] = true;
        while (!que.isEmpty()) {
            int u = que.poll();
            for (int v = 0; v < n; v++) {
                if (!vis[v] && nums[u][v] == 1) {
                    vis[v] = true;
                    que.offer(v);
                }
            }
        }
    }
}
// Time Complexity :- O(n^2).
// Space Complexity :- O(n).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Run DFS from Pacific and Atlantic borders to find cells that can flow to both oceans. Instead of flowing water from each cell, I reverse the process and flow inward from both oceans.
/* “Instead of starting from every cell, I reverse the water flow and start DFS from the ocean boundaries. From an ocean, I can move to a neighboring cell only if its height is greater than or equal to the current cell. 
    I maintain separate visited matrices for the Pacific and Atlantic oceans. Any cell visited by both DFS traversals can flow to both oceans.” */


class Solution {
    int[][] dirs = {
            { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }
    };
    public void dfs(int[][] heights, int i, int j,
            int prevVal, boolean[][] vis) {
        // Stop if out of bounds
        if (i < 0 || j < 0 ||
                i >= heights.length || j >= heights[0].length) {
            return;
        }
        // Water cannot flow from lower height to higher height
        // Also skip already visited cells
        if (heights[i][j] < prevVal || vis[i][j]) {
            return;
        }
        // Mark cell reachable from this ocean
        vis[i][j] = true;
        // Explore all four directions
        for (int[] dir : dirs) {
            int newi = i + dir[0];
            int newj = j + dir[1];
            dfs(heights, newi, newj, heights[i][j], vis);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        // Cells reachable from Pacific and Atlantic respectively
        boolean[][] pacificValue = new boolean[m][n];
        boolean[][] atlanticValue = new boolean[m][n];
        // Start DFS from top and bottom borders
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, Integer.MIN_VALUE, pacificValue);
            dfs(heights, m - 1, j, Integer.MIN_VALUE, atlanticValue);
        }
        // Start DFS from left and right borders
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pacificValue);
            dfs(heights, i, n - 1, Integer.MIN_VALUE, atlanticValue);
        }
        // A cell can reach both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificValue[i][j] && atlanticValue[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
}

// Time Complexity :- O(R x C).
// Space Complexity :- O(R x C).

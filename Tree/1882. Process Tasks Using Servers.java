/*********************************************** JAVA **************************************************/

// Optimal Solution - 

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        // Priority Queue for free servers sorted by weight, index, and server number
        PriorityQueue<int[]> freeServer = new PriorityQueue<>((a, b) -> (a[0] != b[0]) ? (a[0] - b[0]) : (a[1] - b[1]));
        // Priority Queue for servers in use sorted by completion time, weight, and index
        PriorityQueue<int[]> useServer = new PriorityQueue<>((a, b) -> (a[2] != b[2]) ? (a[2] - b[2]) : ((a[0] != b[0]) ? (a[0] - b[0]) : (a[1] - b[1])));
        for (int i = 0; i < n; i++) {
            freeServer.add(new int[]{servers[i], i, 0});
        }
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int t = tasks[i];
            // Move completed servers from useServer to freeServer
            while (!useServer.isEmpty() && useServer.peek()[2] <= i) {
                freeServer.add(useServer.poll());
            }
            if (freeServer.isEmpty()) {
                // No free servers, get the earliest completed server from useServer
                int[] cur = useServer.poll();
                res[i] = cur[1];
                cur[2] += t;
                useServer.add(cur);
            } else {
                // Use a free server
                int[] cur = freeServer.poll();
                res[i] = cur[1];
                cur[2] = i + t; // Update completion time
                useServer.add(cur);
            }
        }
        return res;
    }
}


// Time Complexity :- O().
// Space Complexity :- O().

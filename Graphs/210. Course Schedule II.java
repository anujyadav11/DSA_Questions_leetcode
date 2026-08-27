/*********************************************** JAVA **************************************************/

// Optimal Solution - Use topological sorting (Kahn’s algorithm) to return a valid course order or detect cycles. This is the same cycle-detection logic as canFinish, but instead of counting nodes, I record the topological order.
/* “I model the prerequisite relationships as a directed graph and calculate the in-degree of every course. Courses with zero prerequisites are added to a queue. I repeatedly process them, add them to the result, 
    and decrease the in-degree of their dependent courses. When a dependent course reaches zero in-degree, I add it to the queue. If I process all courses, the ordering is valid; otherwise, a cycle exists and I return an empty array.” */

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // graph[a] = courses that depend on course a
        List<List<Integer>> graph = new ArrayList<>();
        // Number of prerequisites for each course
        int[] inDegree = new int[numCourses];
        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // Build graph: prerequisite -> course
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }
        // Start with courses having no prerequisites
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                que.offer(i);
            }
        }
        // Store the topological ordering
        int[] order = new int[numCourses];
        int index = 0;
        // Process courses using BFS
        while (!que.isEmpty()) {
            int cur = que.poll();
            // Add course to the valid ordering
            order[index++] = cur;
            // Remove current course as a prerequisite
            for (int next : graph.get(cur)) {
                inDegree[next]--;
                // All prerequisites are now completed
                if (inDegree[next] == 0) {
                    que.offer(next);
                }
            }
        }
        // Not all courses processed means a cycle exists
        if (index != numCourses) {
            return new int[0];
        }
        return order;
    }
}

// Time Complexity :- O(V + E).
// Space Complexity :- O(V + E).

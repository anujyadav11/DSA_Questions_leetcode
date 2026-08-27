/*********************************************** JAVA **************************************************/

// Optimal Solution - Determine if all courses can be completed using topological sorting and indegree tracking. If there’s a cycle in the prerequisite graph, Kahn’s algorithm won’t process all courses.
/* “I model courses as a directed graph where an edge from A to B means A must be completed before B. I calculate the in-degree of every course and initially add all courses with zero prerequisites to a queue. 
    Using Kahn’s algorithm, I process these courses and reduce the in-degree of their dependent courses. If all courses are processed, there is no cycle and we can finish all courses. Otherwise, a cycle exists.” */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // graph[a] = courses that depend on course a
        List<List<Integer>> graph = new ArrayList<>();
        // Number of prerequisites for each course
        int[] inDegree = new int[numCourses];
        //Initialise adjacency list
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // Build graph and calculate in-degrees
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }
        Queue<Integer> que = new LinkedList<>();
        // Courses with no prerequisites can be taken first
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                que.offer(i);
            }
        }
        int count = 0;
        // Process courses using topological BFS
        while (!que.isEmpty()) {
            int curr = que.poll();
            count++;
            // Remove current course as a prerequisite
            for (int next : graph.get(curr)) {
                inDegree[next]--;
                // All prerequisites completed
                if (inDegree[next] == 0) {
                    que.offer(next);
                }
            }
        }
        // If every course was processed, there is no cycle
        return count == numCourses;
    }
}

// Time Complexity :- O(V + E).
// Space Complexity :- O(V + E).

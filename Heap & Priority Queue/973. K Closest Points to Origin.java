/*********************************************** JAVA **************************************************/

// Optimal Solution - Use a max-heap of size k to keep the k closest points to the origin based on squared Euclidean distance.

/* “I maintain a max-heap containing the k closest points seen so far. The heap’s largest distance is at the top. For every point, 
    I insert it and, if the heap size exceeds k, remove the farthest point. At the end, the heap contains exactly the k closest points.” */

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-heap keeps the farthest point among the k closest
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Long.compare(distance(b), distance(a))
        );
        for (int[] point : points) {
            // Add current point
            maxHeap.offer(point);
            // Keep only k closest points
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        // Extract the k closest points
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }
    // Use long to avoid integer overflow
    private long distance(int[] point) {
        long x = point[0];
        long y = point[1];
        return x * x + y * y;
    }
}

// Time Complexity :- O(n log k).
// Space Complexity :- O(k).

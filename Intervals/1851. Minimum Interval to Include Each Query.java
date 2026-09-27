/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds the minimum interval covering each query using a sorted sweep line and min heap in O((N + Q) log(N + Q)) time.
/* “I sort the intervals by their left endpoint and process the queries in increasing order. For each query, I add all intervals whose left endpoint is less than or equal to the query into a min heap ordered by interval length. 
    I remove intervals whose right endpoint is smaller than the query because they can no longer contain it. The heap’s top is therefore the smallest valid interval for that query. 
    I store answers in a HashMap so I can restore the original query order.” */

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // Sort intervals by their starting point.
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // Min-heap ordered by interval length.
        // Each element is {length, rightEndpoint}.
        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        // Store the answer for each query.
        // HashMap is needed because queries may contain duplicates
        // and are processed in sorted order.
        Map<Integer, Integer> res = new HashMap<>();
        int i = 0;
        // Process queries in increasing order.
        for (int q : Arrays.stream(queries).sorted().toArray()) {
            // Add every interval that has started by this query.
            while (i < intervals.length && intervals[i][0] <= q) {
                int l = intervals[i][0];
                int r = intervals[i][1];
                // Store:
                // [interval length, right endpoint]
                minHeap.offer(
                    new int[] { r - l + 1, r }
                );
                i++;
            }
            // Remove intervals that cannot contain the query anymore.
            while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }
            // The heap top is the smallest interval
            // that currently contains the query.
            res.put(
                q,
                minHeap.isEmpty() ? -1 : minHeap.peek()[0]
            );
        }
        // Restore the original query order.
        int[] result = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            result[j] = res.get(queries[j]);
        }
        return result;
    }
}

// Time Complexity :- O(N log N + Q log Q).
// Space Complexity :- O(N + Q).

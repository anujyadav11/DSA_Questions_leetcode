/*********************************************** JAVA **************************************************/

// Optimal Solution - Maximizes triplet sum with distinct x values by mapping each x to its best y, then extracting the top 3 y values using a max heap.
/* "The deduplication step is key — keeping max y per x ensures we pick the best representative for each group. A max heap then trivially gives top-3 in O(k log k). 
    Alternative O(k) approach: find top-3 with three variables in a single pass — avoids heap overhead when k is large." */

class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        // map each unique x value to its maximum corresponding y value
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < x.length; i++)
            map.put(x[i], Math.max(map.getOrDefault(x[i], 0), y[i]));
        // max heap to get top 3 y values from distinct x groups
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int val : map.values())
            maxHeap.add(val);
        // need at least 3 distinct x values
        if (maxHeap.size() < 3)
            return -1;
        // sum top 3 maximum y values
        int sum = 0;
        for (int i = 0; i < 3; i++)
            sum += maxHeap.poll();
        return sum;
    }
}

// Time Complexity :- O(n + k log k). — n to build map, k unique x values for heap where k ≤ n
// Space Complexity :- O(k). — HashMap and heap each store at most k unique x entries

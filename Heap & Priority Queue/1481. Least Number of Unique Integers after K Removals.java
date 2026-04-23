/*********************************************** JAVA **************************************************/

// Optimal Solution - Minimizes remaining unique integers by greedily removing least frequent elements first using a min heap, stopping when k removals are exhausted.
/* Greedy works here because removing a rare element costs fewer operations and eliminates one unique value — always optimal to remove cheapest first. 
  The key detail is checking elementsRemoved > k before poll() — if we can't fully remove the current element, all remaining heap elements also can't be removed, 
  so pq.size() is the answer including the current element." */

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // Map to track the frequencies of elements
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i : arr) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        // Min heap to track all the frequencies
        PriorityQueue<Integer> pq = new PriorityQueue<>(mp.values());
        // Tracking the number of elements removed
        int elementsRemoved = 0;
        // Traversing all frequencies
        while (!pq.isEmpty()) {
            // Removing the least frequent element
            elementsRemoved += pq.peek();
            // If the number of elements removed exceeds k, return
            // the remaining number of unique elements
            if (elementsRemoved > k) {
                return pq.size();
            }
            pq.poll();
        }
        // We have removed all elements, so no unique integers remain
        // Return 0 in this case
        return 0;
    }
}

// Time Complexity :- O(n log n). Insertion in a priority queue takes log n time.
// Space Complexity :- O(n). 

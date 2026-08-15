/*********************************************** JAVA **************************************************/

// Optimal Solution - Uses a max heap to repeatedly smash the two heaviest stones until only one or none remains.
/* “I use a max-heap so I can efficiently retrieve the two heaviest stones. I repeatedly remove them, destroy both if they are equal, 
    otherwise insert their difference back into the heap. When at most one stone remains, I return its weight.” */

class Solution {
    public int lastStoneWeight(int[] stones) {
        // Max-heap: largest stone is always at the top
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            // Take two heaviest stones
            int x = pq.poll();
            int y = pq.poll();
            // If they are different, the remaining stone is x - y
            if (x != y) {
                pq.offer(x - y);
            }
        }
        // All stones may have been destroyed
        return pq.isEmpty() ? 0 : pq.peek();
    }
}

// Time Complexity :- O(n log  n).
// Space Complexity :- O(n).

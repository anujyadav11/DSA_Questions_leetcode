/*********************************************** JAVA **************************************************/

// Optimal Solution - Use a max heap to repeatedly replace the largest gift pile with its square root.
/* "At each step we must reduce the largest pile, so I use a max heap to always extract the maximum element, replace it with its square root, and push it back." */

class Solution {
    public long pickGifts(int[] gifts, int k) {
        // Max heap to always get the largest gift pile
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>((a, b) -> b - a);
        // Add all gifts into the heap
        for (int gift : gifts) {
            maxHeap.offer(gift);
        }
        // Perform k operations
        while (k-- > 0) {
            // Get the largest pile
            int maxGift = maxHeap.poll();
            // Replace it with floor(sqrt(maxGift))
            maxHeap.offer((int) Math.sqrt(maxGift));
        }
        long remainingGifts = 0;
        // Sum all remaining gifts
        while (!maxHeap.isEmpty()) {
            remainingGifts += maxHeap.poll();
        }
        return remainingGifts;
    }
}

// Time Complexity :- O((n + k) log n).
// Space Complexity :- O(n).

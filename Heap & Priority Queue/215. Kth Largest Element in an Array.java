/*********************************************** JAVA **************************************************/

// Optimal Solution - Find the kth largest element by maintaining a min-heap of size k while iterating through the array.

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-heap stores the k largest elements
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            // Add current element
            pq.offer(num);
            // Remove the smallest if we have more than k elements
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // Smallest among the k largest = kth largest
        return pq.peek();
    }
}


// Time Complexity :- O(n log k).
// Space Complexity :- O(k).

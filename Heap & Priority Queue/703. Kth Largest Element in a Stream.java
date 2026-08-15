/*********************************************** JAVA **************************************************/

// Optimal Solution - Maintain a min-heap of size k so its minimum element is always the kth largest value.
/* “I maintain a min-heap containing only the k largest elements seen so far. If the heap has fewer than k elements, I add the value. 
    Otherwise, I add it only if it’s larger than the current minimum. When the heap exceeds size k, I remove the minimum. Therefore, the heap’s root is always the kth largest element.” */

class KthLargest {
    // Min-heap stores the k largest elements
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        // Add initial elements through the same logic
        for (int num : nums) {
            add(num);
        }
    }
    public int add(int val) {
        // Add if we have fewer than k elements
        // or val belongs to the current top k elements
        if (pq.size() < k || val > pq.peek()) {
            pq.offer(val);
            // Keep only the k largest elements
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // Smallest element among the top k = kth largest
        return pq.peek();
    }
}

// Time Complexity:- Constructor: O(n log k) , add(): O(log k)
// Space Complexity:- O(k)

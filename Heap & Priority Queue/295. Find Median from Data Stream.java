/*********************************************** JAVA **************************************************/

// Optimal Solution - I keep the smaller half in a max-heap and the larger half in a min-heap, balancing their sizes so the median is always accessible in constant time.
/* “I maintain two heaps to dynamically find the median. The max heap stores the smaller half of the numbers, while the min heap stores the larger half. 
    I keep the two heaps balanced so their sizes differ by at most one, and I ensure every value in the max heap is less than or equal to every value in the min heap. 
    If the total count is odd, the root of the larger heap is the median. If it is even, the median is the average of both heap roots.” */

class MedianFinder {
    // Stores the larger half of the numbers
    PriorityQueue<Integer> minHeap;
    // Stores the smaller half of the numbers
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        // Max heap: largest element stays at the top
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    }
    public void addNum(int num) {
        // Initially add the number to the smaller half
        maxHeap.offer(num);
        // If the largest element in the smaller half
        // is greater than the smallest element in the larger half,
        // move it to the larger half.
        if (!maxHeap.isEmpty()
                && !minHeap.isEmpty()
                && maxHeap.peek() > minHeap.peek()) {
            int val = maxHeap.poll();
            minHeap.offer(val);
        }
        // Keep heap sizes balanced
        if (maxHeap.size() > minHeap.size() + 1) {
            int val = maxHeap.poll();
            minHeap.offer(val);
        }
        if (minHeap.size() > maxHeap.size() + 1) {
            int val = minHeap.poll();
            maxHeap.offer(val);
        }
    }
    public double findMedian() {
        // More elements in the larger half
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();

        } else {
            // Equal number of elements
            return ((long) minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }
}

// Time Complexity :- O(log n).
// Space Complexity :- O(n).

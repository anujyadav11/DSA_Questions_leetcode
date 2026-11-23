/*********************************************** JAVA **************************************************/

// Optimal Solution - Implemented chronological event processing using a Min Heap and passenger-count tracking to validate vehicle capacity in O(n log n) time and O(n) auxiliary space.
/* "I convert every trip into two events: a positive passenger change at the pickup location and a negative change at the drop-off location. I use a Min Heap to process these events chronologically. 
    At each location, I process all events occurring there and update the current passenger count. If the count exceeds the vehicle capacity at any point, I return false; otherwise, all trips can be completed." */

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // Min Heap that sorts events by location in ascending order.
        // Each event contains:
        // [location, passengerChange]
        // Positive value = passengers picked up.
        // Negative value = passengers dropped off.
        PriorityQueue<int[]> minheap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        // Process every trip and create pickup/drop-off events.
        for (int i = 0; i < trips.length; i++) {
            int numPass = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];
            // Pickup event: passenger count increases at the starting location.
            minheap.add(new int[] { from, numPass });
            // Drop-off event: passenger count decreases at the destination.
            minheap.add(new int[] { to, -numPass });
        }
        // Tracks the current number of passengers in the car.
        int curCap = 0;
        // Process all events in chronological order.
        while (!minheap.isEmpty()) {
            // Get the current location being processed.
            int curPass = minheap.peek()[0];
            // Process every event occurring at this same location.
            while (!minheap.isEmpty() && minheap.peek()[0] == curPass) {
                // Remove the next event from the heap.
                int[] trip = minheap.poll();
                // Get the passenger count change.
                int numPass = trip[1];
                // Update the current passenger count.
                curCap += numPass;
            }
            // If passenger count exceeds vehicle capacity,
            // the car cannot accommodate all passengers.
            if (curCap > capacity) {
                return false;
            }
        }
        // All events were processed without exceeding capacity.
        return true;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(n).

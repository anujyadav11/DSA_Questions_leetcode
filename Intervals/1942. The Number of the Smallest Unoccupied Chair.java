/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds target friend's chair by simulating arrivals with two min-heaps tracking available chairs and occupied chair departure times.
/* "Two heaps model the two states — available (ordered by chair number for smallest) and occupied (ordered by departure for earliest freeing). 
    Always save the target's arrival time before sorting since sorting changes the index. Processing departures before the current arrival ensures chairs are freed in the correct order." */

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        // save target friend's arrival time before sorting
        int tarSt = times[targetFriend][0];
        // sort by arrival time
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        // min heap of available chair numbers
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++)
            available.offer(i);
        // min heap of (departure time, chair number) for occupied chairs
        PriorityQueue<int[]> occupied = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < times.length; i++) {
            // free chairs from friends who left before current arrival
            while (!occupied.isEmpty() && occupied.peek()[0] <= times[i][0])
                available.offer(occupied.poll()[1]);
            // found target friend — return smallest available chair
            if (times[i][0] == tarSt)
                return available.peek();
            // assign smallest available chair to current friend
            occupied.offer(new int[]{times[i][1], available.poll()});
        }
        return -1;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(n).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Implements double-booking calendar using a sorted difference map with prefix sum validation, rolling back tentative additions when triple overlap is detected.
/* "The difference array pattern converts interval overlap detection into a prefix sum problem — elegant and extensible to k-booking variants by just changing > 2 to > k. 
    Always clean up zero-value entries to keep the map compact. The rollback must undo both the start increment and end decrement — missing either corrupts future queries." */

class MyCalendarTwo {
    // difference array map — +1 at start, -1 at end for each booking
    TreeMap<Integer, Integer> events;
    public MyCalendarTwo() {
        events = new TreeMap<>();
    }
    public boolean book(int startTime, int endTime) {
        // tentatively add new booking to difference map
        events.put(startTime, events.getOrDefault(startTime, 0) + 1);
        events.put(endTime, events.getOrDefault(endTime, 0) - 1);
        // prefix sum over sorted keys to find max concurrent bookings
        int count = 0;
        for (int delta : events.values()) {
            count += delta;
            if (count > 2) {
                // triple booking detected — rollback the tentative addition
                events.put(startTime, events.get(startTime) - 1);
                if (events.get(startTime) == 0)
                    events.remove(startTime);
                events.put(endTime, events.get(endTime) + 1);
                if (events.get(endTime) == 0)
                    events.remove(endTime);
                return false;
            }
        }
        return true;
    }
}

// Time Complexity :- O(n). — iterating all events for prefix sum; O(n log n) total for n bookings.
// Space Complexity :- O(n). — at most 2n entries in the map for n bookings

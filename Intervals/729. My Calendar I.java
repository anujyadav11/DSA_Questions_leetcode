/*********************************************** JAVA **************************************************/

// Optimal Solution - Implements calendar booking using TreeMap floor/ceiling lookups to check both neighbouring intervals for overlap in O(log n) per booking.
/*  "floorKey(start) finds the last booking that could overlap from the left — its end must be ≤ new start. ceilingKey(start) finds the first booking that could overlap from the right
    — new end must be ≤ its start. Two checks cover all overlap cases. lowerKey vs floorKey is a subtle but critical difference — floor includes equal keys." */

class MyCalendar {
    // maps start time to end time of each booking
    TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }
    public boolean book(int startTime, int endTime) {
        // find the nearest booking that starts at or before startTime
        Integer prevStart = map.floorKey(startTime);
        // check if previous booking overlaps — its end must be <= new start
        if (prevStart != null && map.get(prevStart) > startTime)
            return false;
        // find the nearest booking that starts after startTime
        Integer nextStart = map.ceilingKey(startTime);
        // check if next booking overlaps — new end must be <= next start
        if (nextStart != null && endTime > nextStart)
            return false;
        map.put(startTime, endTime);
        return true;
    }
}

// Time Complexity :- O(log n).
// Space Complexity :- O(n).

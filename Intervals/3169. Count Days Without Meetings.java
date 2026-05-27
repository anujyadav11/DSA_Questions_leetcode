/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts meeting-free days by sorting intervals, tracking merged end points, and summing gaps between consecutive non-overlapping meeting blocks.
/*  "This is gap counting between merged intervals — sort by start, track running max end, count gaps before each new non-overlapping block. 
     The -1 in meetings[i][0] - end - 1 accounts for the fact that end day itself is a meeting day. Don't forget the tail gap after the last meeting — a common missed edge case." */

class Solution {
    public int countDays(int days, int[][] meetings) {
        int n = meetings.length;
        // sort meetings by start time to process in order
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int end = 0;
        int daysOff = 0;
        for (int i = 0; i < n; i++) {
            // gap between previous meeting end and current meeting start
            if (meetings[i][0] > end)
                daysOff += meetings[i][0] - end - 1;
            // extend end to cover overlapping or adjacent meetings
            end = Math.max(end, meetings[i][1]);
        }
        // count remaining days after last meeting
        if (end < days)
            daysOff += days - end;
        return daysOff;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(1).

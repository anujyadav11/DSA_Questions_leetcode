/*********************************************** JAVA **************************************************/

// Optimal Solution - Greedy solution that minimises interval removals by selecting intervals with the earliest finishing times. Sort by end time and greedily keep intervals that don’t overlap—remove the rest.
/* “Instead of directly deciding which intervals to remove, I maximize the number of intervals I can keep. I sort by end time because choosing the interval that finishes earliest leaves the most room for future intervals.
    I then greedily keep every interval whose start is at least the end of the last kept interval. Finally, the number of removals is n - count.” */

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        // No intervals to remove
        if (n == 0)
            return 0;
        // Sort intervals by their ending time
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[1]));
        // Keep the first interval
        int count = 1;
        int prev = 0;
        for (int i = 1; i < n; i++) {
            // Current interval does not overlap with previous kept interval
            if (intervals[i][0] >= intervals[prev][1]) {
                prev = i;
                count++;
            }
        }
        // Remove all intervals that were not kept
        return n - count;
    }
}

// Time Complexity :- O(N log N).
// Space Complexity :- O(1).

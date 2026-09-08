/*********************************************** JAVA **************************************************/

// Optimal Solution - Greedy single-pass solution to insert and merge an interval into a sorted list of intervals. Process intervals in order: add non-overlapping ones, merge overlaps with the new interval, then append the rest.
/* “I scan the intervals in three phases. First, I add all intervals that end before the new interval starts. Then I merge every overlapping interval by taking the minimum start and maximum end. 
    Finally, I add the remaining intervals. Since every interval is visited only once, the solution runs in O(n) time.” */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        // Add intervals that end before the new interval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        // Merge all intervals that overlap with newInterval
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // Add the merged interval
        res.add(newInterval);
        // Add remaining intervals
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][2]);
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(N).

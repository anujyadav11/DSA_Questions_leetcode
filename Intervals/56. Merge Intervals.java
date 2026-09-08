/*********************************************** JAVA **************************************************/

// Optimal Solution - Greedy solution that merges overlapping intervals after sorting by start time. Sort intervals by start time, then merge consecutively overlapping ones in a single pass.
/* “I first sort the intervals by their starting point. Then I maintain the last merged interval. If the current interval starts before or at the end of the merged interval, 
    they overlap, so I extend the end. Otherwise, I add the current interval as a new merged interval.” */
  
class Solution {
    public int[][] merge(int[][] intervals) {
        // If there are 0 or 1 intervals, nothing needs to be merged
        if (intervals.length <= 1) {
            return intervals;
        }
        // Sort intervals by their starting point
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> res = new ArrayList<>();
        // Start with the first interval
        int[] newInterval = intervals[0];
        res.add(newInterval);
        for (int[] interval : intervals) {
            // Current interval overlaps with the last merged interval
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } 
            else {
                // No overlap, start a new merged interval
                newInterval = interval;
                res.add(newInterval);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}

// Time Complexity :- O(N log N).
// Space Complexity :- O(N).

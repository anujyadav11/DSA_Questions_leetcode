/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds minimum groups for non-overlapping intervals by computing maximum simultaneous overlaps using a difference array and prefix sum sweep.
/* "Minimum groups = maximum overlap at any point — a classic equivalence. The difference array converts range updates to O(1) each, then one prefix sum pass finds the maximum. 
    Alternative: sort start/end events separately (two-pointer merge) for O(n log n) without the O(max) space dependency — better when interval values are very large." */

class Solution {
    public int minGroups(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // find range of all interval values
        for (int[] interval : intervals) {
            min = Math.min(min, interval[0]);
            max = Math.max(max, interval[1]);
        }
        // difference array — +1 at start, -1 after end
        int[] eventCount = new int[max + 2];
        for (int[] interval : intervals) {
            eventCount[interval[0]]++;
            eventCount[interval[1] + 1]--;
        }
        int maxOverlap = 0;
        int sum = 0;
        // prefix sum to find maximum simultaneous overlaps
        for (int i = min; i <= max + 1; i++) {
            sum += eventCount[i];
            maxOverlap = Math.max(sum, maxOverlap);
        }
        // minimum groups needed = maximum number of overlapping intervals
        return maxOverlap;
    }
}

// Time Complexity :- O(n + max).
// Space Complexity :- O(max).

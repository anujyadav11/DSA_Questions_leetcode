/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds minimum time difference by converting times to minutes, sorting, and checking both consecutive and circular (midnight-wrapping) gaps.
/* "The circular gap (24*60 - last) + first handles the midnight wrap — minimum difference could be between the latest time and earliest time going through midnight. 
    Always check this circular case explicitly. Arrays.sort vs Array.sort is a classic typo — Java uses Arrays (plural) for all array utility methods." */

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] mins = new int[n];
        // convert each time string to total minutes
        for (int i = 0; i < n; i++) {
            String time = timePoints.get(i);
            // FIXED: directly use string without Integer.toString conversion
            int hour = Integer.parseInt(time.substring(0, 2));
            int min = Integer.parseInt(time.substring(3));
            mins[i] = hour * 60 + min;
        }
        // FIXED: Arrays.sort not Array.sort
        Arrays.sort(mins);
        int res = Integer.MAX_VALUE;
        // check difference between consecutive sorted times
        for (int i = 1; i < n; i++)
            res = Math.min(res, mins[i] - mins[i - 1]);
        // check circular difference between last and first (wrapping midnight)
        return Math.min(res, (24 * 60 - mins[n - 1]) + mins[0]);
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(n).

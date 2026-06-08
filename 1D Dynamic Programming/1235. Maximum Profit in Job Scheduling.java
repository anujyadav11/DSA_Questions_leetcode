/*********************************************** JAVA **************************************************/

// Optimal Solution - Maximizes job scheduling profit using DP sorted by end time with binary search to find the last compatible non-overlapping job for each candidate.
/* "Sorting by end time is the key enabler — it ensures dp[i-1] represents the best profit from all previous jobs, and binary search finds the rightmost compatible job in O(log n). 
    The comparison jobs[mid][1] <= jobs[i][0] checks non-overlap — end of previous job must be ≤ start of current job. This is weighted interval scheduling — a classic DP pattern." */

class Solution {
    // find rightmost job that ends at or before given time
    private int binarySearch(int[][] jobs, int time, int left, int right) {
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][1] <= time)  {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        // combine into single array for sorting
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        // sort by end time — enables binary search for non-overlapping jobs
        Arrays.sort(jobs, Comparator.comparingInt(m -> m[1]));
        // dp[i] = max profit considering first i+1 jobs
        int[] dp = new int[n];
        dp[0] = jobs[0][2];
        for (int i = 1; i < n; i++) {
            // find last job ending at or before current job's start time
            int lastJobIndex = binarySearch(jobs, jobs[i][0], 0, i - 1);
            int prevProfit = lastJobIndex != -1 ? dp[lastJobIndex] : 0;
            // either skip current job or take it
            dp[i] = Math.max(prevProfit + jobs[i][2], dp[i - 1]);
        }
        return dp[n - 1];
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(n).

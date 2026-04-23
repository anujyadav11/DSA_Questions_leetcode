/*********************************************** JAVA **************************************************/

// Optimal Solution - Computes range sum of sorted subarray sums using a min heap that generates subarrays in ascending order by extending each polled subarray rightward.
/*  "The heap always contains the next candidate subarray for each starting index — extending rightward after polling generates all subarrays in sorted order without storing them all. 
      Use 1-indexed loop bounds to match the problem's 1-indexed left and right — mixing 0 and 1 indexing is a common source of off-by-one bugs here." */

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod = (int) 1e9 + 7;
        // min heap stores {currentSubarraySum, endIndex}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // initialize with all single-element subarrays
        for (int i = 0; i < n; i++)
            pq.offer(new int[]{nums[i], i});
        long sum = 0;
        // extract subarrays in sorted order — accumulate from left-th to right-th
        for (int idx = 1; idx <= right; idx++) {
            int[] cur = pq.poll();
            // only add to sum if within [left, right] range (1-indexed)
            if (idx >= left)
                sum = (sum + cur[0]) % mod;
            // extend subarray by one element to the right
            if (cur[1] + 1 < n) {
                cur[0] += nums[cur[1] + 1];
                cur[1]++;
                pq.offer(cur);
            }
        }
        return (int) sum;
    }
}

// Time Complexity :- O((n + right) log n).
// Space Complexity :- O(n).

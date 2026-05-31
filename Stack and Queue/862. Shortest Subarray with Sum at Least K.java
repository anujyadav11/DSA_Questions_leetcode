/*********************************************** JAVA **************************************************/

// Optimal Solution -Finds shortest subarray with sum ≥ k using prefix sums and a monotonic increasing deque to efficiently track minimum-length valid subarrays.
/* "The monotonic deque is key — maintaining increasing prefix sums means when we find prefSum[j] - prefSum[front] >= k, 
    the front gives the earliest valid start and thus the longest (not shortest) subarray — we want to pop it immediately to find shorter ones. 
    Negative numbers make sliding window impossible — prefix sum + deque is the O(n) solution." */

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        // prefix sum array — index shifted by 1 for cleaner subarray sum formula
        long[] prefSum = new long[n + 1];
        for (int i = 0; i < n; i++)
            prefSum[i + 1] = prefSum[i] + nums[i];
        // monotonic increasing deque of prefix sum indices
        Deque<Integer> deq = new LinkedList<>();
        int result = Integer.MAX_VALUE;
        for (int j = 0; j <= n; j++) {
            // pop front while subarray sum >= k — update shortest length
            while (!deq.isEmpty() && prefSum[j] - prefSum[deq.peekFirst()] >= k) {
                result = Math.min(result, j - deq.pollFirst());
            }
            // maintain increasing order — pop back if current prefix sum is smaller
            while (!deq.isEmpty() && prefSum[j] <= prefSum[deq.peekLast()])
                deq.pollLast();
            deq.offerLast(j);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}

// Time Complexity :- O(n). — each index added and removed from deque at most once
// Space Complexity :- O(n). — prefix sum array and deque each size n+1.

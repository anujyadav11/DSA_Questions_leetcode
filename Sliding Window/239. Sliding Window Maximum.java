/******************************************** JAVA *************************************************/

// Optimal solution - We use a monotonic decreasing deque to maintain indices of potential maximums, removing out-of-window and smaller elements so the front of the deque always holds the maximum for the current sliding window.
/* “I use a monotonic decreasing deque that stores indices. The values corresponding to those indices are maintained in decreasing order, so the front of the deque is always the maximum of the current window. 
    Before adding a new index, I remove all smaller elements from the back because they can never become the maximum while the new element is present. 
    I also remove indices from the front when they leave the window. Since every index is inserted and removed at most once, the overall complexity is linear.” */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // Stores indices in decreasing order of their values
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[n - k + 1];
        // Build the deque for the first window
        for (int i = 0; i < k; i++) {
            // Remove smaller elements because they can never
            // become the maximum while nums[i] is in the window
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        // Maximum of the first window
        res[0] = nums[dq.peekFirst()];
        // Process remaining elements
        for (int i = k; i < n; i++) {
            // Remove indices that are outside the current window
            if (dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            // Maintain decreasing order of values
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            // Front always contains the maximum element
            res[i - k + 1] = nums[dq.peekFirst()];
        }
        return res;
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(K).

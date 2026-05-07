/*********************************************** JAVA **************************************************/

// Optimal Solution - Maximizes k-round score by greedily always picking the largest element using a max heap, replacing each picked value with its ceiling third.
/* "val / 3.0 with double division is critical — val / 3 in integer division truncates instead of ceiling. For example val = 7: ceil(7/3.0) = 3 but 7/3 = 2. 
    Always use Math.ceil with floating point division or the formula (val + 2) / 3 for integer ceiling to avoid this subtle bug." */

class Solution {
    public long maxKelements(int[] nums, int k) {
        // max heap — always pick largest element
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums)
            pq.offer(num);
        long score = 0;
        while (k-- > 0) {
            // pick maximum element
            int val = pq.poll();
            score += val;
            // replace with ceil(val/3) for next rounds
            pq.offer((int) Math.ceil(val / 3.0));
        }
        return score;
    }
}

// Time Complexity :- O((n + k) log n) .
// Space Complexity :- O(n).

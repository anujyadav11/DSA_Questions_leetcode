/*********************************************** JAVA **************************************************/

// Optimal Solution - Maximizes k's frequency by applying Kadane's algorithm for each target value, finding maximum net gain of num-to-k conversions within any subarray window.
/* "This is Kadane's maximum subarray adapted for frequency maximization. For each target num, treat occurrences as +1 gain and occurrences of k as -1 cost — 
    the maximum subarray sum gives the best window for conversions. The constraint that values are 1-50 makes the O(50n) outer loop effectively O(n)." */

class Solution {
    public int maxFrequency(int[] nums, int k) {
        // count base frequency of k
        int cntK = 0;
        for (int num : nums)
            if (num == k) cntK++;
        int res = cntK;
        // try each possible target value (1 to 50)
        for (int num = 1; num <= 50; num++) {
            if (num == k) continue;
            // sliding window — track net gain of converting num <-> k
            int cnt = 0;
            for (int val : nums) {
                // found target num — potential gain
                if (val == num) cnt++;
                // found k — costs one k to convert to num
                if (val == k) cnt--;
                // reset if net effect is negative — start fresh window
                cnt = Math.max(cnt, 0);
                // total frequency = base k count + net conversions
                res = Math.max(res, cntK + cnt);
            }
        }
        return res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

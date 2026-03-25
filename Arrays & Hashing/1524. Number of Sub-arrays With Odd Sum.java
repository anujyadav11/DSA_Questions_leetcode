/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts subarrays with odd sum in O(n) by tracking even/odd prefix sum frequencies, leveraging the fact that odd−even=odd and even−odd=odd.
/* "The key insight is that subarray sum parity depends only on prefix sum parities — odd minus even or even minus odd gives odd. So instead of storing all remainders in a HashMap like mod-k problems, 
    two counters suffice here since there are only two parities." */

class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        // count of even prefix sums seen so far (empty prefix = 0 is even)
        int evenCnt = 1;
        // count of odd prefix sums seen so far
        int oddCnt = 0;
        int res = 0;
        int prefixSum = 0;
        for (int num : arr) {
            // accumulate prefix sum
            prefixSum += num;
            if (prefixSum % 2 == 0) {
                // even - odd = odd → each odd prefix seen before gives an odd subarray
                res += oddCnt;
                // current even prefix sum recorded for future use
                evenCnt++;
            } else {
                // odd - even = odd → each even prefix seen before gives an odd subarray
                res += evenCnt;
                // current odd prefix sum recorded for future use
                oddCnt++;
            }
            // apply MOD to prevent overflow
            res = res % MOD;
        }
        // return total count of subarrays with odd sum
        return res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

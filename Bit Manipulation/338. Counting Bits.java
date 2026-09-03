/*********************************************** JAVA **************************************************/

// Optimal Solution - DP solution that computes set bits for all numbers using the relation between i and i/2. Reuse previously computed results: every number’s bit count depends on its half, plus one if it’s odd.
/* “I use dynamic programming. Right-shifting a number by one removes its least significant bit, so the number of set bits in i is the number of set bits in i / 2 plus one if i is odd. 
    This lets me calculate every result in constant time and build the answer in O(n).” */

class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            // Odd number = bits of i/2 + 1
            if (i % 2 != 0) {
                res[i] = res[i / 2] + 1;
            } else {
                // Even number has the same number of 1s as i/2
                res[i] = res[i / 2];
            }
        }
        return res;
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(N).

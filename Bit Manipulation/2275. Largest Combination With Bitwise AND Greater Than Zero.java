/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds largest AND combination by counting set bits per position across all candidates, returning the maximum column count as the answer.
/*  "The AND operation preserves bits only when all elements have that bit set — so the largest combination sharing a common set bit is simply the count of candidates with that bit. 
      Checking all 24 bit positions covers the full range since 10^7 < 2^24. This converts an exponential subset search to an O(24n) bit-counting problem." */

class Solution {
    public int largestCombination(int[] candidates) {
        int res = 0;
        // check each bit position 0 to 23 (candidates fit in 24 bits)
        for (int i = 0; i < 24; i++) {
            int count = 0;
            // count candidates with bit i set
            for (int num : candidates)
                if ((num & (1 << i)) != 0)
                    count++;
            // track maximum count across all bit positions
            res = Math.max(res, count);
        }
        return res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(24).

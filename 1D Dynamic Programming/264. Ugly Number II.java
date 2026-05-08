/*********************************************** JAVA **************************************************/

// Optimal Solution - Generates the nth ugly number using three-pointer DP, always selecting the minimum of next candidates from factors 2, 3, and 5 while advancing all matching pointers.
/* "Using three separate if statements instead of else if is critical — when two factors produce the same minimum (e.g. both 2×3=6 and 3×2=6), both pointers must advance to avoid duplicates in the sequence. 
    This is the most common mistake in this problem. The pattern extends to any set of prime factors for the 'super ugly number' variant." */

class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        // three pointers tracking next index to multiply for each factor
        int i2 = 0, i3 = 0, i5 = 0;
        // next candidates for each factor
        int f2 = 2, f3 = 3, f5 = 5;
        for (int i = 1; i < n; i++) {
            // pick smallest candidate as next ugly number
            int min = Math.min(f2, Math.min(f3, f5));
            ugly[i] = min;
            // advance all pointers that produced the minimum — handles duplicates
            if (min == f2)
                f2 = 2 * ugly[++i2];
            if (min == f3)
                f3 = 3 * ugly[++i3];
            if (min == f5)
                f5 = 5 * ugly[++i5];
        }
        return ugly[n - 1];
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Minimizes the maximum store quantity using binary search on the answer, verifying feasibility via ceiling division of each product type across available stores.
/* "Binary search on answer works because feasibility is monotonic — larger x always needs fewer stores. The ceiling division (prod + x - 1) / x is the standard integer ceil trick — 
    always use this instead of Math.ceil((double)prod/x) to avoid floating point precision issues in interviews." */

class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        // binary search between 1 and max quantity
        int left = 1;
        int right = Arrays.stream(quantities).max().getAsInt();
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(mid, quantities, n)) {
                // mid works — try smaller maximum
                res = mid;
                right = mid - 1;
            } else {
                // mid too small — need more per store
                left = mid + 1;
            }
        }
        // return minimized maximum quantity per store
        return res;
    }
    public boolean isPossible(int x, int[] nums, int n) {
        for (int prod : nums) {
            // ceil(prod / x) = minimum stores needed for this product type
            n -= (prod + x - 1) / x;
            // used more stores than available — not feasible
            if (n < 0) return false;
        }
        // remaining stores available — feasible
        return true;
    }
}

// Time Complexity :- O(m log(maxQ)).
// Space Complexity :- O(1).

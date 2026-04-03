/*********************************************** JAVA **************************************************/

// Optimal Solution - Maximizes candies per child using binary search on the answer, greedily verifying feasibility by summing floor divisions of each pile against k children.
/*  "Binary search on answer works when the feasibility function is monotonic — if mid candies per child is feasible, any smaller amount is also feasible. 
    The key check is sum(pile/mid) >= k. Use long for total sum and k since pile sizes can overflow int when accumulated." */

class Solution {
    private boolean canDistr(int[] candies, int mid, long k) {
        // check if we can give 'mid' candies to at least k children
        for (int candy : candies) {
            // each pile contributes floor(candy/mid) children served
            k -= candy / mid;
            // early exit — already served enough children
            if (k <= 0)
                return true;
        }
        // k <= 0 means all children served, k > 0 means not enough
        return k <= 0;
    }
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int maxC = 0;
        long total = 0;
        for (int i = 0; i < n; i++) {
            total += candies[i];
            // track max pile size — upper bound for binary search
            maxC = Math.max(maxC, candies[i]);
        }
        // impossible — not enough candies for k children even with 1 each
        if (total < k)
            return 0;
        int l = 1;
        // max possible answer is the largest single pile
        int r = maxC;
        int result = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canDistr(candies, mid, k)) {
                // mid candies per child is feasible — try larger
                result = mid;
                l = mid + 1;
            } else {
                // mid too large — try smaller
                r = mid - 1;
            }
        }
        // return maximum candies each child can receive
        return result;
    }
}

// Time Complexity :- O(n log maxC).
// Space Complexity :- O(1).

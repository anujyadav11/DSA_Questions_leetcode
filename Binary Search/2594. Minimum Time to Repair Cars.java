/*********************************************** JAVA **************************************************/

// Optimal Solution - Minimizes car repair time using binary search on answer, verifying feasibility by summing floor(sqrt(time/rank)) cars per mechanic against total required.

/* "The inverse formula is key — from time = rank × n², derive n = floor(sqrt(time/rank)) cars per mechanic. Binary search on time with this feasibility check gives O(n log(maxRank × cars²)). 
    Always use long for the upper bound since maxRank × cars² can overflow int easily." */

class Solution {
    public long repairCars(int[] ranks, int cars) {
        // start = min rank (best mechanic), end = worst case time
        long start = Long.MAX_VALUE;
        long end = Long.MIN_VALUE;
        for (int rank : ranks) {
            end = Math.max(end, rank);
            start = Math.min(start, rank);
        }
        // worst case: slowest mechanic repairs all cars alone
        end = end * cars * cars;
        long ans = 0;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (isCarsRepaired(mid, ranks, cars)) {
                // mid minutes is feasible — try less time
                ans = mid;
                end = mid - 1;
            } else {
                // not enough time — try more
                start = mid + 1;
            }
        }
        // return minimum time to repair all cars
        return ans;
    }
    public boolean isCarsRepaired(long mid, int[] ranks, int cars) {
        long carRepaired = 0;
        for (int rank : ranks) {
            // mechanic with rank r repairs floor(sqrt(mid/r)) cars in mid minutes
            carRepaired += (long) Math.sqrt((1.0 * mid) / rank);
            // early exit — already enough cars repaired
            if (carRepaired >= cars) return true;
        }
        return false;
    }
}

// Time Complexity :- O(n log (maxranks * cars^2).
// Space Complexity :- O(1).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Solved Capacity To Ship Packages Within D Days using binary search on the answer and a greedy feasibility check.
/* “I binary-search the shipping capacity between the heaviest package and the sum of all weights. For each candidate capacity, I greedily ship packages in their original order and count the required days. 
    If the number of days exceeds the limit, I increase the capacity; otherwise, I search for a smaller feasible capacity. This finds the minimum valid capacity efficiently.” */

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minCap = 0;
        int maxCap = 0;
        // Minimum capacity must fit the heaviest package.
        // Maximum capacity can ship all packages in one day.
        for (int w : weights) {
            minCap = Math.max(minCap, w);
            maxCap += w;
        }
        // Binary search for the minimum feasible capacity.
        while (minCap < maxCap) {
            int mid = minCap + (maxCap - minCap) / 2;
            int day = 1;
            int sum = 0;
            // Simulate shipping packages in their original order.
            for (int w : weights) {
                if (sum + w > mid) {
                    // The current package cannot fit today.
                    // Start shipping on the next day.
                    day++;
                    sum = 0;
                }
                // Load the current package.
                sum += w;
            }
            // If capacity requires too many days, increase it.
            if (day > days) {
                minCap = mid + 1;
            } else {
                // Otherwise, try a smaller capacity.
                maxCap = mid;
            }
        }
        // minCap is the smallest feasible shipping capacity.
        return minCap;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(1).

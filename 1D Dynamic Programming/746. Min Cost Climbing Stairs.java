/*********************************************** JAVA **************************************************/

//Optimal Solution - Find the minimum climbing cost using bottom-up DP by choosing the cheaper path from the previous two stairs.
/* “I define dp[i] as the minimum cost required to reach the top position i. Since I can reach i from either i-1 or i-2, I take the minimum of those two costs. 
    The final position is n, representing the top beyond the last stair.” */

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // minCost[i] = minimum cost to reach stair i
        int[] minCost = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            // Reach i from either i-1 or i-2
            minCost[i] = Math.min(
                cost[i - 1] + minCost[i - 1],
                cost[i - 2] + minCost[i - 2]
            );
        }
        return minCost[n];
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(N).

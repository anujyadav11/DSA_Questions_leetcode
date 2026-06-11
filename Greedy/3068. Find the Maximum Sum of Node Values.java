/*********************************************** JAVA **************************************************/

// Optimal Solution - Maximizes node value sum by greedily XOR-ing beneficial elements, then fixing odd operation count by reverting the minimum-loss XOR.
/* "The parity constraint comes from tree path structure — XOR operations must appear an even number of times. Greedily apply all beneficial XORs, then check parity 
  — if odd, subtract the minimum loss from reverting any single operation. Always use long for XOR arithmetic on int values since int ^ k can exceed int range when combined." */

class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        int count = 0;
        // minLoss as long to handle long arithmetic result
        long minLoss = Long.MAX_VALUE;
        for (int num : nums) {
            long xored = (long) num ^ k;
            if (xored > num) {
                // XOR increases value — apply it
                count++;
                sum += xored;
            } else {
                // XOR decreases value — keep original
                sum += num;
            }
            // track minimum loss from reverting one XOR operation
            minLoss = Math.min(minLoss, Math.abs(num - xored));
        }
        // even count of XOR ops — all operations cancel out on paths
        if (count % 2 == 0)
            return sum;
        // odd count — must revert one XOR, choose minimum loss
        return sum - minLoss;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

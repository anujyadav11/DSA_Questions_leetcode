/*********************************************** JAVA **************************************************/

// Optimal Solution - DP with hash maps to count the number of ways to assign + and - signs to reach a target sum. Each number doubles the choices (+ or −), and DP maps help aggregate how many ways each sum can be formed efficiently.
/* “I use a HashMap where each key is a reachable sum and its value is the number of ways to produce that sum. Initially, sum zero has one way. For every number, 
    each existing sum branches into two new sums by adding or subtracting the current number. If multiple paths reach the same sum, I accumulate their counts. 
    After processing all numbers, the count associated with the target is the answer.” */

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        // dp: sum -> number of ways to create that sum
        Map<Integer, Integer> dp = new HashMap<>();
        // Before using any number, sum 0 can be formed in one way
        dp.put(0, 1);
        for (int num : nums) {
            Map<Integer, Integer> nextDp = new HashMap<>();
            // Try both +num and -num for every existing sum
            for (int sum : dp.keySet()) {
                int count = dp.get(sum);
                // Assign '+' sign to current number
                nextDp.put(
                    sum + num,
                    nextDp.getOrDefault(sum + num, 0) + count
                );
                // Assign '-' sign to current number
                nextDp.put(
                    sum - num,
                    nextDp.getOrDefault(sum - num, 0) + count
                );
            }
            // Move to the next DP state
            dp = nextDp;
        }
        // Number of ways to reach target
        return dp.getOrDefault(target, 0);
    }
}
//Time Complexity :- O(n * s). s is totalsum;
// Space Complexity :- O(s).

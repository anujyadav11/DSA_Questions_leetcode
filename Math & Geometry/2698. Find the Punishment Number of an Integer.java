/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds punishment number by checking if each i²'s decimal string can be partitioned into substrings summing to i using memoized backtracking.
/* "Always verify method signatures match at every call site — missing arguments compile-fail immediately. The memoization state (position, currentSum) 
    is compact since curSum ≤ i bounds the second dimension. Pruning curSum > target early cuts branches significantly for large squared values." */

class Solution {
    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            // square of current number as string
            String squared = Integer.toString(i * i);
            int len = squared.length();
            // dp[j][curSum] = -1 unvisited, 0 false, 1 true
            int[][] dp = new int[len][i + 1];
            for (int[] row : dp)
                Arrays.fill(row, -1);
            // pass dp to isPartition
            if (isPartition(0, squared, i, 0, dp))
                res += (i * i);
        }
        return res;
    }
    public boolean isPartition(int j, String s, int target, int curSum, int[][] dp) {
        int n = s.length();
        // base case: used all digits — check if sum equals target
        if (j == n)
            return curSum == target;
        // pruning — current sum already exceeds target
        if (curSum > target)
            return false;
        // return cached result
        if (dp[j][curSum] != -1)
            return dp[j][curSum] == 1;
        // try all substrings starting at j
        for (int idx = j; idx < n; idx++) {
            int val = Integer.parseInt(s.substring(j, idx + 1));
            if (isPartition(idx + 1, s, target, curSum + val, dp)) {
                dp[j][curSum] = 1;
                return true;
            }
        }
        dp[j][curSum] = 0;
        return false;
    }
}

// Time Complexity :- O(n * L ^ 2 * i).— n numbers, L = digits in i², memoized states L × i
// Space Complexity :- O(L * i).— DP table per number

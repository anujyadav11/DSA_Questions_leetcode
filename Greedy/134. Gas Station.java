/*********************************************** JAVA **************************************************/

// Optimal Solution - Greedy solution that resets the starting station whenever the gas balance becomes negative, ensuring a linear-time solution. If I can’t reach station i + 1 from my current start, then none of the stations before i can be a valid start either.
/* “First, I check whether the total gas is less than the total cost. If it is, completing the circuit is impossible. Otherwise, I greedily maintain the current gas balance. Whenever the balance becomes negative at station i, 
    the current starting point and every station between it and i cannot be a valid start, so I set the next station i + 1 as the new start. Since the total balance is non-negative, this final candidate is guaranteed to complete the circuit.” */

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Check whether total gas is enough to cover total cost
        int totalGas = 0, totalCost = 0;
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        // Impossible to complete the circuit
        if (totalGas < totalCost) {
            return -1;
        }
        int currGas = 0;
        int startIdx = 0;
        for (int i = 0; i < n; i++) {
            // Gas gained/lost at current station
            currGas += gas[i] - cost[i];
            // Current start cannot reach the next station
            if (currGas < 0) {
                startIdx = i + 1;
                currGas = 0;
            }
        }
        return startIdx;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

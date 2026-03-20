/*********************************************** JAVA **************************************************/

// Optimal Solution - Simulates drinking and exchanging empty bottles greedily until no more exchanges are possible.
/* "The closed-form formula works for valid constraints but simulation is safer, clearer, and more defensible in interviews. 
    Always prefer readable correctness over clever math unless O(1) is explicitly required." */

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalDrunk = numBottles; // start by drinking all full bottles
        int emptyBottles = numBottles; // collect all empties
        while (emptyBottles >= numExchange) { // can we exchange?
            int newBottles = emptyBottles / numExchange; // bottles received
            totalDrunk += newBottles; // drink the new ones
            emptyBottles = emptyBottles % numExchange // leftover empties
                    + newBottles; // + empties from new bottles
        }
        return totalDrunk; // total bottles drunk
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

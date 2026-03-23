/*********************************************** JAVA **************************************************/

// Optimal Solution - Simulates a single-chef kitchen greedily tracking finish times to compute average customer waiting time in O(n).
/* "This is a classic queue simulation — the key variable is idleTime which acts as the chef's availability clock. If the chef is free, reset it to arrival + cookTime; if busy, 
    just extend by cookTime. Waiting time per customer is always finishTime - arrivalTime." */

class Solution {
    public double averageWaitingTime(int[][] customers) {
        // tracks when the chef becomes free (initialized to time 1 = start)
        int idleTime = 1;
        // accumulates total waiting time across all customers
        long totalWaiting = 0;
        for (int[] customer : customers) {
            // chef is free before or exactly when customer arrives
            if (idleTime <= customer[0])
                // chef starts immediately at arrival, finishes at arrival + cookTime
                idleTime = customer[0] + customer[1];
            else
                // chef is busy, customer waits → finish time extends by cookTime
                idleTime += customer[1];
            // waiting time = finish time - arrival time
            totalWaiting += (idleTime - customer[0]);
        }
        // divide total wait by number of customers for average
        return totalWaiting / (double) customers.length;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Calculate ticket purchase time by counting how many times each person is served before person k finishes.
                      // “Instead of simulating the queue, I count how many times each person gets served relative to when person k finishes buying tickets.”

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0; // Total time required
        int n = tickets.length; // Number of people in queue
        // Traverse all people in the queue
        for (int i = 0; i < n; i++) {
            // If the person is before or exactly at index k
            if (i <= k) {
                // They will get served at most tickets[k] times
                time += Math.min(tickets[i], tickets[k]);
            } else {
                // People after k will only get tickets[k] - 1 chances
                // because once k finishes, the process stops
                time += Math.min(tickets[k] - 1, tickets[i]);
            }
        }
        return time;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

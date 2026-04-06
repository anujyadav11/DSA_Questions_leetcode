/*********************************************** JAVA **************************************************/

// Optimal Solution - Maximizes satisfied customers by finding the sliding window of given size with most grumpy-customer converts, adding them to the always-satisfied baseline.
/* "Split into two parts — base satisfaction from non-grumpy owners is fixed, and the sliding window finds the best minutes-length stretch to neutralize grumpy owners. 
    customers[i] * grumpy[i] elegantly captures only grumpy-owner customers in one expression. Watch for variable redeclaration in the second loop — use a fresh variable name." */

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int currUnSat = 0;
        // compute unsatisfied customers in first window of size 'minutes'
        for (int i = 0; i < minutes; i++)
            currUnSat += customers[i] * grumpy[i];
        // FIXED: maxUnsat starts as first window sum, not currUnSat=0
        int maxUnSat = currUnSat;
        int i = 0;
        int j = minutes;
        // slide window across remaining array
        while (j < n) {
            // add incoming element — only counts if owner is grumpy
            currUnSat += customers[j] * grumpy[j];
            // remove outgoing element
            currUnSat -= customers[i] * grumpy[i];
            maxUnSat = Math.max(maxUnSat, currUnSat);
            i++;
            j++;
        }
        // FIXED: use different variable name to avoid redeclaration conflict
        int totalSat = maxUnSat;
        for (int k = 0; k < n; k++)
            // always-satisfied customers (grumpy[k] == 0)
            totalSat += customers[k] * (1 - grumpy[k]);
        // return base satisfaction + best window of converted unsatisfied customers
        return totalSat;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Simulates a tournament bracket round-by-round, accumulating matches played until one team remains.
/*  "The O(log n) simulation works, but the real insight is that every match eliminates exactly one team — so the answer is simply n - 1, 
      achievable in O(1). Mentioning both shows depth." */

class Solution {
    public int numberOfMatches(int n) {
        int matches = 0;
        while (n > 1) { // keep playing rounds until 1 team remains
            if (n % 2 == 0) { // even number of teams
                matches += n / 2; // n/2 matches played this round
                n = n / 2; // n/2 winners advance
            } else { // odd number of teams
                matches += (n - 1) / 2; // (n-1)/2 matches played this round
                n = (n - 1) / 2 + 1; // (n-1)/2 winners + 1 bye team advance
            }
        }
        return matches; // total matches played across all rounds
    }
}
// Or you could just return n - 1.

// Time Complexity :- O(n).
// Space Complexity :- O(1).

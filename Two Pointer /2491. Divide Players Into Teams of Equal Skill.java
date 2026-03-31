/*********************************************** JAVA **************************************************/

// Optimal Solution - Pairs players by sorting and matching smallest with largest skill, returning total chemistry as sum of products if all pairs share equal skill sum.
/* "Sorting enforces the only valid greedy pairing — smallest must pair with largest to balance team skills. The equal-sum check catches any invalid configuration in O(1) per pair. 
    Always cast to long before multiplying skill values — int overflow is a common silent bug when computing products." */

class Solution {
    public long dividePlayers(int[] skill) {
        // sort so smallest and largest can be paired with two pointers
        Arrays.sort(skill);
        int n = skill.length;
        // target sum every pair must equal (smallest + largest)
        int totalSkill = skill[0] + skill[n - 1];
        long chemistrySum = 0;
        for (int i = 0; i < n / 2; i++) {
            // all pairs must have equal sum — otherwise no valid division
            if (skill[i] + skill[n - i - 1] != totalSkill)
                return -1;
            // accumulate chemistry (product) of each valid pair
            chemistrySum += (long) skill[i] * skill[n - i - 1];
        }
        // return total chemistry across all pairs
        return chemistrySum;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(1).

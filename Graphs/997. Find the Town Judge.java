/*********************************************** JAVA **************************************************/

// Optimal Solution - Use indegree−outdegree counting to identify the town judge in linear time.
/* "The judge must be trusted by everyone else and trust nobody. So I maintain a trust score where incoming trust increments and outgoing trust decrements. The judge will have score n−1." */

class Solution {
    public int findJudge(int n, int[][] trust) {
        // Array to store trust score for each person
        int[] trustScore = new int[n + 1];
        // Traverse all trust relationships
        for (int[] relation : trust) {
            int truster = relation[0]; // Person who trusts someone
            int trusted = relation[1]; // Person who is trusted
            // If someone trusts another person, decrease their score
            trustScore[truster]--;
            // If another person trusts someone, increase their score
            trustScore[trusted]++;
        }
        // The town judge should have trustScore = n - 1
        for (int person = 1; person <= n; person++) {
            if (trustScore[person] == n - 1) {
                return person;
            }
        }
        // If no judge exists
        return -1;
    }
}

// Time Complexity :- O(n + m). n = number of people m = trust relationships
// Space Complexity :- O(n).

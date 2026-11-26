/*********************************************** JAVA **************************************************/

// Optimal Solution - Implemented directed graph degree tracking using a single array to identify the judge in O(n + m) time and O(n) auxiliary space.
/* "I model the trust relationships as a directed graph. Instead of building an adjacency list, I maintain a degree array. Whenever a person trusts someone, 
    I decrement their degree, and whenever someone is trusted, I increment their degree. The town judge must have an in-degree of n minus one and an out-degree of zero, 
    so their net degree must equal n minus one. I return the person satisfying this condition." */

class Solution {
    public int findJudge(int n, int[][] trust) {
        // Get the total number of trust relationships.
        int len = trust.length;
        // The judge must be trusted by all other n - 1 people.
        // Therefore, at least n - 1 trust relationships are required.
        if (len < n - 1) {
            return -1;
        }
        // Tracks the trust degree of every person.
        //
        // Negative value = number of people they trust (outgoing edges).
        // Positive value = number of people who trust them (incoming edges).
        int[] degree = new int[n + 1];
        // Process every trust relationship.
        for (int i = 0; i < len; i++) {
            // Person trust[i][0] trusts someone.
            // Decrease their degree because they have an outgoing edge.
            degree[trust[i][0]]--;
            // Person trust[i][1] is trusted by someone.
            // Increase their degree because they have an incoming edge.
            degree[trust[i][1]]++;
        }
        // Check every person from 1 to n.
        for (int i = 1; i <= n; i++) {
            // A judge must:
            // 1. Trust nobody (out-degree = 0).
            // 2. Be trusted by everyone else (in-degree = n - 1).
            //
            // Therefore, their net degree must equal n - 1.
            if (degree[i] == n - 1) {
                return i;
            }
        }
        // No person satisfies the town judge conditions.
        return -1;
    }
}

// Time Complexity :- O(n + m).
// Space Complexity :- O(n).

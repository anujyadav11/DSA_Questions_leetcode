/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds the unique tournament champion by identifying the single node with in-degree zero, returning -1 if no unique unbeaten team exists.
/* "In-degree zero means never beaten — exactly what a champion requires. The uniqueness check is critical: multiple zero in-degree nodes means no definitive winner exists. 
    This reduces a potentially complex graph traversal to a simple edge scan and linear pass — O(e+n) total." */

class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] inDegree = new int[n];
        // count incoming edges for each node
        for (int[] edge : edges)
            inDegree[edge[1]]++;
            
        int champ = -1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            // champion must have in-degree 0 — unbeaten by any other team
            if (inDegree[i] == 0) {
                champ = i;
                count++;
                // more than one unbeaten team — no unique champion
                if (count > 1)
                    return -1;
            }
        }
        // return unique champion or -1 if none found
        return champ;
    }
}

// Time Complexity :- O(e + n). e is the Edge of indgree in the array.
// Space Complexity :- O(n).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Maximizes road importance by greedily assigning highest labels to highest-degree cities, sorting degree counts and multiplying by ascending label values.
/* "This is a classic greedy — city importance is weighted by how many roads it appears in (degree). Assigning label n to the highest degree city maximizes its contribution across all its roads. 
    Sorting degrees and multiplying by position directly implements this without needing to track which city gets which label." */

class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long[] degree = new long[n];
        // count degree (connections) of each city
        for (int[] edge : roads) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        // sort ascending — assign higher labels to higher degree cities
        Arrays.sort(degree);
        long res = 0;
        long label = 1;
        // assign labels 1 to n in ascending order of degree
        for (int i = 0; i < n; i++) {
            res += degree[i] * label;
            label++;
        }
        return res;
    }
}

// Time Complexity :- O(E + n log n).
// Space Complexity :- O(n).

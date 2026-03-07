/*********************************************** JAVA **************************************************/

// Optimal Solution - Greedily assign the smallest sufficient cookie to the least greedy child after sorting both arrays.
                    //“I sort children and cookies, then greedily match the smallest cookie that satisfies the current child using two pointers.”

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Sort children's greed factors
        Arrays.sort(g);
        // Sort cookie sizes
        Arrays.sort(s);
        int i = 0;  // Pointer for children (content children count)
        // Traverse cookies
        for (int j = 0; i < g.length && j < s.length; j++) {
            // If the current cookie can satisfy the current child
            if (g[i] <= s[j]) {
                i++;   // Move to next child
            }
        }
        // i represents the number of content children
        return i;
    }
}

// Time Complexity :- O(n log n + m log m).
// Space Complexity :- O(1).

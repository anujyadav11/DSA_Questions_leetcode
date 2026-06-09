/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds maximum Russian doll envelopes using sort-by-width-then-LIS-on-heights with patience sorting for O(n log n) complexity.
/* "This is 2D LIS — sort one dimension, find LIS on the other. The descending height trick for equal widths is the key insight — 
    it prevents the LIS algorithm from treating same-width envelopes as nestable. Patience sorting with binary search achieves O(n log n) vs O(n²) naive DP." */

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // sort by width ascending, break ties by height descending
        // descending height prevents using multiple same-width envelopes
        Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        // find LIS on heights only — width constraint already handled by sort
        int[] tails = new int[envelopes.length];
        int size = 0;
        for (int[] env : envelopes) {
            int h = env[1];
            // binary search for leftmost tail >= h
            int left = 0, right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < h)
                    left = mid + 1;
                else
                    right = mid;
            }
            // replace or extend tails array
            tails[left] = h;
            if (left == size)
                size++;
        }
        return size;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(n).

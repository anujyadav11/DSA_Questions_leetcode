/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds the maximum width vertical area by sorting points on x-axis and scanning for the largest gap between consecutive x-coordinates.
/* "The y-coordinates are completely irrelevant — vertical areas only depend on x. After sorting by x, the answer is just the max difference between adjacent values, 
    reducing a geometry problem to a simple linear scan." */

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        // get total number of points
        int n = points.length;
        // sort points by x-coordinate only (y is irrelevant for vertical areas)
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        // track maximum gap between consecutive x-coordinates
        int res = 0;
        for (int i = 1; i < n; i++) {
            // compute horizontal gap between adjacent sorted x-values
            int width = points[i][0] - points[i - 1][0];
            // update result if current gap is larger
            res = Math.max(res, width);
        }
        // return the maximum width found
        return res;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(1).

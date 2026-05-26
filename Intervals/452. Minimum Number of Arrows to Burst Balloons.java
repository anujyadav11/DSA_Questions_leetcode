/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds minimum arrows to burst all balloons by sorting by end coordinate and greedily shooting at each earliest unpopped balloon's end point.
/*  "Sorting by end point is the greedy key — shooting at the earliest end maximizes balloons popped per arrow. Always use Integer.compare not subtraction in comparators 
    — subtraction overflows for large negatives like Integer.MIN_VALUE - 1. The n==1 early return is redundant — the loop handles it correctly." */

class Solution {
    public int findMinArrowShots(int[][] points) {
        // sort by end point — greedy shoots arrow at earliest end
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrows = 1;
        // shoot first arrow at end of first balloon
        int commonEndPoint = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int curStart = points[i][0];
            int curEnd = points[i][1];
            if (curStart > commonEndPoint) {
                // current balloon starts after last arrow — need new arrow
                commonEndPoint = curEnd;
                arrows++;
            }
            // else current balloon overlaps — same arrow covers it
        }
        return arrows;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(1).

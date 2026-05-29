/*********************************************** JAVA **************************************************/

// Optimal Solution - Checks if rectangles can be divided into 3 sections by counting interval gaps along x or y axis after sorting by start coordinate.
/* "This is the merge intervals gap-counting pattern — sort by start, track running max end, count positions where next interval starts after current merged end. 
    Two gaps create three groups. Using index arithmetic i and i+2 elegantly handles both x-axis (0,2) and y-axis (1,3) with the same function — clean generalization." */

class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        // check if valid cuts exist along x-axis or y-axis
        return check(rectangles, 0) || check(rectangles, 1);
    }
    private boolean check(int[][] rect, int i) {
        int gaps = 0;
        // sort by start coordinate along axis i
        Arrays.sort(rect, (a, b) -> Integer.compare(a[i], b[i]));
        // track furthest end coordinate seen so far
        int pre = rect[0][i + 2];
        for (int[] r : rect) {
            // gap found — current rectangle starts after previous group ends
            if (pre <= r[i])
                gaps++;
            // extend the current merged interval's end
            pre = Math.max(pre, r[i + 2]);
        }
        // need at least 2 gaps to create 3 sections
        return gaps > 1;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(1).

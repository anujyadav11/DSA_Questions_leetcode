/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds all interval intersections using two pointers, computing overlap as [max(starts), min(ends)] and advancing the pointer with the smaller endpoint.
/* "The pointer advancement rule is the key insight — advance whichever interval ends first since it can't overlap with anything remaining in the other list. 
    lo <= hi is the clean intersection validity check — when lo > hi the intervals are disjoint. This two-pointer approach is O(n+m) vs O(n×m) brute force." */

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            // intersection start is max of both starts
            int lo = Math.max(firstList[i][0], secondList[j][0]);
            // intersection end is min of both ends
            int hi = Math.min(firstList[i][1], secondList[j][1]);
            // valid intersection exists when lo <= hi
            if (lo <= hi)
                res.add(new int[]{lo, hi});
            // advance pointer with smaller end — it cannot intersect any further
            if (firstList[i][1] < secondList[j][1])
                i++;
            else
                j++;
        }
        return res.toArray(new int[res.size()][]);
    }
}

// Time Complexity :- O(m + n).
// Space Complexity :- O(min(n ,m)).

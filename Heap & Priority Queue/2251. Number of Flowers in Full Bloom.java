/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts blooming flowers per person using binary search on sorted start/end arrays, computing active count as flowers-started minus flowers-ended at each query time.
/* "The end+1 offset is key — it converts inclusive end times to exclusive, making 'flowers that have died by time t' equivalent to 'end+1 <= t'. This lets both start and end use the same upper bound binary search. 
    Separating start and end into independent sorted arrays is cleaner than a combined event array and avoids tie-breaking complexity." */

class Solution {
    // returns index of first element strictly greater than target
    public int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int m = flowers.length;
        int n = people.length;
        // extract and sort bloom start times
        int[] start = new int[m];
        // store end+1 to convert inclusive end to exclusive for upper bound check
        int[] end = new int[m];
        for (int i = 0; i < m; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1] + 1;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            // flowers that started blooming at or before people[i]
            int bloomed = upperBound(start, people[i]);
            // flowers that ended blooming before people[i]
            int died = upperBound(end, people[i]);
            // active flowers = started - already ended
            ans[i] = bloomed - died;
        }
        return ans;
    }
}

// Time Complexity :- O((n * m) log m).
// Space Complexity :- O(m).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds shortest subarray removal to make array non-decreasing using two pointers — extending valid prefix while advancing suffix to find optimal merge points.
/* "The key insight is that we keep a prefix and suffix — remove everything between them. Find the longest valid suffix first, 
    then greedily extend the prefix while advancing the suffix pointer to maintain the non-decreasing merge condition. Both pointers only move forward giving O(n) total — a classic two-pointer monotonic scan." */

class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        // find rightmost start of non-decreasing suffix
        int j = n - 1;
        while (j > 0 && arr[j] >= arr[j - 1])
            j--;
        // entire array is non-decreasing — remove nothing
        if (j == 0) return 0;
        // worst case: remove everything except the suffix starting at j
        int res = j;
        // try keeping prefix arr[0..i] and suffix arr[j..n-1]
        int i = 0;
        while (i < j && (i == 0 || arr[i] >= arr[i - 1])) {
            // advance j until arr[j] >= arr[i] — valid merge point
            while (j < n && arr[i] > arr[j])
                j++;
            // subarray to remove is arr[i+1..j-1] — length j-i-1
            res = Math.min(res, j - i - 1);
            i++;
        }
        return res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

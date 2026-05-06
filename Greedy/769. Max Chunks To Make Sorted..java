/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts maximum chunks for sorting by finding positions where running maximum equals current index, indicating a self-contained sortable partition.
/*  "The invariant is simple — if max(arr[0..i]) == i, then all values {0,1,...,i} must be present in arr[0..i] since max is i and all values are distinct non-negatives. 
    This means sorting this chunk independently gives the correct sorted prefix. Count such boundary points for the answer." */

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int max = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            // track maximum value seen so far
            max = Math.max(max, arr[i]);
            // valid chunk boundary: all values 0..i are contained in arr[0..i]
            if (max == i) {
                count++;
            }
        }
        return count;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

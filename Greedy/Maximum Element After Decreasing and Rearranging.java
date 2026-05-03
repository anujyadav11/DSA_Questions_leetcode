/*********************************************** JAVA **************************************************/

// Optimal Solution - Maximizes final array element by sorting, fixing first element to 1, and capping each element to at most one more than its predecessor.
/* "The greedy insight is that we want each element as large as possible — so only cap downward when arr[i] > arr[i-1] + 1, never reduce an element that already satisfies the constraint. 
    Math.abs was the key bug — it would also cap elements that are equal to previous, unnecessarily reducing valid values. The answer is always arr[n-1] after adjustment." */

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        // sort to process elements in ascending order
        Arrays.sort(arr);
        // first element must be 1
        arr[0] = 1;
        for (int i = 1; i < n; i++) {
            // each element can differ by at most 1 from previous
            if (arr[i] > arr[i - 1] + 1)
                arr[i] = arr[i - 1] + 1;
            // if arr[i] <= arr[i-1] + 1 already — keep it as is
        }
        // maximum is always the last element after sorting and adjusting
        return arr[n - 1];
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(1).

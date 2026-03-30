/*********************************************** JAVA **************************************************/

// Optimal Solution - Partitions an array around a pivot in O(n) using simultaneous forward/backward two-pointer scans, preserving relative order of elements on both sides.
/*  "The elegant insight is running two pointers simultaneously in one loop — i forward for elements less than pivot maintaining left-to-right order, j backward for elements greater than pivot maintaining right-to-left order which correctly preserves their relative sequence. 
    The middle gap after the loop is precisely the count of pivot elements." */

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        // left fills from front for elements < pivot
        // right fills from back for elements > pivot
        int left = 0, right = nums.length - 1;
        // i scans forward for < pivot, j scans backward for > pivot simultaneously
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            // place elements smaller than pivot at the front in order
            if (nums[i] < pivot)
                result[left++] = nums[i];
            // place elements greater than pivot at the back in reverse order
            if (nums[j] > pivot)
                result[right--] = nums[j];
        }
        // fill remaining middle positions with pivot value
        while (left <= right)
            result[left++] = pivot;
            
        return result;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Merge two sorted arrays in-place using three pointers in O(m + n) time and O(1) extra space.
/* “Since both arrays are sorted and nums1 has enough space, I use three pointers starting from the ends of both arrays and the destination array. 
  I place the larger element at the destination pointer and move backward, ensuring no unprocessed elements are overwritten.” */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;       // Last valid element in nums1
        int j = n - 1;       // Last element in nums2
        int k = m + n - 1;   // Last position in nums1
        // Fill nums1 from the end to avoid overwriting valid elements.
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }
}

// Time Complexity :- O(m + n).
// Space Complexity :- O(1).

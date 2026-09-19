/*********************************************** JAVA **************************************************/

// Optimal Solution - Binary search partition approach to find median of two sorted arrays in logarithmic time. Always binary search the smaller array to guarantee valid partition bounds and achieve O(log(min(n,m))) time.
/* “I use binary search on the smaller array to find a partition where the combined left half contains exactly half of the elements. If Px elements come from the first array, 
    then Py = (m+n+1)/2 - Px elements must come from the second array. A partition is valid when the largest elements on the left are less than or equal to the smallest elements on the right. 
    If nums1[Px-1] > nums2[Py], I move the partition left; otherwise, I move it right. Once the correct partition is found, the median comes directly from the boundary elements.” */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // Binary search on the smaller array
        if (m > n)
            return findMedianSortedArrays(nums2, nums1);
        int l = 0;
        int r = m;
        while (l <= r) {
            // Partition nums1
            int Px = l + (r - l) / 2;
            // Total number of elements that should be on the left
            int totalLeft = (m + n + 1) / 2;
            // Remaining elements needed from nums2
            int Py = totalLeft - Px;
            // Elements immediately to the left of the partitions
            int x1 = (Px == 0) ? Integer.MIN_VALUE : nums1[Px - 1];
            int x2 = (Py == 0) ? Integer.MIN_VALUE : nums2[Py - 1];
            // Elements immediately to the right of the partitions
            int x3 = (Px == m) ? Integer.MAX_VALUE : nums1[Px];
            int x4 = (Py == n) ? Integer.MAX_VALUE : nums2[Py];
            // Correct partition
            if (x1 <= x4 && x2 <= x3) {
                // Odd total length
                if ((m + n) % 2 == 1) {
                    return Math.max(x1, x2);
                }
                // Even total length
                return (Math.max(x1, x2) + Math.min(x3, x4)) / 2.0;
            }
            // Too many elements taken from nums1
            if (x1 > x4) {
                r = Px - 1;
            } else {
                // Need to take more elements from nums1
                l = Px + 1;
            }
        }
        return -1;
    }
}

// Time Complexity :-  O(log(min(m, n)))
// Space Complexity :- O(1).

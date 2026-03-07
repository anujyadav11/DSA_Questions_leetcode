/*********************************************** JAVA **************************************************/

// Optimal Solution - Merge two sorted id-value arrays using a two-pointer technique and sum values for matching ids.
                      // “Since both arrays are sorted by id, I use a merge-style two-pointer approach similar to merge sort.”

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m = nums1.length;   // Length of nums1
        int n = nums2.length;   // Length of nums2
        int i = 0, j = 0;       // Two pointers for nums1 and nums2
        // List to store merged result
        List<int[]> result = new ArrayList<>();
        // Traverse both arrays
        while (i < m && j < n) {
            // If id in nums1 is smaller
            if (nums1[i][0] < nums2[j][0]) {
                result.add(nums1[i]);   // Add nums1 pair
                i++;
            } 
            // If id in nums2 is smaller
            else if (nums2[j][0] < nums1[i][0]) {
                result.add(nums2[j]);   // Add nums2 pair
                j++;
            } 
            // If both ids are equal
            else {
                // Sum the values
                result.add(new int[] { nums1[i][0], nums1[i][1] + nums2[j][1] });
                i++;
                j++;
            }
        }
        // Add remaining elements from nums1
        while (i < m) {
            result.add(nums1[i]);
            i++;
        }
        // Add remaining elements from nums2
        while (j < n) {
            result.add(nums2[j]);
            j++;
        }
        // Convert list to 2D array
        return result.toArray(new int[0][]);
    }
}

// Time Complexity :- O(m + n).
// Space Complexity :- O(m + n).

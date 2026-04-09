/*********************************************** JAVA **************************************************/

// Optimal Solution - Use sliding window to count subarrays where the maximum element appears at least k times by leveraging a counting shortcut.
/* “Once a window has k occurrences of the maximum element, all extensions of that window are valid, so I add (n - end) and shrink the window.” */

class Solution {
    public long countSubarrays(int[] nums, int k) {
        // Find the maximum element in the array
        int maxElement = Arrays.stream(nums).max().getAsInt();
        int n = nums.length;
        int start = 0; // Left pointer of sliding window
        int end = 0; // Right pointer of sliding window
        long count = 0; // Total valid subarrays
        int freqCount = 0; // Count of maxElement in current window
        // Expand window using 'end'
        while (end < n) {
            // If current element is maxElement, increase its count
            if (nums[end] == maxElement) {
                freqCount++;
            }
            // While window contains at least k occurrences of maxElement
            while (freqCount == k) {
                // All subarrays starting from 'start' to any index ≥ end are valid
                count += (n - end);
                // Shrink window from left
                if (nums[start] == maxElement) {
                    freqCount--;
                }
                start++;
            }
            end++; // Expand window
        }
        return count;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

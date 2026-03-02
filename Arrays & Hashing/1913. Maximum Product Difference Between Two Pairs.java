/*********************************************** JAVA **************************************************/

// Optimal Solution - Track two largest and two smallest elements in one pass to compute maximum product difference in O(n) time.

class Solution {
    public int maxProductDifference(int[] nums) {
        int max1 = 0, max2 = 0;          // Two largest numbers
        int min1 = Integer.MAX_VALUE;    // Smallest number
        int min2 = Integer.MAX_VALUE;    // Second smallest number
        // Single traversal
        for (int num : nums) {
            // Update largest two
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } 
            else if (num > max2) {
                max2 = num;
            }
            // Update smallest two
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } 
            else if (num < min2) {
                min2 = num;
            }
        }
        // Return required difference
        return (max1 * max2) - (min1 * min2);
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

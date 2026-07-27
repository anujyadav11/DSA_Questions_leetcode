/*********************************************** JAVA **************************************************/

// Optimal Solution - Solved the Container With Most Water problem using the two-pointer technique to maximize the contained water in O(n) time and O(1) space.
/* "The brute-force solution checks every pair of lines, resulting in O(n²) time. The optimized approach uses two pointers because the area depends on the shorter line. 
    At each step, we calculate the current area and move the pointer at the shorter line, as only that move can potentially increase the height while the width decreases. 
    This guarantees finding the maximum area in linear time." */

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        // Start with pointers at both ends of the array
        int left = 0;
        int right = n - 1;
        int maxWater = 0;
        while (left < right) {
            // Width is the distance between the two lines
            int width = right - left;
            // Height is limited by the shorter line
            int currentHeight = Math.min(height[left], height[right]);
            // Calculate the water that can be contained
            int area = width * currentHeight;
            // Update the maximum area found so far
            maxWater = Math.max(maxWater, area);
            // Move the pointer pointing to the shorter line
            // since moving the taller line cannot increase the area
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxWater;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

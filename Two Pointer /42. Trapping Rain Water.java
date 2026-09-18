/*********************************************** JAVA **************************************************/

// Optimal Solution - Uses prefix and suffix maximum arrays to compute trapped rainwater in linear time. At each index, trapped water equals min(max left, max right) minus height—precompute both in linear time.
/* “For each index, the amount of trapped water depends on the maximum wall to its left and the maximum wall to its right. I precompute these values using leftMax and rightMax arrays. 
    The water at each position is the minimum of those two boundaries minus the current height. I sum this for every position to get the total trapped water.” */

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        // Store maximum height from the left up to each index
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        // Store maximum height from the right up to each index
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int totalWater = 0;
        // Water at each index depends on the smaller boundary
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return totalWater;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

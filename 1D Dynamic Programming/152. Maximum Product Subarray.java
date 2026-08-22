/*********************************************** JAVA **************************************************/

// Optimal Solution - Compute the maximum product subarray by scanning from both directions and resetting products on zeros. Negative numbers can flip signs, so scanning from both left and right ensures we don’t miss the maximum product.

class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 0;
        int sufix = 0;
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;
        // Traverse from both directions
        for (int i = 0; i < n; i++) {
            // Reset product after encountering zero
            if (prefix == 0)
                prefix = 1;
            if (sufix == 0)
                sufix = 1;
            prefix *= nums[i];
            sufix *= nums[n - i - 1];
            // Keep the maximum product found so far
            maxProd = Math.max(maxProd,Math.max(prefix, sufix));
        }
        return maxProd;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

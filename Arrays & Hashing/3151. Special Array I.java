/*********************************************** JAVA **************************************************/

// Optimal Solution - Check whether every adjacent pair in the array has alternating parity using a single linear scan.
                      //“I just compare parity of adjacent elements. If any two consecutive elements have the same parity, the array is not special.”

class Solution {
    public boolean isArraySpecial(int[] nums) {
        // If array has 0 or 1 element, it is automatically special
        if (nums.length <= 1) {
            return true;
        }
        // Traverse till second last element
        for (int i = 0; i < nums.length - 1; i++) {
            // Check if current and next element have same parity
            // (both even or both odd)
            if (nums[i] % 2 == nums[i + 1] % 2) {
                return false;   // Not special
            }
        }        
        // If no same-parity adjacent elements found
        return true;
    }
}

// Time Complexity :- O().
// Space Complexity :- O().

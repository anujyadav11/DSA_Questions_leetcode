/*********************************************** JAVA **************************************************/

// Optimal Solution - Creates the concatenation of an array by copying its elements twice into a result array in O(n) time.
/* “I create a result array of size 2n and copy the original array into it twice. I maintain an index pointer to place each element sequentially. 
    This takes linear time and uses linear space for the required output.” */

class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        // Result needs to contain nums twice.
        int[] res = new int[2 * n];
        // Tracks the next position in the result array.
        int idx = 0;
        // Repeat the array twice.
        for (int i = 0; i < 2; i++) {
            // Copy every element of nums into res.
            for (int num : nums) {
                res[idx++] = num;
            }
        }
        return res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

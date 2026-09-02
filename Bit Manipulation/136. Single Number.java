/*********************************************** JAVA **************************************************/

// Optimal Solution - Bit manipulation solution using XOR to find the single non-duplicate element in linear time. XOR eliminates duplicates automatically, so the remaining value after one pass is the unique number.
/* “Since every duplicate appears exactly twice, XOR cancels each pair because x ^ x = 0, while the unique number remains because 0 ^ x = x.” */

class Solution {
    public int singleNumber(int[] nums) {
        // XOR cancels numbers appearing twice
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

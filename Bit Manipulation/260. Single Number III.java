/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds two unique numbers in a duplicate-heavy array by XOR-partitioning on the rightmost differing bit between the two unique values.
/*  "xored & (-xored) is the standard rightmost set bit trick — -xored in two's complement flips all bits and adds 1, so AND with original isolates the lowest set bit. 
    This replaces a fragile loop and is a must-know bit manipulation pattern. The two buckets work because duplicates XOR to 0 within each partition." */

class Solution {
    public int[] singleNumber(int[] nums) {
        // XOR all numbers — result is XOR of the two unique numbers
        int xored = 0;
        for (int num : nums)
            xored ^= num;
        // find rightmost set bit — differentiates the two unique numbers
        int diffBit = xored & (-xored);
        int setBucket = 0;
        int unsetBucket = 0;
        for (int num : nums) {
            if ((num & diffBit) != 0)
                // numbers with this bit set — one unique number is here
                setBucket ^= num;
            else
                // numbers without this bit — other unique number is here
                unsetBucket ^= num;
        }
        return new int[] { setBucket, unsetBucket };
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

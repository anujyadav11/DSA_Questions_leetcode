/*********************************************** JAVA **************************************************/

// Optimal Solution - Answers maximum XOR queries by greedily complementing the running prefix XOR within maximumBit bits, removing elements right-to-left between queries.
/* "The optimal k is always xor ^ mask — flipping all bits within maximumBit range makes every bit 1, giving the maximum possible value 2^maximumBit - 1. 
    Removing elements by XOR-ing them back out is the key trick — XOR is self-inverse so xor ^ nums[last] removes the last element cleanly without storing prefix arrays." */

class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] res = new int[n];
        // compute XOR of all elements
        int xor = 0;
        for (int num : nums)
            xor ^= num;
        // mask of maximumBit ones — e.g. maximumBit=3 gives 111 = 7
        int mask = (1 << maximumBit) - 1;
        for (int i = 0; i < n; i++) {
            // best k to maximize xor^k is complement of xor within maximumBit bits
            res[i] = xor ^ mask;
            // remove last element for next query (process right to left)
            xor ^= nums[n - i - 1];
        }
        return res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Computes XOR of all pairs product array by leveraging frequency parity — only XORing arrays whose elements appear an odd number of times.
/* "The key insight is counting appearances — nums1[i] appears exactly m times in the product array. XOR cancels even occurrences, so only odd-frequency elements matter. 
    This avoids generating the O(n×m) product array entirely, reducing to O(n+m) time and O(1) space. Always look for frequency patterns when XOR problems involve repeated elements." */

class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int res = 0;
        // each element of nums2 appears n times in the product array
        // if n is odd — nums2 elements contribute to XOR (odd occurrences)
        if (n % 2 != 0)
            for (int num : nums2)
                res ^= num;
        // each element of nums1 appears m times in the product array
        // if m is odd — nums1 elements contribute to XOR (odd occurrences)
        if (m % 2 != 0)
            for (int num : nums1)
                res ^= num;
        return res;
    }
}

// Time Complexity :- O(n+m).
// Space Complexity :- O(1).

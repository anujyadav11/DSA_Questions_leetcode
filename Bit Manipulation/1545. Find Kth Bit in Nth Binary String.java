/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds kth bit in nth binary string recursively by splitting into three regions — first half recurses directly, middle returns '1', second half inverts the mirrored first-half position.
/*  "The key is recognizing the three regions — first half is a direct copy, middle is always '1', second half is inverted reverse. The mirror formula length - k + 1 maps any second-half position to its first-half equivalent. 
      Each recursive call reduces n by 1 giving O(n) depth — no exponential blowup despite the string doubling each level." */

class Solution {
    public char findKthBit(int n, int k) {
        // base case: S1 = "0"
        if (n == 1) return '0';
        // length of Sn = 2^n - 1
        int length = (1 << n) - 1;
        // middle index of current string
        int mid = length / 2 + 1;
        if (k < mid)
            // first half — identical to S(n-1)
            return findKthBit(n - 1, k);
        else if (k == mid)
            // middle bit — always '1' by definition
            return '1';
        else
            // second half — reverse mirror of first half, inverted
            return findKthBit(n - 1, length - k + 1) == '0' ? '1' : '0';
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

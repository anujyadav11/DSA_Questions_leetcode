/*********************************************** JAVA **************************************************/

// Optimal Solution - Checks if n can be expressed as sum of distinct powers of three by verifying its base-3 representation contains only 0s and 1s.
/* "Any positive integer has a unique base-3 representation. A digit of 1 means that power is included, 0 means excluded, 2 means that power would need to appear twice 
    — impossible with distinct powers. This reduces the problem to a simple base conversion check in O(log n) with O(1) space." */

class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            // if remainder is 2, this power of 3 would need to be used twice — invalid
            if (n % 3 == 2) return false;
            n /= 3;
        }
        return true;
    }
}

// Time Complexity :- O(log 3 n).
// Space Complexity :- O(1).

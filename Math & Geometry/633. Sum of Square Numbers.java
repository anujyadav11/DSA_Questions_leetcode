/*********************************************** JAVA **************************************************/

// Optimal Solution - Use two pointers on square values to check whether c can be expressed as a sum of two squares.
/* “I use two pointers from 0 and √c because the square values are sorted. Based on whether the sum is too small or too large, I adjust pointers efficiently.” */

class Solution {
    public boolean judgeSquareSum(int c) {
        // Negative numbers cannot be represented
        // as sum of two squares
        if (c < 0)
            return false;
        long left = 0;
        // Maximum possible value for a² or b²
        long right = (long) Math.sqrt(c);
        // Two-pointer search
        while (left <= right) {
            // Current sum of squares
            long sum = left * left + right * right;
            // Found valid pair
            if (sum == c) {
                return true;
            }
            // Need larger sum → increase left pointer
            else if (sum < c) {
                left++;
            }
            // Need smaller sum → decrease right pointer
            else {
                right--;
            }
        }
        // No valid pair found
        return false;
    }
}

// Time Complexity :- O(under root c).
// Space Complexity :- O(1).

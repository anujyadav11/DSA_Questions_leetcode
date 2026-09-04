/*********************************************** JAVA **************************************************/

// Optimal Solution - Digit-by-digit integer reversal with overflow protection and sign handling. Reverse using modulo/division and guard against overflow before multiplying by 10.
/* “I extract the last digit using modulo 10, append it to the reversed number by multiplying the current result by 10, and then remove the processed digit using division by 10. 
    I preserve the original sign and return zero if the reversed number overflows.” */

class Solution {
    public int reverse(int x) {
        int num = 0;
        // Check whether the original number is negative
        boolean isNeg = x < 0;
        // Convert negative number to positive
        x = Math.abs(x);
        while (x > 0) {
            // Check if multiplying num by 10 will overflow
            if (Integer.MAX_VALUE / 10 < num)
                return 0;
            // Add the last digit to the reversed number
            num = num * 10 + x % 10;
            // Remove the last digit from x
            x = x / 10;
        }
        // Restore the original sign
        return isNeg ? -num : num;
    }
}

// Time Complexity :-  O(log₁₀ |x|) — one iteration per digit.
// Space Complexity :- O(1).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Greedily finds the largest odd number by returning the longest prefix ending at the rightmost odd digit.
/* "A number is odd if and only if its last digit is odd. So I scan from the right, find the first odd digit, and return everything up to it — 
    That's the largest valid odd prefix." */
 
class Solution {
    public String largestOddNumber(String num) {
        // Traverse from the rightmost digit towards the left
        for (int i = num.length() - 1; i >= 0; i--) {
            // Convert char to actual digit and check if it's odd
            if ((num.charAt(i) - '0') % 2 != 0) {
                // Return prefix up to and including this odd digit
                return num.substring(0, i + 1);
            }
        }
        // No odd digit found → return empty string
        return "";
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

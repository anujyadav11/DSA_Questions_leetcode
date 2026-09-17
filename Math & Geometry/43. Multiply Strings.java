/*********************************************** JAVA **************************************************/

// Optimal Solution - Implements string-based multiplication using the classic digit-by-digit multiplication algorithm. Multiply digits from right to left, store results in an array of size m + n, and handle carries on the fly.
/* “I simulate multiplication instead of converting the strings into integers. I use an array of size m+n because the product can have at most that many digits. For every pair of digits, 
    I add their product to the appropriate result position, store the current digit using modulo 10, and propagate the carry to the previous position. Finally, I remove leading zeros and return the result as a string.” */

class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        // Maximum possible digits in the result = m + n
        int[] res = new int[m + n];
        // Multiply digits from right to left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int prod = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // Add the product to the existing value
                int sum = prod + res[i + j + 1];
                // Store current digit
                res[i + j + 1] = sum % 10;
                // Carry goes to the previous position
                res[i + j] += sum / 10;
            }
        }
        // Convert digit array to String and skip leading zeros
        StringBuilder sb = new StringBuilder();
        for (int dig : res) {
            if (!(sb.length() == 0 && dig == 0)) {
                sb.append(dig);
            }
        }
        // Handles inputs like "0" * "123"
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

// Time Complexity :- O(m * n).
// Space Complexity :- O(m + n).

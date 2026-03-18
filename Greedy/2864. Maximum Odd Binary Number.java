/*********************************************** JAVA **************************************************/

// Optimal Solution - Rearrange bits greedily by placing all 1s at the front and ensuring the last bit is 1 to maximize the odd binary number.
/* "To make the number odd, I reserve one '1' for the last position. Then I place all remaining '1's at the front and zeros in the middle to maximize the binary value." */

class Solution {
    public String maximumOddBinaryNumber(String s) {
        int countOnes = 0;   // Count of '1's
        int countZeros = 0;  // Count of '0's
        StringBuilder result = new StringBuilder();
        // Count number of 1s and 0s
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                countOnes++;
            } else {
                countZeros++;
            }
        }
        // To make number odd → last bit must be '1'
        result.append('1');
        countOnes--; // Use one '1' for the last position
        // Add all zeros
        result.append("0".repeat(countZeros));
        // Add remaining ones
        result.append("1".repeat(countOnes));
        // Reverse to put the largest possible value in front
        return result.reverse().toString();
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

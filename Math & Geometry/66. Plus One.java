/*********************************************** JAVA **************************************************/

// Optimal Solution - Simulates integer increment by handling carry propagation from right to left. Add from the end, stop early if no carry remains; only allocate a new array when all digits are 9.
/* “I process the digits from right to left because addition propagates carries from the least significant digit. If a digit is less than 9, 
    I increment it and return immediately. If it is 9, I set it to zero and continue carrying to the previous digit. If every digit is 9, I create a new array with a leading 1.” */

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        // Start from the least significant digit
        int i = n - 1;
        // Process digits from right to left
        while (i >= 0) {
            // If current digit is less than 9,
            // simply increment it and we're done.
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            // Current digit is 9.
            // Adding 1 makes it 0 and carries 1
            // to the previous digit.
            digits[i] = 0;
            i--;
        }
        // If we reach here, every digit was 9.
        // Example: [9,9,9] -> [1,0,0,0]
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

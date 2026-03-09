/*********************************************** JAVA **************************************************/

// Optimal Solution - In-place string compression using two pointers and run-length encoding to store character counts.

class Solution {
    public int compress(char[] chars) {
        int n = chars.length;     // Total number of characters
        int i = 0;                // Pointer to traverse the original array
        int index = 0;            // Pointer to place compressed characters
        while (i < n) {
            char curr = chars[i]; // Current character group
            int count = 0;        // Count occurrences of the current character
            // Count how many times the current character repeats
            while (i < n && chars[i] == curr) {
                i++;
                count++;
            }
            // Place the character in the compressed array
            chars[index++] = curr;
            // If the character appears more than once, write its count
            if (count > 1) {
                // Convert count to string to handle multi-digit numbers
                String countStr = Integer.toString(count);
                // Write each digit of the count into the array
                for (char ch : countStr.toCharArray()) {
                    chars[index++] = ch;
                }
            }
        }
        // index represents the new length of the compressed array
        return index;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

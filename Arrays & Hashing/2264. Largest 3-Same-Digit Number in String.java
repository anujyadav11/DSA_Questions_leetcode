/*********************************************** JAVA **************************************************/

// Optimal Solution - Use sliding window of size 3 to detect consecutive identical digits and return the largest valid substring.
                      // “I scan substrings of length 3 and check if all digits are equal, keeping track of the largest one.”

class Solution {
    public String largestGoodInteger(String num) {
        String result = "";  // Stores largest valid substring
        // Traverse string and check substrings of length 3
        for (int i = 0; i <= num.length() - 3; i++) {
            char ch = num.charAt(i);
            // Check if three consecutive digits are equal
            if (ch == num.charAt(i + 1) && ch == num.charAt(i + 2)) {
                String candidate = num.substring(i, i + 3);
                // Update result if candidate is larger
                if (result.compareTo(candidate) < 0) {
                    result = candidate;
                }
            }
        }
        return result;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Insert spaces into a string at given indices using a two-pointer traversal and StringBuilder.

class Solution {
    public String addSpaces(String s, int[] spaces) {
        int m = s.length();          // Length of the original string
        int n = spaces.length;       // Number of spaces to insert
        // StringBuilder used to efficiently build the result string
        StringBuilder result = new StringBuilder();
        int j = 0; // Pointer to track the current index in the spaces array
        // Traverse each character of the string
        for (int i = 0; i < m; i++) {
            // If current index matches the next space position
            if (j < n && i == spaces[j]) {
                // Insert a space before the character
                result.append(" ");
                // Move to the next space position
                j++;
            }
            // Append the current character
            result.append(s.charAt(i));
        }
        // Convert StringBuilder to String and return
        return result.toString();
    }
}

// Time Complexity :- O(m + n).
// Space Complexity :- O(m + n).

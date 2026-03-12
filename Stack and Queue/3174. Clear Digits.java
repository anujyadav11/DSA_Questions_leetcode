/*********************************************** JAVA **************************************************/

// Optimal Solution - Use a stack to remove the closest previous letter whenever a digit appears.
/* "Whenever I encounter a digit, I remove the closest previous character using a stack. If the character is a letter, I push it. 
  This simulates the deletion efficiently in O(n) time." */

class Solution {
    public String clearDigits(String s) {
        // Stack to keep characters
        Stack<Character> stack = new Stack<>();
        // Traverse the string
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            // If the character is a digit
            if (Character.isDigit(currentChar)) {
                // Remove the closest previous letter if it exists
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // If it is a letter, push it to stack
                stack.push(currentChar);
            }
        }
        // Build the resulting string
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }
        return result.toString();
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Use a stack to remove adjacent characters that differ only by case using ASCII difference.
/* "I use a stack to simulate adjacent character cancellation. If the current character and stack top differ only by case (ASCII difference 32), 
    I remove the pair; otherwise, I push the character." */

class Solution {
    public String makeGood(String s) {
        // Stack to store characters of the "good string"
        Stack<Character> charStack = new Stack<>();
        // Traverse each character in the string
        for (char currentChar : s.toCharArray()) {
            // Check if stack is not empty and top character forms a bad pair
            // A bad pair occurs when letters are the same but with different cases
            // ASCII difference between uppercase and lowercase letters = 32
            if (!charStack.isEmpty() &&
                Math.abs(charStack.peek() - currentChar) == 32) {
                // Remove the previous character since it cancels with current
                charStack.pop();
            } else {
                // Otherwise push the current character
                charStack.push(currentChar);
            }
        }
        // Build the final string from the stack
        StringBuilder result = new StringBuilder();
        for (char ch : charStack) {
            result.append(ch);
        }
        return result.toString();
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

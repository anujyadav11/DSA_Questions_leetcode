/*********************************************** JAVA **************************************************/

// Optimal Solution - Use a stack to simulate removal of "AB" and "CD" substrings in linear time.
/* "Instead of repeatedly searching and removing substrings, I simulate the process using a stack.
    Whenever the current character forms 'AB' or 'CD' with the stack top, I remove the pair." */

class Solution {
    public int minLength(String s) {
        // Stack to simulate removal of "AB" and "CD"
        Stack<Character> charStack = new Stack<>();
        // Traverse the string
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            // If stack is empty, push the character
            if (charStack.isEmpty()) {
                charStack.push(currentChar);
                continue;
            }
            // If we form "AB", remove the pair
            if (currentChar == 'B' && charStack.peek() == 'A') {
                charStack.pop();
            }
            // If we form "CD", remove the pair
            else if (currentChar == 'D' && charStack.peek() == 'C') {
                charStack.pop();
            }
            // Otherwise keep the character
            else {
                charStack.push(currentChar);
            }
        }
        // Remaining characters represent the minimum possible length
        return charStack.size();
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Solved Decode String using recursive parsing and a shared index to handle nested repetition expressions.
/* “I use recursion to decode nested repetition expressions. I parse the repetition count, skip the opening bracket, and recursively decode the enclosed substring until a closing bracket is encountered. 
    Then I repeat the decoded substring the required number of times. A shared index lets each recursive call resume parsing at the correct position.” */

class Solution {
    private int idx = 0;
    public String decodeString(String s) {
        // Reset the index for every new input.
        idx = 0;
        return decodeHelper(s);
    }
    private String decodeHelper(String s) {
        StringBuilder decode = new StringBuilder();
        // Process characters until the end or a closing bracket.
        while (idx < s.length() && s.charAt(idx) != ']') {
            // Append letters directly.
            if (!Character.isDigit(s.charAt(idx))) {
                decode.append(s.charAt(idx));
                idx++;
            } else {
                // Read the complete repetition count.
                int k = 0;
                while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                    k = k * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                // Skip the opening bracket '['.
                idx++;
                // Recursively decode the substring inside the brackets.
                String ans = decodeHelper(s);
                // Skip the closing bracket ']'.
                idx++;
                // Append the decoded substring k times.
                for (int i = 0; i < k; i++) {
                    decode.append(ans);
                }
            }
        }
        return decode.toString();
    }
}

// Time Complexity :- O(n + m). — parsing takes O(n), and constructing the decoded output takes O(m).
// Space Complexity :- O(m + n). — the decoded output and intermediate strings can require up to O(m) space, while recursion can use up to O(n) stack space.

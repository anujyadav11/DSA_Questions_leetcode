/*********************************************** JAVA **************************************************/

// Optimal Solution - Greedy range-tracking solution that validates parentheses by maintaining possible open-count bounds. Treat * as flexible and track a range [min, max] of possible open parentheses; validity holds if the range never breaks and ends at zero.
/* “I maintain a range of possible unmatched opening parentheses. minOpen assumes every * behaves as a closing parenthesis, while maxOpen assumes every * behaves as an opening parenthesis. For ( both increase, and for ) both decrease. 
    If maxOpen becomes negative, there are too many closing parentheses and the string is invalid. At the end, if minOpen is zero, there is some valid interpretation of the wildcards.” */

class Solution {
    public boolean checkValidString(String s) {
        // Minimum and maximum possible open brackets
        int minOpen = 0;
        int maxOpen = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                minOpen++;
                maxOpen++;
            } else if (ch == ')') {
                minOpen--;
                maxOpen--;
            } else { // '*'
                // Treat '*' as ')' for minimum
                minOpen--;
                // Treat '*' as '(' for maximum
                maxOpen++;
            }
            // Too many closing brackets
            if (maxOpen < 0) {
                return false;
            }
            // Minimum cannot remain negative
            minOpen = Math.max(minOpen, 0);
        }
        // Zero must be a possible number of open brackets
        return minOpen == 0;
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(1).

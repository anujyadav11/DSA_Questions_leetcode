/*********************************************** JAVA **************************************************/

// Optimal Solution - Removes minimum brackets to validate parentheses using two greedy passes — left-to-right drops unmatched closes, right-to-left drops excess opens.
/* "Two passes cover both invalid cases cleanly — unmatched ) caught left-to-right, unmatched ( caught right-to-left. One subtle optimization: avoid insert(0,...) in the second pass since it's O(n) per call 
    — use append then reverse() at the end for true O(n) overall." */

class Solution {
    public String minRemoveToMakeValid(String s) {
        int open = 0;
        StringBuilder temp = new StringBuilder();
        // first pass: remove unmatched closing brackets
        for (char c : s.toCharArray()) {
            if (c == '(')
                // track unmatched open brackets
                open++;
            else if (c == ')') {
                // no matching open bracket — skip this closing bracket
                if (open == 0) continue;
                open--;
            }
            temp.append(c);
        }
        StringBuilder result = new StringBuilder();
        // second pass: remove excess unmatched opening brackets from right to left
        for (int i = temp.length() - 1; i >= 0; i--) {
            // skip unmatched open brackets (rightmost first)
            if (temp.charAt(i) == '(' && open-- > 0) continue;
            result.append(temp.charAt(i));
        }
        // return the valid parentheses string
        return result.reverse().toString();
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

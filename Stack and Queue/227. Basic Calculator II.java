/*********************************************** JAVA **************************************************/

// Optimal Solution - Evaluates arithmetic expressions with +, -, *, / respecting precedence using a deferred-addition pattern with a running multiplicative term — no stack needed.
/* "The key insight is separating addition-level from multiplication-level operations. currentNum acts as an implicit stack frame 
  — it accumulates * immediately since they're high priority, while +/- flush it into result and start fresh. This avoids an explicit stack, keeping space O(1) vs the typical O(n) stack solution." */

class Solution {
    public int calculate(String s) {
        int len;
        // handle null or empty string edge case
        if (s == null || (len = s.length()) == 0) return 0;
        // num: current parsed number, result: accumulated sum, currentNum: pending term
        int num = 0;
        int result = 0;
        int currentNum = 0;
        // sign tracks the last operator seen — default to '+' for first number
        char sign = '+';
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // build multi-digit number character by character
            if (Character.isDigit(c))
                num = num * 10 + (c - '0');
            // process operator or end of string — apply pending sign to currentNum
            if ((!Character.isDigit(c) && c != ' ') || i == len - 1) {
                switch (sign) {
                    case '+':
                        // flush currentNum into result, start new positive term
                        result += currentNum;
                        currentNum = num;
                        break;
                    case '-':
                        // flush currentNum into result, start new negative term
                        result += currentNum;
                        currentNum = -num;
                        break;
                    case '*':
                        // high priority — multiply directly into currentNum
                        currentNum *= num;
                        break;
                    case '/':
                        // high priority — divide directly into currentNum
                        currentNum /= num;
                        break;
                }
                // update sign to current operator and reset num for next token
                sign = c;
                num = 0;
            }
        }
        // flush final pending term into result
        result += currentNum;
        return result;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

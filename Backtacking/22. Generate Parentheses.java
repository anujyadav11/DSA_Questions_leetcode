/*********************************************** JAVA **************************************************/

// Optimal Solution - Use backtracking to build valid parentheses by adding '(' when available and ')' only when it keeps the string valid.
/* “I build the parentheses string using backtracking. I can add an opening bracket while open < n. I can add a closing bracket only when close < open, 
    which guarantees that we never have more closing brackets than opening brackets at any prefix. Once the string reaches length 2n, it is a valid combination.” */

class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        // Start with no brackets used
        backtrack(n, 0, 0, "");
        return res;
    }
    public void backtrack(int n, int open, int close, String curr) {
        // Used all 2n brackets -> valid combination
        if (curr.length() == n * 2) {
            res.add(curr);
            return;
        }
        // We can add '(' until n opening brackets are used
        if (open < n) {
            backtrack(n, open + 1, close, curr + "(");
        }
        // ')' can only be added if there is an unmatched '('
        if (close < open) {
            backtrack(n, open, close + 1, curr + ")");
        }
    }
}

// Time Complexity :-O(C_n \times n).
// Space Complexity :-O(C_n \times n).

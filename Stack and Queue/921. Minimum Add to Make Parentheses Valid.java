/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts minimum bracket insertions by matching close brackets against a stack of open brackets, summing leftover unmatched brackets of both types.

class Solution {
    public int minAddToMakeValid(String s) {
        // stack tracks unmatched open brackets
        Stack<Character> st = new Stack<>();
        // counts unmatched close brackets
        int open = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // unmatched open bracket — push onto stack
                st.push(ch);
            } else if (!st.isEmpty()) {
                // matched ')' with a pending '(' — cancel them out
                st.pop();
            } else {
                // no open bracket available — unmatched ')'
                open++;
            }
        }
        // unmatched ')' + unmatched '(' remaining in stack
        return open + st.size();
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).



/*********************************************** JAVA **************************************************/
// Without using a Stack
// Optimal Solution - Finds minimum bracket additions for validity by counting unmatched open and close brackets greedily in a single O(n) pass.

class Solution {
    public int minAddToMakeValid(String s) {
        // tracks unmatched open brackets
        int open = 0;
        // tracks unmatched close brackets
        int close = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // unmatched open bracket — needs a future ')'
                open++;
            } else {
                if (open > 0)
                    // match this ')' with an existing '('
                    open--;
                else
                    // no open bracket available — unmatched ')'
                    close++;
            }
        }
        // total additions needed = unmatched '(' + unmatched ')'
        return open + close;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

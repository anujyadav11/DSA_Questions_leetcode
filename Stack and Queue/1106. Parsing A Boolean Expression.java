/*********************************************** JAVA **************************************************/

// Optimal Solution - Parses boolean expressions using a character stack, evaluating operator-parenthesis groups bottom-up by collecting values between brackets and applying the preceding operator.
/* "The stack naturally handles nesting — inner expressions resolve first, pushing their result back for outer operators to consume. The key ordering is: 
    Values are collected LIFO from the stack (order doesn't matter for &/|), then the ( is discarded, then the operator is retrieved. 
    This pattern generalises to any nested expression evaluation problem." */

class Solution {
    private char solveOp(char op, List<Character> values) {
        if (op == '!')
            // NOT — invert single value
            return values.get(0) == 't' ? 'f' : 't';
        if (op == '&')
            // AND — false if any value is false
            return values.stream().anyMatch(ch -> ch == 'f') ? 'f' : 't';
        // OR — true if any value is true
        return values.stream().anyMatch(ch -> ch == 't') ? 't' : 'f';
    }
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == ',')
                continue;
            if (c == ')') {
                List<Character> values = new ArrayList<>();
                // collect all values inside parentheses
                while (stack.peek() != '(')
                    values.add(stack.pop());
                // remove opening parenthesis
                stack.pop();
                // get operator preceding the parenthesis
                char op = stack.pop();
                // evaluate and push result
                stack.push(solveOp(op, values));
            } else {
                stack.push(c);
            }
        }
        // final result on top of stack
        return stack.peek() == 't';
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

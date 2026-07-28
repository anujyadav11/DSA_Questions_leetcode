/********************************************** JAVA *********************************************/

// Optimal Solution – We use a stack to solve this problem by pushing all operands onto the stack and, whenever an operator appears, popping the 
                    //required operands, operating, and pushing the result back onto the stack.

class Solution {
    public int evalRPN(String[] tokens) {
        // Stack to store operands during evaluation
        Stack<Integer> st = new Stack<>();
        // Iterate through each token in the RPN expression
        for (String c : tokens) {
            // If the token is an addition operator
            if (c.equals("+")) {
                // Pop two operands and push their sum
                st.push(st.pop() + st.pop());
            // If the token is a multiplication operator
            } else if (c.equals("*")) {
                // Pop two operands and push their product
                st.push(st.pop() * st.pop());
            // If the token is a subtraction operator
            } else if (c.equals("-")) {
                // Order matters: first popped is the second operand
                int second = st.pop();
                int first = st.pop();
                st.push(first - second);
            // If the token is a division operator
            } else if (c.equals("/")) {
                // Order matters: division is not commutative
                int second = st.pop();
                int first = st.pop();
                st.push(first / second);
            // If the token is a number
            } else {
                // Convert string to integer and push onto stack
                st.push(Integer.parseInt(c));
            }
        }
        // Final result will be on top of the stack
        return st.peek();
    }
}

// Time complexity :- O(N).
// Space Complexity :- O(N).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Evaluates Reverse Polish Notation using a stack and operator map, popping two operands per operator and pushing results until the final answer remains.

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        // map operators to their corresponding operations
        Map<String, BiFunction<Integer, Integer, Integer>> map = new HashMap<>();
        map.put("+", (a, b) -> a + b);
        map.put("-", (a, b) -> a - b);
        map.put("*", (a, b) -> (int) ((long) a * (long) b));
        map.put("/", (a, b) -> a / b);
        for (String s : tokens) {
            if (map.containsKey(s)) {
                // pop operands in correct order — b is top of stack
                int b = st.pop();
                int a = st.pop();
                st.push(map.get(s).apply(a, b));
            } else {
                // push numeric token as integer
                st.push(Integer.parseInt(s));
            }
        }
        // final result is the only remaining element
        return st.pop();
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).


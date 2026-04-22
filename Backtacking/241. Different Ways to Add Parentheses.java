/*********************************************** JAVA **************************************************/

// Optimal Solution - Computes all possible results of different parenthesizations using divide-and-conquer, splitting at each operator and combining all left-right result pairs.
/* "String.parseInt is a common Java mistake — it's always Integer.parseInt. The divide-and-conquer here mirrors how a compiler builds an AST — split at operator, evaluate subtrees, combine. 
    Adding memoization with a HashMap keyed on the substring converts this from exponential to polynomial by caching repeated subexpression results." */

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return solve(expression);
    }
    public List<Integer> solve(String s) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                // split at operator — recurse on left and right subexpressions
                List<Integer> leftRes = solve(s.substring(0, i));
                List<Integer> rightRes = solve(s.substring(i + 1));
                // combine every left result with every right result
                for (int x : leftRes) {
                    for (int y : rightRes) {
                        if (c == '+')
                            res.add(x + y);
                        else if (c == '-')
                            res.add(x - y);
                        else
                            res.add(x * y);
                    }
                }
            }
        }
        // base case: no operator found — pure number string
        if (res.isEmpty())
            // FIXED: Integer.parseInt instead of String.parseInt
            res.add(Integer.parseInt(s));
        return res;
    }
}

// Time Complexity :- O(n * 2^n).
// Space Complexity :- O(2^n).

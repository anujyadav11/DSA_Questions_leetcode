/*********************************************** JAVA **************************************************/

// Optimal Solution - Reverses parenthesized substrings in O(n) using a bracket-pairing wormhole map, teleporting and flipping direction at each bracket instead of physically reversing.

/*  "The naive approach reverses each substring on encounter — O(n²). The wormhole insight is that reversing = walking backwards, so teleporting to the matching bracket and flipping direction perfectly simulates reversal without touching the string. 
    Pre-mapping brackets with a stack is the standard O(n) bracket pairing pattern." */

class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        // stack tracks unmatched open bracket indices
        Stack<Integer> openBracket = new Stack<>();
        // door[i] stores the matching bracket index for position i
        int[] door = new int[n];
        // build door mapping between matching bracket pairs
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                openBracket.push(i);
            } else if (s.charAt(i) == ')') {
                int j = openBracket.pop();
                // each bracket points to its matching partner
                door[i] = j;
                door[j] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        // dir = 1 means moving forward, -1 means moving backward
        int dir = 1;
        for (int i = 0; i < n; i += dir) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                // teleport to matching bracket and flip direction
                i = door[i];
                dir = -dir;
            } else {
                // regular character — append in current direction
                sb.append(s.charAt(i));
            }
        }
        // return the fully reversed-parentheses string
        return sb.toString();
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

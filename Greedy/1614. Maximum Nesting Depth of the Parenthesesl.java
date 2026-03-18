/*********************************************** JAVA **************************************************/

// Optimal Solution - Track nesting depth using a counter to find the maximum parentheses depth in one pass.
/* "I simulate the nesting by increasing a counter for '(' and decreasing for ')'. The maximum value reached by the counter is the answer." */

class Solution {
    public int maxDepth(String s) {
        int open = 0; // Tracks current number of open parentheses
        int maxDepth = 0; // Stores maximum depth encountered
        // Traverse each character in the string
        for (char ch : s.toCharArray()) {
            // If opening bracket → increase depth
            if (ch == '(') {
                open++;
            }
            // If closing bracket → decrease depth
            else if (ch == ')') {
                open--;
            }
            // Update maximum depth seen so far
            maxDepth = Math.max(open, maxDepth);
        }
        return maxDepth;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

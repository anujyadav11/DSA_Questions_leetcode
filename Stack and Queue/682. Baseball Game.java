/*********************************************** JAVA **************************************************/

// Optimal Solution - Solved Baseball Game using a stack to simulate score operations in O(n) time.
/* “I use a stack to maintain valid scores. Numeric operations push a score, C removes the previous score, D doubles it, and + adds the previous two scores. Finally, I sum all the remaining scores.” */

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for (String s : operations) {
            if (s.equals("C")) {
                // Remove the last valid score.
                st.pop();
            } else if (s.equals("D")) {
                // Double the last valid score.
                st.push(2 * st.peek());
            } else if (s.equals("+")) {
                // Sum the last two valid scores.
                int last = st.pop();
                int secondLast = st.peek();
                // Restore the last score.
                st.push(last);
                st.push(last + secondLast);
            } else {
                // Convert the numeric string into an integer.
                st.push(Integer.parseInt(s));
            }
        }
        // Calculate the sum of all valid scores.
        int total = 0;
        for (int score : st) {
            total += score;
        }
        return total;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Simulate folder navigation using a stack to track directory depth and compute steps needed to return to root.
/* "I simulate the folder structure using a stack. Entering a folder pushes onto the stack, moving to the parent pops from it, and staying in the same directory does nothing. 
    The stack size at the end represents how many steps are needed to return to the root." */

class Solution {
    public int minOperations(String[] logs) {
        // Stack to simulate folder navigation
        Stack<String> st = new Stack<>();
        // Traverse each log operation
        for (String log : logs) {
            // "../" means go to the parent folder
            if (log.equals("../")) {
                // Only pop if we are not already at the root directory
                if (!st.isEmpty()) {
                    st.pop();
                }
            }
            // "./" means stay in the same folder (do nothing)
            else if (!log.equals("./")) {
                // Otherwise it must be a folder name like "x/"
                // Push it to the stack to simulate entering that folder
                st.push(log);
            }
        }
        // The number of folders in the stack equals
        // the minimum operations needed to go back to root
        return st.size();
    }
}f

// Time Complexity :- O(n).
// Space Complexity :- O(n).

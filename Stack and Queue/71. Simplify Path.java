/*********************************************** JAVA **************************************************/

// Optimal Solution - Solved Simplify Path using a stack to process directory names and handle parent-directory navigation in O(n) time.
/* “I split the absolute path into components using /. I ignore empty components and ., pop the last directory when I encounter .., and push normal directory names. 
    Finally, I reconstruct the canonical path by joining the remaining directories with /. If the stack is empty, the result is /.” */

class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        // Split the path using '/' to process each directory.
        String[] parts = path.split("/");
        for (String part : parts) {
            // Ignore empty components and the current directory.
            if (part.isEmpty() || part.equals(".")) {
                continue;
            }
            // Move to the parent directory if one exists.
            if (part.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                // Store a valid directory name.
                st.push(part);
            }
        }
        // Reconstruct the canonical absolute path.
        StringBuilder sb = new StringBuilder();
        for (String dir : st) {
            sb.append("/").append(dir);
        }
        // An empty stack represents the root directory.
        return sb.length() == 0 ? "/" : sb.toString();
    }
}

// Time Complexity :- O(n).— Splitting, processing, and reconstructing the path take linear time overall.
// Space Complexity :- O(n). — The split components, stack, and output can collectively require linear space.

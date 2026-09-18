/********************************************* JAVA ***************************************/

//Optimal Solution –  When a bar is popped, we have found the first smaller bar on its right, while the new stack top gives its first smaller bar on the left.
/* “I use a monotonic increasing stack containing indices of histogram bars. When the current height becomes smaller than the bar at the stack top, that bar’s maximum possible rectangle ends at the current index. 
    I pop it, use the new stack top as the previous smaller element, calculate the width between the two boundaries, and update the maximum area. 
    Finally, I process a virtual height of zero at the end to flush all remaining bars from the stack.” */

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            int ele = (i == n) ? 0 : heights[i];
            // Pop bars that are taller than the current bar
            while (!st.isEmpty() && heights[st.peek()] > ele) {
                int h = heights[st.pop()];
                // Previous smaller element
                int ps = (st.isEmpty()) ? -1 : st.peek();
                // Width between previous smaller and current index
                int w = i - ps - 1;
                max = Math.max(max, h * w);
            }
            // Do not push the sentinel index n
            if (i < n) {
                st.push(i);
            }
        }
        return (max == Integer.MIN_VALUE) ? 0 : max;
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(N).

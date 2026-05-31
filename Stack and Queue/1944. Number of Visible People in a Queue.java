/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts visible persons to the right using a monotonic decreasing stack — each popped shorter person is visible, plus one more if a taller blocker remains. 
/* "The monotonic stack naturally models visibility — shorter people get 'consumed' by taller ones scanning right to left. Each pop represents one visible person, 
    and the remaining stack top (if any) is the first person tall enough to block further view. This is O(n) vs O(n²) brute force since each person is pushed/popped exactly once." */

class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        // monotonic decreasing stack stores heights
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            // pop all shorter people — person i can see them before they're blocked
            while (!st.isEmpty() && heights[i] > st.peek()) {
                st.pop();
                ans[i]++;
            }
            // if stack not empty — person i can also see the next taller person
            if (!st.isEmpty())
                ans[i]++;
            // push current person onto stack
            st.push(heights[i]);
        }
        return ans;
    }
}

// Time Complexity :- O(n).— each element pushed and popped at most once
// Space Complexity :- O(n).— stack holds at most n elements

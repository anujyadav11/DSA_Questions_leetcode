/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds maximum ramp width using a decreasing monotonic stack for left candidates, then greedily matching from the right to maximize j−i distance.

/* "The decreasing stack captures all useful left endpoints — any index not in the stack has a smaller or equal value at an earlier position, making it strictly worse as a left candidate. 
    Scanning right-to-left then greedily pops matches, since a larger j always gives a wider ramp for the same i." */

class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        // build decreasing stack of indices — only keep candidates where nums decreases
        for (int i = 0; i < n; i++)
            if (st.isEmpty() || nums[st.peek()] > nums[i])
                st.push(i);
        //initialise to 0 since minimum valid ramp width is 0
        int res = 0;
        // scan from right — greedily match largest j with smallest valid i
        for (int i = n - 1; i >= 0; i--) {
            // pop all stack indices where nums[stack] <= nums[i] — valid ramps
            while (!st.isEmpty() && nums[st.peek()] <= nums[i])
                res = Math.max(res, i - st.pop());
            // all candidates exhausted — no better result possible
            if (st.isEmpty())
                break;
        }
        // return maximum ramp width found
        return res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds minimum deletions to make string 'b'-before-'a' free by minimizing sum of left-side b-count and right-side a-count at each split point.
/* "Think of each position as a split point — everything left should have no bs deleted and everything right should have no as. Cost at each split = bs seen so far + as remaining after. 
    The update order matters: increment seenA before computing (current char included in left), increment bCount after (current b affects next position's left side)." */

class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        // count total 'a's — needed to compute remaining 'a's after each position
        int aCount = 0;
        for (char c : s.toCharArray())
            if (c == 'a') aCount++;
        int seenA = 0;
        int bCount = 0;
        int minDel = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            // update seenA before computing — includes current position
            if (s.charAt(i) == 'a') seenA++;
            // at each position: delete 'a's to the right + 'b's to the left
            minDel = Math.min(minDel, (aCount - seenA) + bCount);
            // update bCount after computing — current 'b' affects next position
            if (s.charAt(i) == 'b') bCount++;
        }
        return minDel;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

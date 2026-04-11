/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds minimum and maximum distances between critical points in a linked list using single-pass first/last/previous index tracking.
/* "Maximum distance is always between first and last critical point — no need to store all indices. Minimum distance requires tracking consecutive pairs, 
    so just keep prevCpi updated each time. The res[0] != Integer.MAX_VALUE guard correctly catches the case where exactly one critical point exists — 
    which is invalid since you need at least two." */

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int firstCpi = -1;
        int prevCpi = -1;
        int currIdx = 1;
        ListNode curr = head.next;
        ListNode prev = head;
        int[] res = new int[2];
        // initialize min to MAX and max to MIN for comparison
        res[0] = Integer.MAX_VALUE;
        res[1] = Integer.MIN_VALUE;
        while (curr.next != null) {
            ListNode nextNode = curr.next;
            // check if curr is local min or local max
            if ((curr.val < nextNode.val && curr.val < prev.val) ||
                (curr.val > nextNode.val && curr.val > prev.val)) {
                if (prevCpi == -1) {
                    // first critical point found — initialize both trackers
                    firstCpi = currIdx;
                    prevCpi = currIdx;
                } else {
                    // update minimum distance between consecutive critical points
                    res[0] = Math.min(res[0], currIdx - prevCpi);
                    prevCpi = currIdx;
                }
            }
            prev = prev.next;
            curr = curr.next;
            currIdx++;
        }
        // maximum distance is always between first and last critical points
        if (firstCpi != -1 && res[0] != Integer.MAX_VALUE) {
            res[1] = prevCpi - firstCpi;
        } else {
            // fewer than 2 critical points — no valid answer
            res[0] = -1;
            res[1] = -1;
        }
        return res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

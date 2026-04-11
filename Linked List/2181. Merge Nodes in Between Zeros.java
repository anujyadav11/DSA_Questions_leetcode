/*********************************************** JAVA **************************************************/

// Optimal Solution - Merges linked list segments between zeros in-place by accumulating sums into segment head nodes and relinking to skip zeros and intermediate nodes.
/*  "The key insight is reusing existing nodes — write the sum into the first node of each segment and relink directly to the next segment's start. This avoids creating a new list entirely. 
      The problem guarantees the list starts and ends with 0, so no boundary checks are needed for the zero sentinels." */

class Solution {
    public ListNode mergeNodes(ListNode head) {
        // skip the leading 0 node
        ListNode node = head.next;
        ListNode temp = node;
        while (temp != null) {
            int sum = 0;
            // accumulate sum until next 0 is found
            while (temp.val != 0) {
                sum += temp.val;
                temp = temp.next;
            }
            // store sum in current result node
            node.val = sum;
            // move temp past the 0 separator
            temp = temp.next;
            // link current node to next segment start
            node.next = temp;
            // advance result pointer
            node = temp;
        }
        // head.next is first result node (skip leading 0)
        return head.next;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

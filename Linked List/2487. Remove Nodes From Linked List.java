/*********************************************** JAVA **************************************************/

// Optimal Solution - Removes nodes with greater values to their right by reversing the list, greedily keeping only nodes that are running maximums, then rebuilding in order.
/* "Reversing converts 'no greater to the right' into 'no greater seen so far from left' — a simple running max problem. The prepend pattern during rebuild naturally restores original order without a second reversal. 
    Alternative approach: use a monotonic decreasing stack, but reversal is more space efficient." */

class Solution {
    public ListNode removeNodes(ListNode head) {
        // reverse the list so we can scan right-to-left
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        // build result list — start with the largest (first node after reverse)
        ListNode newHead = new ListNode(prev.val);
        int maxVal = newHead.val;
        curr = prev.next;
        while (curr != null) {
            if (curr.val >= maxVal) {
                // current node has no greater node to its right — keep it
                ListNode node = new ListNode(curr.val);
                node.next = newHead;
                newHead = node;
                // update max seen so far from the right
                maxVal = node.val;
            }
            curr = curr.next;
        }
        // return rebuilt list in original order
        return newHead;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

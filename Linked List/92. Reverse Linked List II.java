/*********************************************** JAVA **************************************************/

// Optimal Solution - Solved Reverse Linked List II using iterative sublist reversal and pointer manipulation in O(n) time and O(1) auxiliary space.
/* "I use a dummy node to simplify edge cases, especially when the reversal starts at the head. I traverse to the node before the required range, 
    reverse the sublist iteratively, and reconnect the previous portion and remaining portion using the saved pointers." */

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Handle an empty list or a single-node list.
        if (head == null || head.next == null) {
            return head;
        }
        // Dummy node simplifies handling when left == 1.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode leftPrev = dummy;
        ListNode curr = head;
        // Move to the node immediately before the reversal range.
        for (int i = 0; i < left - 1; i++) {
            leftPrev = leftPrev.next;
            curr = curr.next;
        }
        // Save the original head of the sublist.
        // It will become the tail after reversal.
        ListNode subListHead = curr;
        ListNode prevNode = null;
        // Reverse nodes from position left to right.
        for (int i = 0; i <= right - left; i++) {
            // Save the next node before changing the pointer.
            ListNode temp = curr.next;
            // Reverse the current node's pointer.
            curr.next = prevNode;
            // Move prevNode and curr forward.
            prevNode = curr;
            curr = temp;
        }
        // Connect the previous portion to the new sublist head.
        leftPrev.next = prevNode;
        // Connect the new sublist tail to the remaining list.
        subListHead.next = curr;
        return dummy.next;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

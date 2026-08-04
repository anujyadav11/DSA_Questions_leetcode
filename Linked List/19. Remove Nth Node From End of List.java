/******************************************************* JAVA *****************************************************/

// Optimal Solution - Removed the nth node from the end of the linked list in a single traversal using the two-pointer technique with a fixed gap of n nodes.
/* "Instead of first computing the length of the list, maintain two pointers separated by n nodes. Once the leading pointer reaches the end, 
    the trailing pointer is positioned at the node to remove." */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Move the second pointer n steps ahead
        ListNode second = head;
        while (n > 0 && second != null) {
            second = second.next;
            n--;
        }
        // Handle the case where the node to remove is the head
        if (second == null) {
            // n was greater than the length of the list
            if (n > 0) {
                return head;
            }
            // Remove the head node
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            return head;
        }
        // Move both pointers until the second pointer reaches the end
        ListNode first = head;
        ListNode previous = null;
        while (second != null) {
            previous = first;
            first = first.next;
            second = second.next;
        }
        // Remove the target node
        previous.next = first.next;
        first.next = null;
        return head;
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(1).

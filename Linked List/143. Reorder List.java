/*************************************************** JAVA *************************************************/


// Optimal Solution - Reordered the linked list in-place by finding the middle, reversing the second half, and alternately merging both halves to achieve the required sequence.
/* "The key observation is that the reordered list alternates between the front and the back of the original list. Since singly linked lists don’t support backward traversal, 
    first locate the middle, reverse the second half to access the nodes from the end efficiently, and then merge both halves alternately." */

class Solution {
    public void reorderList(ListNode head) {
        // No reordering needed for lists with fewer than 3 nodes
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Split the list into two halves
        ListNode secondHalf = slow.next;
        slow.next = null;
        // Step 2: Reverse the second half
        ListNode previous = null;
        ListNode current = secondHalf;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        // Step 3: Merge the two halves alternately
        ListNode first = head;
        ListNode second = previous;
        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            first.next = second;
            second.next = firstNext;
            first = firstNext;
            second = secondNext;
        }
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(1).

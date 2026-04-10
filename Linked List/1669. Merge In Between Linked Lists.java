/*********************************************** JAVA **************************************************/

// Optimal Solution - Remove a segment from list1 and splice list2 in between using pointer manipulation.
/* “I locate the node before a and after b, then splice list2 between them by reconnecting pointers.” */

class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode left = null;   // Node just before index 'a'
        ListNode right = list1; // Pointer to traverse list1
        // Traverse to find:
        // left → node at (a-1)
        // right → node at (b+1)
        for (int i = 0; i <= b; i++) {
            // When we reach (a-1), store it
            if (i == a - 1) {
                left = right;
            }   
            // Move forward
            right = right.next;
        }
        // Connect left part with list2
        left.next = list2;
        // Traverse to end of list2
        ListNode temp = list2;
        while (temp.next != null) {
            temp = temp.next;
        }
        // Connect end of list2 with right part
        temp.next = right;
        return list1;
    }
}

// Time Complexity :- O(m + n).
// Space Complexity :- O(1).

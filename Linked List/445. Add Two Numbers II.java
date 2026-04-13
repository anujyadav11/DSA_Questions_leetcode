/*********************************************** JAVA **************************************************/

// Optimal Solution - Adds most-significant-first linked list numbers by reversing both inputs, adding digit-by-digit with carry in a unified loop condition, then reversing the result.
/* "Including carry != 0 directly in the while condition is cleaner than a post-loop if — it handles the final carry in zero extra lines. This version is strictly cleaner than the previous one: 
    no dummy value check needed, no separate carry node append, and pointer advancement inside if blocks cleanly handles lists of different lengths." */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // reverse both lists so least significant digit comes first
        l1 = reverse(l1);
        l2 = reverse(l2);
        int carry = 0;
        // dummy head simplifies result list construction
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        // continue while either list has digits or carry remains
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            // update carry and append current digit
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        // reverse result to restore most-significant-first order
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nxt = head.next;
            head.next = prev;
            prev = head;
            head = nxt;
        }
        return prev;
    }
}

// Time Complexity :- O(max(n , m)).
// Space Complexity :- O(max( n , m)).

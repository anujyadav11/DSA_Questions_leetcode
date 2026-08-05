/***************************************************** JAVA ******************************************************/

// Optimal Solution - We simulate digit-by-digit addition like elementary math by traversing both linked lists, carrying over values greater than 9, and building the result list using a dummy head.

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy node to simplify list construction
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        // Traverse both lists until all digits are processed
        while (l1 != null || l2 != null) {
            int sum = carry;
            // Add digit from the first list
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            // Add digit from the second list
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            // Compute the carry for the next digit
            carry = sum / 10;
            // Store the current digit in the result list
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        // Append the remaining carry if present
        if (carry == 1) {
            current.next = new ListNode(1);
        }
        return dummy.next;
    }
}

// Time Complexity :- O(max(m ,n))
// Space Complexity :- O(1).

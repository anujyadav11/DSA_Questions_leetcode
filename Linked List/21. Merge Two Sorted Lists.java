/*************************************************** JAVA *************************************************/

// Optimal Solution - We iteratively compare nodes from both sorted lists, attach the smaller one to the result list, and finally append any remaining nodes to produce a merged sorted list.


class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // dummy head simplifies edge cases
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                // take from list1 — smaller or equal value
                curr.next = list1;
                list1 = list1.next;
            } else {
                // take from list2 — smaller value
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        // attach remaining nodes from whichever list is non-empty
        curr.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
}

// Time Complexity :- O(m + n) ~ list1 , list2
// Space Comlexity :- O(1).

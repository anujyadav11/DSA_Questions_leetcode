/********************************************* JAVA ******************************************/

// Optimal Solution - We first check if a group of k nodes exists, recursively reverse the remaining list, and then reverse  The current group of k nodes is linked to the already reversed remainder.
/* “For each recursive call, I first check whether at least k nodes remain. If fewer than k nodes are available, I return the list unchanged. Otherwise, I recursively reverse all groups after the current group. 
    Then I reverse the current k nodes and use cur, which points to the reversed remainder, as the connection point. This guarantees that every complete group is reversed while the final incomplete group remains unchanged.” */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Check whether at least k nodes are available
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        // If k nodes exist, reverse this group
        if (count == k) {
            // Recursively reverse the remaining groups
            cur = reverseKGroup(cur, k);
            // Reverse the current group
            while (count-- > 0) {
                ListNode temp = head.next;
                // Connect current node to the reversed remainder
                head.next = cur;
                // Move cur to the current node
                cur = head;
                // Move head to the next node in the original group
                head = temp;
            }
            // cur is now the new head of this reversed group
            head = cur;
        }
        // If fewer than k nodes remain, return them unchanged
        return head;
    }
}

// Time Complexity :- O(N)
// Space Compelxity :- O(1) 

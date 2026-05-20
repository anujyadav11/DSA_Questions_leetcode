/*********************************************** JAVA **************************************************/

// Optimal Solution - Inserts GCD nodes between every adjacent pair in a linked list using post-order recursion to process pairs right-to-left.
/* "Post-order recursion is key here — process head.next first so the rest of the list is already transformed before inserting at the current position. 
    The iterative approach with prev and curr pointers avoids stack overhead and is O(1) space — mention it as a follow-up for large lists." */

class Solution {
    // Euclidean GCD — recursive
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // empty list or single node — nothing to insert
        if (head == null || head.next == null) return head;
        // recursively process the rest of the list first
        ListNode temp = insertGreatestCommonDivisors(head.next);
        // create GCD node between current and next
        ListNode gcdNode = new ListNode(gcd(head.val, head.next.val));
        // insert GCD node: head -> gcdNode -> temp
        gcdNode.next = temp;
        head.next = gcdNode;
        return head;
    }
}

// Time Complexity :- O(n * log(maxVal)).
// Space Complexity :- O(n).

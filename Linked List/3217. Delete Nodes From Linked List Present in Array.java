/*********************************************** JAVA **************************************************/

// Optimal Solution - Removes all linked list nodes whose values appear in nums using a boolean array for O(1) lookups and in-place prev/curr pointer manipulation.
/* "Boolean array beats HashSet here — O(1) lookup with no hashing overhead and guaranteed constant space since values are bounded by 1e5. 
    The head removal edge case is the classic linked list gotcha — always check if prev == null before bypassing. Setting curr.next = null after removal is good practice to help GC and avoid dangling references." */

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // boolean array as O(1) lookup set — avoids HashSet overhead
        boolean[] set = new boolean[(int) 1e5 + 1];
        for (int num : nums)
            set[num] = true;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            if (set[curr.val]) {
                if (prev == null) {
                    // removing head node — advance head pointer
                    head = head.next;
                    curr.next = null;
                    curr = head;
                } else {
                    // bypass current node by linking prev to next
                    prev.next = curr.next;
                    curr.next = null;
                    curr = prev.next;
                }
            } else {
                // node is valid — advance both pointers
                prev = curr;
                curr = curr.next;
            }
        }
        // return modified list with all nums values removed
        return head;
    }
}

// Time Complexity :- O(n + m).
// Space Complexity :- O(1e5). because of the Boolean mapping array for removing node.

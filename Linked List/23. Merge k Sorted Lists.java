/*********************************************** JAVA **************************************************/

// Optimal Solution - Divide-and-conquer merge of k sorted linked lists achieving O(N log k) time complexity.This is merge sort on linked lists — repeatedly merge pairs until one sorted list remains.
/* “I use divide and conquer to merge the k sorted lists. I recursively divide the list array into two halves until I have individual lists, 
    then merge the two sorted halves using the standard two-pointer linked-list merge. Since each level processes all N nodes and there are log k levels, 
    the total time complexity is O(N log k). The recursion requires O(log k) stack space.” */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // No lists to merge
        if (lists == null || lists.length == 0) {
            return null;
        }
        // Merge all lists using divide and conquer
        return mergeHelper(lists, 0, lists.length - 1);
    }
    private ListNode mergeHelper(ListNode[] lists, int start, int end) {
        // Only one list remains
        if (start == end) {
            return lists[start];
        }
        // Merge two lists directly
        if (start + 1 == end) {
            return merge2Lists(lists[start], lists[end]);
        }
        // Divide the lists into two halves
        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        // Merge the two sorted halves
        return merge2Lists(left, right);
    }
    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        // Dummy node simplifies linked-list construction
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        // Merge while both lists have nodes
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        // Attach the remaining nodes
        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}

// Time Complexity :- O(N log K).
// Space Complexity :- O(log K).

/********************************************************* JAVA ***************************************************************/

// Optimal Solution - We clone each node in-place, use the interleaved structure to correctly assign random pointers, and finally detach the cloned list from 
                    The original list is to obtain a deep copy using constant extra space.

class Solution {
    public Node copyRandomList(Node head) {
        // Handle empty list
        if (head == null) {
            return null;
        }
        // Step 1: Create a copy of each node and insert it
        // immediately after the original node
        Node current = head;
        while (current != null) {
            Node copiedNode = new Node(current.val);
            copiedNode.next = current.next;
            current.next = copiedNode;
            current = copiedNode.next;
        }
        // Step 2: Assign random pointers for the copied nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        // Step 3: Separate the original list and the copied list
        current = head;
        Node copiedHead = head.next;
        Node copiedCurrent = copiedHead;
        while (current != null) {
            // Restore the original list
            current.next = copiedCurrent.next;
            current = current.next;
            // Build the copied list
            if (current != null) {
                copiedCurrent.next = current.next;
                copiedCurrent = copiedCurrent.next;
            }
        }
        return copiedHead;
    }
}
// Time Complexity :- O(N).
// Space Complexity :- O(1).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Implemented a fixed-capacity circular queue using an array, front/rear pointers, size tracking, and modulo arithmetic, achieving O(1) time for all queue operations.
/* "I implement a circular queue using a fixed-size array and three variables: front, rear, and size. The front and rear pointers track the first and last elements, 
    while size helps distinguish between full and empty states. I use modulo arithmetic to wrap the pointers around the array, avoiding element shifting." */

class MyCircularQueue {
    int[] q;
    int front = 0;
    int rear = 0;
    int size = 0;
    public MyCircularQueue(int k) {
        // Initialize the circular queue with capacity k.
        q = new int[k];
        // Mark all positions as empty.
        Arrays.fill(q, -1);
    }
    public boolean enQueue(int value) {
        // Cannot insert if the queue is full.
        if (isFull()) {
            return false;
        }
        // Handle insertion into an empty queue.
        if (isEmpty()) {
            front = rear = 0;
        } else {
            // Move rear circularly to the next position.
            rear = (rear + 1) % q.length;
        }
        // Insert the new element.
        q[rear] = value;
        // Update the number of elements.
        size++;
        return true;
    }
    public boolean deQueue() {
        // Cannot remove an element from an empty queue.
        if (isEmpty()) {
            return false;
        }
        // Mark the current front position as empty.
        q[front] = -1;
        // Update the number of elements.
        size--;
        // Move front circularly only if elements remain.
        if (size > 0) {
            front = (front + 1) % q.length;
        }
        return true;
    }
    public int Front() {
        // Return -1 if the queue is empty.
        if (isEmpty()) {
            return -1;
        }
        return q[front];
    }
    public int Rear() {
        // Return -1 if the queue is empty.
        if (isEmpty()) {
            return -1;
        }
        return q[rear];
    }
    public boolean isEmpty() {
        // Queue is empty when it contains zero elements.
        return size == 0;
    }
    public boolean isFull() {
        // Queue is full when size equals capacity.
        return size == q.length;
    }
}

// Time Complexity :- O(1).
// Space Complexity :- O(1).

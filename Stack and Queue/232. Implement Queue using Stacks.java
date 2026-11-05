/*********************************************** JAVA **************************************************/

// Optimal Solution - Implement a queue using two stacks by reversing element order during lazy transfers.
/* "I use two stacks: one for input and one for output. Elements are pushed onto the input stack. When we need to access the queue front, 
    we transfer elements to the output stack, reversing the order and allowing FIFO behavior." */


class MyQueue {
    private final Stack<Integer> input;
    private final Stack<Integer> output;
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    // Insert element into the queue.
    public void push(int x) {
        input.push(x);
    }
    // Remove and return the front element.
    public int pop() {
        peek(); // Ensure the front element is available in output.
        return output.pop();
    }
    // Return the front element without removing it.
    public int peek() {
        // Transfer elements only when output is empty.
        if (output.empty()) {
            // Reverse the order of elements.
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    // Check whether the queue is empty.
    public boolean empty() {
        return input.empty() && output.empty();
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

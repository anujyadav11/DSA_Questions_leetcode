/*********************************************** JAVA **************************************************/

// Optimal Solution - Implement a queue using two stacks by reversing element order during lazy transfers.
/* "I use two stacks: one for input and one for output. Elements are pushed onto the input stack. When we need to access the queue front, 
    we transfer elements to the output stack, reversing the order and allowing FIFO behavior." */

class MyQueue {
    // Stack used to push incoming elements
    private final Stack<Integer> input;
    // Stack used to serve elements in queue order
    private final Stack<Integer> output;
    public MyQueue() {
        // Initialize both stacks
        input = new Stack<>();
        output = new Stack<>();
    }
    public void push(int x) {
        // Always push new elements to the input stack
        input.push(x);
    }
    public int pop() {
        // Ensure output stack has the correct front element
        peek();
        // Pop from output stack (which represents queue front)
        return output.pop();
    }
    public int peek() {
        // If output stack is empty, transfer all elements
        // from input to output to reverse the order
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        // Top of output stack is the front of the queue
        return output.peek();
    }
    public boolean empty() {
        // Queue is empty only if both stacks are empty
        return input.isEmpty() && output.isEmpty();
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

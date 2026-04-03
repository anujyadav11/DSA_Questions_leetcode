/*********************************************** JAVA **************************************************/

// Optimal Solution - Iterates nested lists lazily using a stack with reverse insertion, expanding nested lists on demand in hasNext() to always expose the next integer on top.
/* "The reverse-push trick is the core insight — it maintains left-to-right order with a stack. hasNext() does all the heavy lifting by lazily flattening lists, keeping next() trivially simple. 
    This lazy approach is better than eager flattening since it handles infinite or very deep structures without upfront cost." */

public class NestedIterator implements Iterator<Integer> {
    // stack stores NestedIntegers in reverse order for correct left-to-right traversal
    private Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        int n = nestedList.size();
        // push in reverse so leftmost element is on top
        for (int i = n - 1; i >= 0; i--)
            stack.push(nestedList.get(i));
    }
    @Override
    public Integer next() {
        // hasNext() guarantees top of stack is an integer — safe to pop and return
        return stack.pop().getInteger();
    }
    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger curr = stack.peek();
            // top is an integer — ready to return
            if (curr.isInteger()) return true;
            // top is a list — flatten it onto the stack in reverse order
            stack.pop();
            List<NestedInteger> list = curr.getList();
            int n = list.size();
            // push in reverse to maintain left-to-right order
            for (int i = n - 1; i >= 0; i--)
                stack.push(list.get(i));
        }
        // stack exhausted — no more integers
        return false;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

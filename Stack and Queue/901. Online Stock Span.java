/*********************************************** JAVA **************************************************/

// Optimal Solution - Solved Online Stock Span using a monotonic decreasing stack with span aggregation, achieving O(1) amortized time per operation.
/* “I maintain a monotonic decreasing stack of price-span pairs. For each new price, I pop all previous prices that are less than or equal to it and accumulate their spans. 
    I then push the current price with its calculated span. Each entry is pushed and popped at most once, giving O(1) amortized time per operation.” */

// Stores the stock price and its span.
class Pair {
    int first;  // Stock price
    int second; // Span of that price
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class StockSpanner {
    Stack<Pair> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    public int next(int price) {
        int span = 1;
        // Merge the spans of previous days with prices
        // less than or equal to today's price.
        while (!st.isEmpty() && st.peek().first <= price) {
            span += st.pop().second;
        }
        // Store today's price and its calculated span.
        st.push(new Pair(price, span));
        return span;
    }
}

// Time Complexity :- O(1)- amortized per call; O(n) total. Each entry is pushed once and popped at most once.
// Space Complexity :- O(n).- in the worst case, when prices are strictly decreasing and no entries are removed.

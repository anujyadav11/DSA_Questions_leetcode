/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds the Kth symbol in grammar by recursively halving the row — left half mirrors the parent, right half complements it.

/* "The key insight is the self-similar structure — left half of row N equals row N-1, right half is its complement. This gives a clean O(N) recursion instead of generating the entire exponentially large row. 
    The complement trick 1 - result elegantly replaces a bitwise NOT for binary values." */

class Solution {
    public int kthGrammar(int N, int K) {
        // base case: first row always starts with 0
        if (N == 1 && K == 1)
            return 0;
        // mid = total elements in row N-1 = 2^(N-1) / 2 = 2^(N-2)
        int mid = (int) Math.pow(2, N - 1) / 2;
        if (K <= mid)
            // left half mirrors parent row exactly
            return kthGrammar(N - 1, K);
        // right half is bitwise complement of parent row
        return 1 - kthGrammar(N - 1, K - mid);
    }
}

// Time Complexity :- O(n). 
// Space Complexity :- O(n). recursion stack storage.


// Two Pointers Solution - Iteratively determines the Kth grammar symbol by tracking right-half flips bottom-up from row N to row 1, eliminating recursive stack overhead.

/* "The iterative version converts the recursion's implicit call stack into an explicit flip counter — every time K lands in the right half we flip and remap, left half we just continue. 
    This drops space from O(N) to O(1) while keeping O(N) time. Always mention this optimization after the recursive solution in interviews." */

class Solution {
    public int kthGrammar(int N, int K) {
        // start from row N and work up to row 1
        int result = 0;
        for (int row = N; row > 1; row--) {
            // mid = half the elements in current row
            int mid = (int) Math.pow(2, row - 1) / 2;
            // K is in right half — flip result and move to left half position
            if (K > mid) {
                result = 1 - result;
                // map K to its parent position in left half
                K -= mid;
            }
            // K is in left half — parent is same value, no flip needed
        }
        // result accumulated all flips from row N down to row 1
        return result;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

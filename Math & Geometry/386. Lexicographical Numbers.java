/*********************************************** JAVA **************************************************/

// Optimal Solution - Generates lexicographic order from 1 to n using DFS digit-by-digit tree traversal, appending digits 0-9 at each level and pruning when exceeding n.
/* "Lexicographic order is naturally a trie traversal — each number is a node, children are formed by appending 0-9. DFS gives lexicographic order automatically. 
    Starting from 1 not 0 is critical — 0 would generate 0, 01, 02... which are invalid positive integers. The early return prune newNum > n cuts entire subtrees efficiently." */

class Solution {
    void solve(int curr, int n, List<Integer> res) {
        // base case: current number exceeds n — stop this branch
        if (curr > n) return;
        // add current number to result
        res.add(curr);
        // try appending each digit 0-9 to current number
        for (int append = 0; append <= 9; append++) {
            int newNum = curr * 10 + append;
            // prune — no need to explore further if exceeds n
            if (newNum > n) return;
            solve(newNum, n, res);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        // start from 1 not 0 — 0 is not a valid number
        for (int i = 1; i <= 9; i++)
            solve(i, n, res);
        return res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(log n).

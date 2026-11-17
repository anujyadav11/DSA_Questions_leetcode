/*********************************************** JAVA **************************************************/

// Optimal Solution - Implemented backtracking with recursive selection, pruning, and state restoration to generate all k-sized combinations in O(k × C(n,k)) time.
/* "I use backtracking to generate all combinations of size k from numbers 1 through n. At each step, I select an available number, recursively explore the remaining choices, 
    and then backtrack by removing the selected number. I use pruning to avoid exploring branches that don't have enough remaining elements to complete a combination. 
    Each valid combination is copied into the result list." */

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        // Initialize a fresh result list for every method call.
        res = new ArrayList<>();
        // Start generating combinations from number 1.
        solve(1, k, n, new ArrayList<>());
        return res;
    }
    private void solve(int start, int k, int n, List<Integer> temp) {
        // Base case: exactly k elements have been selected.
        if (k == 0) {
            // Store a copy because temp will be modified during backtracking.
            res.add(new ArrayList<>(temp));
            return;
        }
        // Not enough remaining elements to complete the combination.
        if (n - start + 1 < k) {
            return;
        }
        // No more elements are available.
        if (start > n) {
            return;
        }
        // Choice 1: Pick the current element.
        temp.add(start);
        solve(start + 1, k - 1, n, temp);
        // Backtrack: remove the previously selected element.
        temp.remove(temp.size() - 1);
        // Choice 2: Do not pick the current element.
        solve(start + 1, k, n, temp);
    }
}

// Time Complexity :- O(k* C(n,k).
// Space Complexity :- O(k* C(n,k).

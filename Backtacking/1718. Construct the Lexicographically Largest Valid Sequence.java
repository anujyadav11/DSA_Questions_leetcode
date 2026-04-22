/*********************************************** JAVA **************************************************/

// Optimal Solution - Constructs the lexicographically largest distanced sequence using backtracking, placing numbers largest-first with each number i occupying two positions exactly i apart.
/* "The greedy largest-first ordering is key — trying n down to 1 at each position naturally produces the lexicographically largest valid sequence, so the first complete solution found is the answer. 
    The while loop skipping filled positions avoids redundant work. Dual-position placement seq[idx] = seq[idx+i] = i with bounds check idx+i < seq.length handles all edge cases cleanly." */

class Solution {
    public int[] constructDistancedSequence(int n) {
        boolean[] used = new boolean[n + 1];
        int[] seq = new int[2 * n - 1];
        backtrack(0, used, seq, n);
        return seq;
    }
    public boolean backtrack(int idx, boolean[] used, int[] seq, int n) {
        // skip already filled positions
        while (idx < seq.length && seq[idx] != 0) idx++;
        // all positions filled — valid sequence found
        if (idx == seq.length) return true;
        // try placing largest numbers first for the lexicographically largest result
        for (int i = n; i >= 1; i--) {
            if (used[i]) continue;
            if (i == 1) {
                // 1 only needs one position
                seq[idx] = 1;
                used[1] = true;
                if (backtrack(idx + 1, used, seq, n)) return true;
                // backtrack
                seq[idx] = 0;
                used[1] = false;
            } else if (idx + i < seq.length && seq[idx + i] == 0) {
                // place i at idx and idx+i (distance of i apart)
                seq[idx] = i;
                seq[idx + i] = i;
                used[i] = true;
                if (backtrack(idx + 1, used, seq, n)) return true;
                // backtrack both positions
                seq[idx] = 0;
                seq[idx + i] = 0;
                used[i] = false;
            }
        }
        // no valid placement found at this position
        return false;
    }
}

// Time Complexity :- O(n!). worst case — backtracking explores permutations; early exit makes it efficient in practice.
// Space Complexity :- O(n). — seq array of size 2n-1, used array of size n+1, call stack of depth O(n).

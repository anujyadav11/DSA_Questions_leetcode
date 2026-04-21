/*********************************************** JAVA **************************************************/

// Optimal Solution - Maximizes unique substring splits using backtracking with HashSet deduplication and remaining-length pruning to skip unpromising branches.
/* "The pruning condition set.size() + (n - idx) <= maxCount is key — it calculates the theoretical maximum additional unique substrings 
    (one per remaining character) and skips if even that can't beat the current best. This converts an exponential worst case into something practically efficient for typical inputs."*/

class Solution {
    int maxCount;
    public int maxUniqueSplit(String s) {
        maxCount = 0;
        Set<String> set = new HashSet<>();
        backtrack(s, set, 0);
        return maxCount;
    }
    public void backtrack(String s, Set<String> set, int idx) {
        int n = s.length();
        // base case: entire string consumed — update max unique substrings
        if (idx == n) {
            maxCount = Math.max(maxCount, set.size());
            return;
        }
        // pruning: even if all remaining chars form unique single chars, can't beat maxCount
        if (set.size() + (n - idx) <= maxCount) return;
        for (int i = idx; i < n; i++) {
            String sub = s.substring(idx, i + 1);
            if (!set.contains(sub)) {
                set.add(sub);
                backtrack(s, set, i + 1);
                // backtrack — remove substring for other splits
                set.remove(sub);
            }
        }
    }
}

// Time Complexity :- O(2^n). worst case — exponential splits; pruning significantly reduces in practice
// Space Complexity :- O(n) — set holds at most n substrings; call stack depth.

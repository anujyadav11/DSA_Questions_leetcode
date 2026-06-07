/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts corridor division ways by multiplying gaps between consecutive seat-pair boundaries, where each gap represents independent divider placement choices.
/* "The key insight is that dividers between sections are independent — the gap between section k's last seat and section k+1's first seat gives exactly that many placement options.
    Multiplying independent choices gives total ways. Always check size == 0 before size % 2 — 0 % 2 == 0 would incorrectly return 1 without the zero check." */

class Solution {
    int MOD = 1000000007;
    public int numberOfWays(String corridor) {
        int n = corridor.length();
        // collect indices of all seats
        List<Integer> seats = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (corridor.charAt(i) == 'S')
                seats.add(i);
        // need even non-zero number of seats for valid divisions
        if (seats.size() == 0 || seats.size() % 2 != 0)
            return 0;
        long res = 1;
        // end of first section is always the second seat
        int endPrev = seats.get(1);
        // iterate over pairs starting from index 2 — each pair is a new section
        for (int i = 2; i < seats.size(); i += 2) {
            // gap between end of previous section and start of next = number of divider placements
            int len = seats.get(i) - endPrev;
            res = (res * len) % MOD;
            // update end of current section to second seat of this pair
            endPrev = seats.get(i + 1);
        }
        return (int) res;
    }
}

// Time Complexity :- O(n).— single pass to collect seats, single pass over pairs
// Space Complexity :- O(s).— list stores s seat indices where s ≤ n

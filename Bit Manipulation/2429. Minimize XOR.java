/*********************************************** JAVA **************************************************/

// Optimal Solution - Minimizes XOR with num1 by greedily assigning num2's popcount bits — first reusing num1's highest set bits, then filling lowest available positions.
/* "Two greedy passes: first reuse num1's bits top-down (XOR contribution = 0 for matching bits), then fill remaining from bottom-up (minimizes added value).
    Always use bit < 32 not <= 32 for int shifts — 1 << 32 wraps to 1 in Java due to modular shift behavior, a subtle but critical bug." */

class Solution {
    public int minimizeXor(int num1, int num2) {
        // target number of set bits equals popcount of num2
        int setBits = Integer.bitCount(num2);
        int res = 0;
        int bit = 31;
        // first pass: use highest set bits of num1 — minimizes Xor with num1
        while (bit >= 0 && setBits > 0) {
            if ((num1 & (1 << bit)) != 0) {
                res |= (1 << bit);
                setBits--;
            }
            bit--;
        }
        // second pass: fill remaining needed bits from lowest positions
        bit = 0;
        while (bit < 32 && setBits > 0) {
            if ((res & (1 << bit)) == 0) {
                res |= (1 << bit);
                setBits--;
            }
            bit++;
        }
        return res;
    }
}

// Time Complexity :- O(log n + 32).
// Space Complexity :- O(1).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Determines game winner by counting AAA and BBB triple patterns as valid moves, returning true if Alice has strictly more moves than Bob.
/* "The key insight is that optimal play always uses every available move — so just count total valid moves per player without simulating the game. 
    A move is valid only when removing a middle piece from three consecutive same-colored pieces. Loop bounds [1, n-2] are critical — accessing i-1 and i+1 requires both neighbors to exist." */

class Solution {
    public boolean winnerOfGame(String colors) {
        int alice = 0;
        int bob = 0;
        int n = colors.length();
        // start at 1 and end at n-2 to safely access i-1 and i+1
        for (int i = 1; i < n - 1; i++) {
            if (colors.charAt(i - 1) == 'A' && colors.charAt(i) == 'A' && colors.charAt(i + 1) == 'A')
                // three consecutive A's — Alice can remove middle one
                alice++;
            else if (colors.charAt(i - 1) == 'B' && colors.charAt(i) == 'B' && colors.charAt(i + 1) == 'B')
                // three consecutive B's — Bob can remove middle one
                bob++;
        }
        // Alice wins if she has strictly more moves than Bob
        return alice > bob;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Computes minimum moves to collect all balls at each box position using an O(n) two-pass prefix accumulation over left and right directions.
/*  "Brute force is O(n²) — for each box scan all others. The key insight is that moving one step right costs all previously seen balls one extra move — so moves += balls elegantly accumulates the running cost in O(n). 
    Two passes covers both directions." */

class Solution {
    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];
        int moves = 0;
        int balls = 0;
        // left pass: accumulate cost of moving all left-side balls to index i
        for (int i = 0; i < boxes.length(); i++) {
            // add cost from all balls seen so far to reach index i
            ans[i] = moves;
            // if current box has a ball, it contributes to future indices
            if (boxes.charAt(i) == '1')
                balls++;
            // each ball seen so far needs one more move for the next index
            moves += balls;
        }
        moves = 0;
        balls = 0;
        // right pass: accumulate cost of moving all right-side balls to index i
        for (int i = boxes.length() - 1; i >= 0; i--) {
            // add right-side cost on top of left-side cost already stored
            ans[i] += moves;
            // if the current box has a ball, it contributes to future leftward indices
            if (boxes.charAt(i) == '1')
                balls++;
            // each ball seen so far needs one more move for the next leftward index
            moves += balls;
        }
        // return total minimum operations for each box
        return ans;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

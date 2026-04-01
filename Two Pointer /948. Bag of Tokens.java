/*********************************************** JAVA **************************************************/

// Optimal Solution - Maximizes token game score using a greedy two-pointer strategy — play cheapest tokens for score when affordable, sacrifice most valuable for power when not.

/* "The greedy insight is asymmetric — always buy score with the cheapest token and always sell score with the most expensive token. The left < right guard in the trade branch is critical — 
    it prevents trading the last token for power with no tokens left to buy score, which would be a net loss." */

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        // sort so cheapest tokens are at left, most valuable at right
        Arrays.sort(tokens);
        int score = 0;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            if (tokens[left] <= power) {
                // afford cheapest token — gain score, spend power
                power -= tokens[left];
                score++;
                left++;
            } else if (left < right && score > 0) {
                // can't afford cheapest — sacrifice most valuable for power
                power += tokens[right];
                score--;
                right--;
            } else
                // can't play any token in either direction — stop
                return score;
        }
        // return maximum score achieved
        return score;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(1).

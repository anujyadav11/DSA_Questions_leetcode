/*********************************************** JAVA **************************************************/

// Optimal Solution - Solves the Josephus problem recursively by mapping the winner's index from a circle of n-1 back to n people using modular arithmetic.
/* "The Josephus recurrence (f(n-1, k) + k) % n works because after removing person k, everyone shifts position — adding k and taking mod n corrects the offset. 
    The iterative version replaces recursion with a loop starting from res = 0, running for i in 2..n: res = (res + k) % i — same logic O(n) time but O(1) space." */

class Solution {
    public int findTheWinner(int n, int k) {
        // convert 0-indexed result to 1-indexed winner
        return findIndex(n, k) + 1;
    }
    public int findIndex(int n, int k) {
        // base case: only one person — winner is at index 0
        if (n == 1)
            return 0;
        // get winner index in circle of n-1 people
        int idx = findIndex(n - 1, k);
        // map index back to circle of n people
        return (idx + k) % n;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

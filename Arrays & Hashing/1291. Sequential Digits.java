/*********************************************** JAVA **************************************************/

// Optimal Solution - Generates all sequential digit numbers in [low, high] using BFS, extending each number by appending its next consecutive digit.
/* "There are only 36 possible sequential digit numbers total — 9 of length 1, 8 of length 2, down to 1 of length 9. BFS from digits 1–9 generates them in sorted order naturally, making this effectively O(1). 
    The key extension formula is n*10 + (lastDigit+1) with a guard that lastDigit < 9." */

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        // BFS queue seeded with all single digits 1-9
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= 9; i++)
            q.offer(i);
        while (!q.isEmpty()) {
            int n = q.poll();
            // all further numbers will also exceed high — safe to stop
            if (n > high)
                break;
            // n is within [low, high] — valid sequential number
            if (low <= n)
                res.add(n);
            // get last digit to determine next sequential digit to append
            int ones = n % 10;
            // only extend if last digit is not 9 (no digit after 9)
            if (ones < 9)
                q.offer(n * 10 + (ones + 1));
        }
        // BFS guarantees results are in ascending order
        return res;
    }
}

// Time Complexity :- O(1).
// Space Complexity :- O(1).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Implements weighted random index selection using in-place prefix sums and lower-bound binary search to map uniform random numbers to weight-proportional indices.
/*  "Prefix sums transform weights into ranges — index i owns range (wSums[i-1], wSums[i]]. A uniform random in [1, total] falls in exactly one range. Lower-bound binary search finds it in O(log n). 
    Never add an early return for == in lower-bound search — always let right = mid handle it to find the leftmost valid position." */

class Solution {
    Random random;
    int[] wSums;
    public Solution(int[] w) {
        this.random = new Random();
        // build prefix sum array in-place — wSums[i] = total weight up to index i
        for (int i = 1; i < w.length; i++)
            w[i] += w[i - 1];
        this.wSums = w;
    }
    public int pickIndex() {
        int len = wSums.length;
        // pick random number in range [1, totalWeight] inclusive
        int idx = random.nextInt(wSums[len - 1]) + 1;
        int left = 0, right = len - 1;
        // find leftmost index where wSums[mid] >= idx
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (wSums[mid] < idx)
                // target is in right half
                left = mid + 1;
            else
                // wSums[mid] >= idx — could be answer, search left
                right = mid;
        }
        // left == right — found the target index
        return left;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(1).

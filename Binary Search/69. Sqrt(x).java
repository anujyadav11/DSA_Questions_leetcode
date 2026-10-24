/*********************************************** JAVA **************************************************/

// Optimal Solution - Solved Sqrt(x) using binary search and overflow-safe multiplication in O(log x) time and O(1) auxiliary space.
/* “I use binary search over the possible integer square roots. For each midpoint, I calculate its square using long to prevent integer overflow. 
    If the square is too small, I search higher; if it is too large, I search lower. When the search ends, high contains the largest integer whose square does not exceed x.” */

class Solution {
    public int mySqrt(int x) {
        // Handle the smallest input.
        if (x < 2) {
            return x;
        }
        int low = 1;
        int high = x / 2;
        // Binary search for the integer square root.
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // Use long to prevent overflow when squaring mid.
            long square = (long) mid * mid;
            if (square == x) {
                return mid;
            } else if (square < x) {
                // mid is a valid candidate; try a larger value.
                low = mid + 1;
            } else {
                // mid is too large; search the left half.
                high = mid - 1;
            }
        }
        // high is the largest integer whose square is <= x.
        return high;
    }
}

// Time Complexity :- O(log x).
// Space Complexity :- O(1).

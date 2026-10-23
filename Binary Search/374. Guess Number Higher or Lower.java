/*********************************************** JAVA **************************************************/

// Optimal Solution - Solved Guess Number Higher or Lower using binary search in O(log n) time and O(1) auxiliary space.
/* “I use binary search over the range [1, n]. At each iteration, I query the middle value. If the API confirms it, I return it; 
    otherwise, I discard the half that cannot contain the hidden number. This finds the answer in logarithmic time.” */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        // Search for the hidden number using binary search.
        while (low <= high) {
            // Calculate the middle number safely.
            int mid = low + (high - low) / 2;
            // Compare mid with the hidden number.
            int val = guess(mid);
            if (val == 0) {
                // Found the hidden number.
                return mid;
            } else if (val == -1) {
                // The hidden number is smaller than mid.
                high = mid - 1;
            } else {
                // The hidden number is greater than mid.
                low = mid + 1;
            }
        }
        // Unreachable for valid problem inputs.
        return -1;
    }
}

// Time Complexity :- O(log n).
// Space Complexity :- O(1).

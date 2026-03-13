/*********************************************** JAVA **************************************************/

// Optimal Solution - Use a circular sliding window to compute sums of the next or previous k elements efficiently.
/* "Since the array is circular, I use modulo indexing and maintain a sliding window of size |k|. Instead of recomputing the sum for each position, 
      I update the window by subtracting the outgoing element and adding the incoming element." */

class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;        // Length of the circular array
        int[] result = new int[n];  // Result array to store decrypted values
        // If k == 0, all elements remain 0
        if (k == 0)
            return result;
        int start = 1, end = k, windowSum = 0;
        // If k is negative, we sum the previous |k| elements instead
        if (k < 0) {
            start = n - Math.abs(k);
            end = n - 1;
        }
        // Compute initial window sum
        for (int i = start; i <= end; i++)
            windowSum += code[i];
        // Sliding window across circular array
        for (int i = 0; i < n; i++) {
            // Assign current window sum to result
            result[i] = windowSum;
            // Remove the outgoing element from the window
            windowSum -= code[start % n];
            // Add the next incoming element into the window
            windowSum += code[(end + 1) % n];
            // Move window forward
            start++;
            end++;
        }
        return result;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

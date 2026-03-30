/*********************************************** JAVA **************************************************/

// Optimal Solution - Applies range shifts to a string efficiently using a difference array and prefix sums, handling forward and backward shifts with modular wraparound.
/* "Whenever multiple range updates are followed by point queries, difference array is the pattern — O(1) per update, O(n) to resolve. 
    The key detail here is normalizing the prefix sum with % 26 and +26 for negatives before applying to the character — otherwise the modulo arithmetic breaks for large or negative shifts." */

class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        // difference array to accumulate net shifts at each index
        int[] arr = new int[n];
        for (int[] shift : shifts) {
            if (shift[2] == 1) {
                // forward shift: increment at start, decrement after end
                arr[shift[0]]++;
                if (shift[1] + 1 < n) arr[shift[1] + 1]--;
            } else {
                // backward shift: decrement at start, increment after end
                arr[shift[0]]--;
                if (shift[1] + 1 < n) arr[shift[1] + 1]++;
            }
        }
        StringBuilder res = new StringBuilder(s);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            // prefix sum gives net shift at index i
            sum = (sum + arr[i]) % 26;
            // normalize negative sum for backward shifts
            if (sum < 0) sum += 26;
            // apply net shift to current character with wraparound
            res.setCharAt(i, (char) ('a' + (s.charAt(i) - 'a' + sum) % 26));
        }
        // return the fully shifted string
        return res.toString();
    }
}

// Time Complexity :- O(n + k).
// Space Complexity :- O(n).

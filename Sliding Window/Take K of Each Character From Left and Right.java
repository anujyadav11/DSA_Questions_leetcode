/*********************************************** JAVA **************************************************/

// Optimal Solution - Use sliding window to find the largest removable substring while maintaining at least k of each character outside.
/* “Instead of picking from ends, I find the largest middle substring we can keep such that at least k of each character remains outside.” */

class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int countA = 0, countB = 0, countC = 0;
        // Count total occurrences
        for (char ch : s.toCharArray()) {
            if (ch == 'a') countA++;
            else if (ch == 'b') countB++;
            else countC++;
        }
        // If not enough characters → impossible
        if (countA < k || countB < k || countC < k)
            return -1;
        int i = 0, j = 0;
        int notDel = 0; // max window we keep
        // Sliding window
        while (j < n) {
            // Remove current character from available count
            if (s.charAt(j) == 'a') countA--;
            else if (s.charAt(j) == 'b') countB--;
            else countC--;
            // Shrink window if invalid
            while (i <= j && (countA < k || countB < k || countC < k)) {
                if (s.charAt(i) == 'a') countA++;
                else if (s.charAt(i) == 'b') countB++;
                else countC++;
                i++;
            }
            // Max window we can keep
            notDel = Math.max(notDel, j - i + 1);
            j++;
        }
        // Answer = total - max kept window
        return n - notDel;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

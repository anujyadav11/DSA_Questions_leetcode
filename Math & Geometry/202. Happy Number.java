/*********************************************** JAVA **************************************************/

// Optimal Solution - Uses cycle detection with a hash set to determine whether a number is happy. Either the process reaches 1, or it loops—use a set to detect repetition and stop early.
/* “I repeatedly replace the number with the sum of the squares of its digits. If the result becomes 1, the number is happy. Otherwise, unhappy numbers eventually enter a cycle. 
    I use a HashSet to store previously seen values, and if a value repeats, I return false.” */

class Solution {
    public boolean isHappy(int n) {
        // Stores numbers that we have already encountered.
        // If a number appears again, we are stuck in a cycle.
        Set<Integer> usedInt = new HashSet<>();
        while (true) {
            int sum = 0;
            // Calculate the sum of squares of digits
            while (n != 0) {
                int digit = n % 10;
                // Add square of the current digit
                sum += digit * digit;
                n = n / 10;
            }
            // Reaching 1 means the number is happy
            if (sum == 1) return true;
            // Continue the process with the new number
            n = sum;
            // If we've already seen this number,
            // the sequence is cycling forever.
            if (usedInt.contains(n)) return false;
            usedInt.add(n);
        }
    }
}

// Time Complexity :- O(log n).
// Space Complexity :- O(log n).

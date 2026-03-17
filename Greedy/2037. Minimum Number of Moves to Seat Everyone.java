/*********************************************** JAVA **************************************************/

// Optimal Solution - Sort seats and students, then greedily match positions to minimize total movement.
/* "To minimize total movement, I match the closest positions by sorting both arrays and pairing them index-wise. This avoids inefficient cross assignments." */

class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int totalMoves = 0; // Stores total number of moves required
        // Sort both arrays so we can match closest pairs
        Arrays.sort(seats);
        Arrays.sort(students);
        // Match each student to the corresponding seat
        for (int i = 0; i < seats.length; i++) {
            // Add distance between student and seat
            totalMoves += Math.abs(seats[i] - students[i]);
        }
        return totalMoves;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(1).

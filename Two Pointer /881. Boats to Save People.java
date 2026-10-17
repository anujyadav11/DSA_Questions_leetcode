/*********************************************** JAVA **************************************************/

// Optimal Solution - Solved Boats to Save People using a greedy two-pointer approach after sorting weights.
/* “I sort the weights and process the heaviest person first. If the lightest remaining person can share their boat without exceeding the limit, 
    I pair them; otherwise, the heaviest goes alone. This greedy strategy minimizes the number of boats.” */

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people); // Sort people by weight
        int left = 0;
        int right = people.length - 1;
        int boats = 0;
        // Each iteration sends at least one person on a boat
        while (left <= right) {
            // Pair the lightest and heaviest if they fit
            if (people[left] + people[right] <= limit) {
                left++;
            }
            // The heaviest person always gets a boat
            right--;
            boats++;
        }
        return boats;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(1).

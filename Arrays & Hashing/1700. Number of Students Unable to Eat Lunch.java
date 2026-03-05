/*********************************************** JAVA **************************************************/

// Optimal Solution - Count student preferences and simulate sandwich consumption without queue rotation.
                    // “Instead of simulating the queue, I track how many students prefer each sandwich type and stop when a sandwich cannot be matched.”

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;   // Total number of students
        // Array to count how many students prefer 0 and 1
        int[] arr = new int[2];
        // Count student preferences
        for (int stud : students) {
            arr[stud]++;   // arr[0] = students who want circular, arr[1] = students who want square
        }
        // Traverse sandwiches stack
        for (int i = 0; i < n; i++) {
            int sand = sandwiches[i];   // Current sandwich type
            // If no student prefers this sandwich type
            if (arr[sand] == 0) {
                // Remaining students cannot eat
                return n - i;
            }
            // One student takes this sandwich
            arr[sand]--;
        }
        // All students got sandwiches
        return 0;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

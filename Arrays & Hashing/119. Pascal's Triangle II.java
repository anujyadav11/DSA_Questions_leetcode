/*********************************************** JAVA **************************************************/

// Optimal Solution - Build Pascal’s Triangle row iteratively using previous row values and return the required row.
                      // “Each row depends only on the previous row, so I iteratively build rows using DP and keep only one row in memory.”

class Solution {
    public List<Integer> getRow(int rowIndex) {
        // Initialize the list to store the current row
        List<Integer> prev = new ArrayList<>();
        // Add the first element of Pascal's triangle
        prev.add(1);
        // Loop to generate the next row up to the specified rowIndex
        for (int i = 1; i <= rowIndex; i++) {
            // Initialize a new list for the current row
            List<Integer> curr = new ArrayList<>();
            // Add the first element of the current row
            curr.add(1);
            // Loop to generate elements from the second to second last in the current row
            for (int j = 1; j < i; j++) {
                // Calculate the value by summing the elements from the previous row
                curr.add(prev.get(j) + prev.get(j - 1));
            }
            // Add the last element of the current row
            curr.add(1);
            // Update the previous row to the current row for the next iteration
            prev = curr;
        }
        // Return the last generated row
        return prev;
    }
}

// Time Complexity :- O(n^2).
// Space Complexity :- O(n).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Simulate grid movement and use a HashSet to detect revisited coordinates.
                      // “I simulate movement and store visited coordinates in a set. If any coordinate is revisited, the path crosses itself.”

class Solution {
    public boolean isPathCrossing(String path) {
        // Set to store visited coordinates
        Set<String> visited = new HashSet<>();
        int x = 0;  // X-coordinate
        int y = 0;  // Y-coordinate
        // Add starting point (0,0)
        visited.add(x + "," + y);
        // Traverse each movement character
        for (char move : path.toCharArray()) { 
            // Update coordinates based on direction
            if (move == 'N') {
                y++;
            } else if (move == 'S') {
                y--;
            } else if (move == 'E') {
                x++;
            } else if (move == 'W') {
                x--;
            }
            // Create coordinate string
            String coordinates = x + "," + y;
            // If already visited → path crosses
            if (visited.contains(coordinates)) {
                return true;
            }
            // Mark current coordinate as visited
            visited.add(coordinates);
        }
        return false;  // No crossing found
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Store all starting cities and return the destination city that never appears as a source.
                      // “The destination city is the only city with no outgoing edge, so I store all sources and return the city not present in that set.”

class Solution {
    public String destCity(List<List<String>> paths) {
        // Set to store all starting cities
        Set<String> starts = new HashSet<>();
        // Add all source cities
        for (List<String> path : paths) {
            starts.add(path.get(0)); // from city
        }
        // Find city that is never a start
        for (List<String> path : paths) {
            String destination = path.get(1);
            if (!starts.contains(destination)) {
                return destination; // This is the final destination
            }
        }
        return ""; // Fallback (problem guarantees answer exists)
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

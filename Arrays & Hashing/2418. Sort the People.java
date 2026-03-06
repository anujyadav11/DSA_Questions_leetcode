/*********************************************** JAVA **************************************************/

// Optimal Solution - Map heights to names, sort heights, and retrieve names in descending order of height.
                      // “I map heights to names, sort the heights array, and traverse it in reverse order to produce names sorted by decreasing height.”

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        // Create a HashMap to store height-name pairs
        Map<Integer, String> map = new HashMap<>();
        // Populate the map with heights as keys and names as values
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        // Sort the heights array in ascending order
        Arrays.sort(heights);
        // Create a result array to store sorted names
        String[] result = new String[heights.length];
        // Iterate through sorted heights array in descending order
        int index = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            // Retrieve the name corresponding to the height from the map
            result[index] = map.get(heights[i]);
            index++;
        }
        // Return the sorted array of names
        return result;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(n).

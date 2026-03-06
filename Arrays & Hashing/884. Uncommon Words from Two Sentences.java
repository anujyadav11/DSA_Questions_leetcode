/*********************************************** JAVA **************************************************/

// Optimal Solution - Count word frequencies across both sentences and return words that appear exactly once.
                    //“I combine both sentences into a frequency map and collect words that appear exactly once.”

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) { 
        // Map to store frequency of each word
        Map<String, Integer> map = new HashMap<>();
        // Split first sentence into words and count frequencies
        for (String s : s1.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        // Split second sentence into words and update frequencies
        for (String s : s2.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        // List to store uncommon words
        List<String> list = new ArrayList<>();
        // Traverse map entries
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            // Word is uncommon if it appears exactly once
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        // Convert list to array
        String[] res = new String[list.size()];
        list.toArray(res);
        return res;
    }
}

// Time Complexity :- O(n + m).
// Space Complexity :- O(n + m).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Sorts characters by descending frequency using a max heap, appending each character exactly as many times as it appears.
/* "HashMap handles all character types safely unlike a fixed array. The max heap gives O(k log k) ordering by frequency — for follow-up, 
    bucket sort on frequency achieves O(n) since max frequency is bounded by string length." */

class Solution {
    public String frequencySort(String s) {
        // count frequency of every character (supports all ASCII)
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray())
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        // max heap: higher frequency characters come first
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a, b) -> freqMap.get(b) - freqMap.get(a)
        );
        // add all unique characters into the heap
        maxHeap.addAll(freqMap.keySet());
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            // append character exactly freq times
            int freq = freqMap.get(ch);
            for (int i = 0; i < freq; i++)
                sb.append(ch);
        }
        // return frequency sorted string
        return sb.toString();
    }
}

// Time Complexity :- O(n log n + k).
// Space Complexity :- O(n).

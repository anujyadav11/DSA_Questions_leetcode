/*********************************************** JAVA **************************************************/

// Optimal Solution - Greedy solution that partitions the string by expanding segments to include the last occurrence of each character.
                   // Precompute each character’s last index, then greedily extend the current partition until all included characters are closed — cut only when safe.

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partitions = new ArrayList<>();
        // Store last occurrence of each character
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        // Build each partition greedily
        for (int i = 0; i < s.length(); i++) {
            // Partition must include this character's last occurrence
            end = Math.max(end, last[s.charAt(i) - 'a']);
            // All characters in the partition are complete
            if (i == end) {
                partitions.add(end - start + 1);
                start = i + 1;
            }
        }
        return partitions;
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(1).

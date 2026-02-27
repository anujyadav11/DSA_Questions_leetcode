/*********************************************** JAVA **************************************************/

// Optimal Solution - Count frequencies using HashMap and ensure every element appears an even number of times.
                      // “To form equal pairs, each element must have even frequency, so I count occurrences and check parity.”

class Solution {
    public boolean divideArray(int[] nums) {
        int n = nums.length;
        // If total elements are odd, can't form pairs
        if (n % 2 != 0)
            return false;
        // Map to store frequency of each number
        Map<Integer, Integer> map = new HashMap<>();
        // Count occurrences
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // Check if every frequency is even
        for (int freq : map.values()) {
            if (freq % 2 != 0) {
                return false;   // If any frequency is odd → not possible
            }
        }
        return true;   // All frequencies even → possible
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

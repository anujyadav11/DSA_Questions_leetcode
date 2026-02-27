/*********************************************** JAVA **************************************************/

// Optimal Solution - Count frequencies and sum C(freq, 2) for each number to compute total identical index pairs.
                      // “Instead of checking all pairs (O(n²)), I count frequencies and use the combination formula kC2 to compute pairs in O(n).”

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int n = nums.length;      // Length of array
        int[] counts = new int[101];  // Frequency array (nums[i] ≤ 100)
        // Count frequency of each number
        for (int num : nums) {
            counts[num]++;
        }
        int res = 0;  // Stores total good pairs
        // For each number frequency
        for (int count : counts) {
            // If frequency ≥ 2, compute combinations
            if (count > 1) {
                // Number of pairs = C(count, 2)
                res += (count * (count - 1)) / 2;
            }
        }
        return res;  // Return total pairs
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

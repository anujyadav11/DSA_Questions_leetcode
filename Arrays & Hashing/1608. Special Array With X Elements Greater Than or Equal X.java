/*********************************************** JAVA **************************************************/

// Optimal Solution - Use frequency counting and cumulative sums to find x such that exactly x elements are ≥ x.
                    // “Instead of repeatedly counting elements ≥ x, I precompute frequencies and use a reverse cumulative sum to check the condition efficiently.”

class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;          // Length of the array
        // Frequency array where index represents value
        // Size n+1 because values greater than n are grouped into n
        int[] freq = new int[n + 1];
        // Build frequency counts
        for (int i = 0; i < n; i++) {
            int num = nums[i];   
            // Any value greater than n is treated as n
            // because x cannot exceed n
            freq[Math.min(num, n)]++;
        }
        int cumSum = 0;   // Cumulative count of numbers >= current x
        // Traverse from largest possible x to smallest
        for (int x = n; x >= 0; x--) {
            // Add frequency of numbers equal to x
            cumSum += freq[x];
            // If exactly x numbers are >= x
            if (cumSum == x) {
                return x;
            }
        }
        // If no such x exists
        return -1;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

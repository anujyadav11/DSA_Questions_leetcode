/*********************************************** JAVA **************************************************/

// Optimal Solution - Solved Contains Duplicate II using a sliding window and HashSet for O(n) average time and O(min(n, k + 1)) auxiliary space.
/* “I maintain a sliding window of at most k + 1 elements using a HashSet. Before processing each element, I remove elements that are more than k indices away. 
    If the current element already exists in the set, a nearby duplicate exists, so I return true. Otherwise, I insert it and continue.” */

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        // Stores elements in the current sliding window.
        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < n; j++) {
            // Keep the window size at most k.
            while (j - i > k) {
                set.remove(nums[i]);
                i++;
            }
            // A duplicate within distance k exists.
            if (set.contains(nums[j])) {
                return true;
            }
            // Add the current element to the window.
            set.add(nums[j]);
        }
        return false;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(Min(n, k + 1)).

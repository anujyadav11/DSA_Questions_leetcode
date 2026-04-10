/*********************************************** JAVA **************************************************/

// Optimal Solution - Use a sliding window with a TreeMap to maintain min and max efficiently and keep the window valid.
/* “I use a sliding window and a TreeMap to track min and max in O(log n), shrinking the window whenever the difference exceeds the limit.” */

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        // TreeMap to maintain sorted elements in current window
        // key = number, value = frequency
        TreeMap<Integer, Integer> st = new TreeMap<>();
        int i = 0;   // Left pointer
        int j = 0;   // Right pointer
        int maxLen = 0;  // Result: maximum valid window size
        // Expand window
        while (j < n) {
            // Add current element to TreeMap
            st.put(nums[j], st.getOrDefault(nums[j], 0) + 1);
            // Shrink window if max - min > limit
            while (st.lastKey() - st.firstKey() > limit) {
                // Decrease frequency of left element
                st.put(nums[i], st.get(nums[i]) - 1);
                // Remove if frequency becomes 0
                if (st.get(nums[i]) == 0) {
                    st.remove(nums[i]);
                }   
                i++;  // Move left pointer
            }
            // Update maximum length
            maxLen = Math.max(maxLen, j - i + 1);   
            j++;  // Expand window
        }
        return maxLen;
    }
}

// Time Complexity :- O(n log n). log n for insertion in treeMap.
// Space Complexity :- O(n).

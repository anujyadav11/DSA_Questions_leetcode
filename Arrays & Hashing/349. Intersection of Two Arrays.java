/*********************************************** JAVA **************************************************/

// Optimal Solution - Use HashSet to detect unique intersection elements between two arrays in linear time.
                    // “I store elements of the first array in a HashSet and check membership while traversing the second array to build the unique intersection.”

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Set to store unique elements from nums1
        HashSet<Integer> set = new HashSet<>();
        // Set to store intersection results (ensures uniqueness)
        HashSet<Integer> result = new HashSet<>();
        // Add all elements of nums1 into the set
        for (int n : nums1) {
            set.add(n);
        }
        // Traverse nums2
        for (int n : nums2) {
            // If element exists in nums1 set → intersection found
            if (set.contains(n)) {
                result.add(n); // add to result set
            }
        }
        // Convert result set to array
        int[] ans = new int[result.size()];
        int i = 0;
        for (int n : result) {
            ans[i++] = n;
        }
        return ans;
    }
}

// Time Complexity :- O(m + n).
// Space Complexity :- O(m + n).

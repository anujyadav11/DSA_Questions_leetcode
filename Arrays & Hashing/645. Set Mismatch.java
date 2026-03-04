/*********************************************** JAVA **************************************************/

// Optimal Solution - Use a HashSet to detect the duplicate number and scan the range 1..n to find the missing value.
                      // “Since numbers should be from 1 to n, I track duplicates using a set and then scan the range to find the missing number.”

class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;   // Length of array
        int missing = 0;       // Stores the missing number
        int doubleVal = 0;     // Stores the duplicated number
        // Set to track numbers already seen
        Set<Integer> set = new HashSet<>();
        // Traverse the array to detect duplicate
        for (int i = 0; i < n; i++) {
            // If number already exists in set → duplicate found
            if (set.contains(nums[i]))
                doubleVal = nums[i];   
            // Add number to set
            set.add(nums[i]);
        }
        // Check numbers from 1 to n to find missing value
        for (int i = 1; i <= n; i++) {   
            // If number not present in set → missing number
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }
        // Return result: {duplicate, missing}
        return new int[] { doubleVal, missing };
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

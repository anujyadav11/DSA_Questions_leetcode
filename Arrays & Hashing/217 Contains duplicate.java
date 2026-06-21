/********************************* JAVA ***************************************/

// Better Approach 
class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length; // Get the length of the array
        Set<Integer> set = new HashSet<>(); // Create a HashSet to store unique elements
        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // If the element is already in the set, a duplicate exists
            if (set.contains(nums[i])) {
                return true; // Return true immediately if a duplicate is found
            }
            // Otherwise, add the element to the set
            set.add(nums[i]);
        }
        // If no duplicates are found, return false
        return false;
    }
}
//Time Complexity - O(n).
//Space Complexity - O(n).

// Optimal Approach : Using HashMap.
    
    class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Stores all unique numbers encountered so far
        HashSet<Integer> set = new HashSet<>();
        // Iterate through each number in the array
        for (int num : nums) {
            // If the number is already present,
            // we found a duplicate
            if (set.contains(num)) {
                return true;
            }
            // Add the current number to the set
            set.add(num);
        }
        // No duplicates found
        return false;
    }
}


// Brute Force Approach
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Step 1: Sort the array
        // After sorting, any duplicate elements will be adjacent
        Arrays.sort(nums);
        int n = nums.length;
        // Step 2: Traverse the array and check adjacent elements
        for (int i = 0; i < n - 1; i++) {
            // If two consecutive elements are equal, a duplicate exists
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        // Step 3: If no duplicates are found
        return false;
    }
}
// Time Complexity - O(n log n).
// Space Complexity - O(1).

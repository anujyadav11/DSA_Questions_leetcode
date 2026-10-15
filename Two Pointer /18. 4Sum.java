/*********************************************** JAVA **************************************************/

// Optimal Solution - Solve 4Sum using sorting, nested loops, and two pointers with duplicate elimination in O(n³) time.
/* “I sort the array and fix the first two elements using nested loops. For each pair, I use two pointers to find the remaining two elements. 
    Based on the current sum, I move the left or right pointer. I also skip duplicate values to ensure that every quadruplet is unique.  */

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // Sort the array to use two pointers and skip duplicates.
        Arrays.sort(nums);
        // Fix the first element of the quadruplet.
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // Fix the second element.
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                // Find the remaining two elements using two pointers.
                int k = j + 1, l = n - 1;
                while (k < l) {
                    // Use long to prevent integer overflow.
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        // Found a valid quadruplet.
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        // Skip duplicate third and fourth elements.
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) {
                        // Increase the sum by moving the left pointer.
                        k++;
                    } else {
                        // Decrease the sum by moving the right pointer.
                        l--;
                    }
                }
            }
        }
        return res;
    }
}

// Time Complexity :- O(n^3).
// Space Complexity :- O(log n).

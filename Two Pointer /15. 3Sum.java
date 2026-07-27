/*********************************************** JAVA **************************************************/

// Optimal Solution - Solved 3Sum using sorting and the two-pointer technique to find all unique triplets with sum equal to zero in O(n²) time.
/* "After sorting, fixing one number reduces the problem to finding a pair with a target sum. Since the array is sorted, 
    two pointers can efficiently adjust based on whether the current sum is too small or too large, and duplicate values are skipped to ensure only unique triplets are returned." */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    res.add(temp);
                    j++;
                    k--;
                    // Skip duplicate second elements
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    // Skip duplicate third elements
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return res;
    }
}

// Time Complexity :- O(n log n + n^2).
// Space Complexity :- O(n). for the output if exclude that O(1).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Generate all unique subsets using backtracking by sorting the array and skipping duplicates at the same recursion level.
/* “I first sort the array so duplicate values become adjacent. I generate subsets using backtracking, adding the current subset at every recursion level. To avoid duplicate subsets, 
    I skip a value when it is equal to the previous value and both are being considered at the same recursion level. This removes duplicates without needing an additional result-set lookup.” */

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Sort so duplicate values are adjacent
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }
    public void backtrack(int[] nums, int index, List<Integer> subList) {
        // Add every valid subset
        res.add(new ArrayList<>(subList));
        for (int i = index; i < nums.length; i++) {
            // Skip duplicate choices at the same recursion level
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            // Choose
            subList.add(nums[i]);
            // Explore
            backtrack(nums, i + 1, subList);
            // Backtrack
            subList.remove(subList.size() - 1);
        }
    }
}

// Time Complexity :- O(n * n^2).
// Space Complexity :- O(n).

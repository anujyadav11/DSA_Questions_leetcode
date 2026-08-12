/*********************************************** JAVA **************************************************/

// Optimal Solution - Generate all unique combinations using backtracking with sorting and duplicate-skipping, ensuring each number is used at most once.

class Solution {
    // Stores all valid combinations
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Sort the array so that:
        // 1. We can easily skip duplicate candidates.
        // 2. We can stop when nums[i] > target.
        Arrays.sort(candidates);
        // Start backtracking from index 0
        findSum(candidates, target, 0, new ArrayList<>());
        return res;
    }
    public void findSum(int[] nums,int target,int index,List<Integer> subList) {
        // Target reached exactly.
        // Current combination is valid.
        if (target == 0) {
            res.add(new ArrayList<>(subList));
            return;
        }
        // Try every candidate starting from index.
        for (int i = index; i < nums.length; i++) {
            // Since the array is sorted, all following values
            // will also be greater than target.
            if (nums[i] > target) {
                break;
            }
            // Skip duplicate values at the SAME recursion level.
            // At the same level, choosing the second 1 would
            // produce the same combination as choosing the first 1.
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            // Choose nums[i]
            subList.add(nums[i]);
            // Move to i + 1 because every candidate can
            // be used at most once.
            findSum(nums,target - nums[i],i + 1,subList);
            // Backtrack:
            // Remove the selected element before trying
            // the next candidate.
            subList.remove(subList.size() - 1);
        }
    }
}
// Time Complexity :- O(2ⁿ).
// Space Complexity :- O(N).

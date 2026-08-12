/*********************************************** JAVA **************************************************/

// Optimal Solution - Find all unique combinations using backtracking by choosing or skipping candidates while allowing unlimited reuse.

class Solution {
    // Stores all valid combinations
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Start backtracking from index 0
        // with an empty combination
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
        // If target becomes negative, this combination
        // can no longer produce a valid answer.
        // If index reaches the end, there are no more
        // candidates to consider.
        if (target < 0 || index >= nums.length) {
            return;
        }
        // --------------------------------
        // Choice 1: Take nums[index]
        // --------------------------------
        subList.add(nums[index]);
        // We keep the same index because a candidate
        // can be used unlimited times.
        findSum(nums,target - nums[index],index,subList);
        // Backtrack:
        // Remove the number before exploring
        // the "skip" choice.
        subList.remove(subList.size() - 1);
        // --------------------------------
        // Choice 2: Skip nums[index]
        // --------------------------------
        findSum(nums,target,index + 1,subList);
    }
}

// Time Complexity :- O(2ᵗ). T = target
// Space Complexity :- O(T).

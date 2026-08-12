/*********************************************** JAVA **************************************************/

// Optimal Solution - Generate all subsets using backtracking by exploring inclusion and exclusion of each element.

class Solution {
    // Stores all generated subsets
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        // Start building subsets from index 0
        // with an initially empty subset
        findSubset(nums, 0, new ArrayList<>());
        return res;
    }
    public void findSubset(int[] nums,int index,List<Integer> subList) {
        // We have considered every element.
        // Store a copy of the current subset.
        if (index == nums.length) {
            res.add(new ArrayList<>(subList));
            return;
        }
        // -------------------------------
        // Choice 1: Include nums[index]
        // -------------------------------
        subList.add(nums[index]);
        // Move to the next element
        findSubset(nums, index + 1, subList);
        // -------------------------------
        // Backtrack
        // Remove the element we just added
        // so we can explore the other choice.
        // -------------------------------
        subList.remove(subList.size() - 1);
        // -------------------------------
        // Choice 2: Exclude nums[index]
        // -------------------------------
        findSubset(nums, index + 1, subList);
    }
}

// Time Complexity :- O(2ⁿ × N).
// Space Complexity :- O(N).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Generate all possible permutations using backtracking by choosing unused elements at each step.
/* “I use backtracking to construct the permutation one position at a time. At each level, I choose an unused number, recurse, 
    and then remove it to explore the next choice. Once the current list reaches the length of the input, I store a copy as a complete permutation.” */

class Solution {
    // Stores all permutations
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        // Start with an empty permutation
        backtrack(nums, res, new ArrayList<>());
        return res;
    }
    public void backtrack(int[] nums,List<List<Integer>> res,List<Integer> subList) {
        // A complete permutation is formed
        if (subList.size() == nums.length) {
            res.add(new ArrayList<>(subList));
            return;
        }
        // Try every number at the current position
        for (int num : nums) {
            // Skip numbers already used
            if (subList.contains(num)) {
                continue;
            }
            // Choose
            subList.add(num);
            // Explore
            backtrack(nums, res, subList);
            // Backtrack
            subList.remove(subList.size() - 1);
        }
    }
}

// Time Complexity :- O(n · n!).
// Space Complexity :- O(n).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Implemented backtracking with sorting, index tracking, and duplicate pruning to generate unique permutations without post-processing duplicate results.
/* "I solve this problem using backtracking with duplicate pruning. First, I sort the array so duplicate elements are adjacent. I maintain a boolean array to track which indices have been selected. During recursion, 
    I skip an element if it is identical to its previous element and that previous element has not been used in the current permutation. This prevents duplicate permutations from being generated in the first place. 
    Once the temporary list reaches the input length, I store a copy in the result." */

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // Sort the array so duplicate elements are adjacent.
        Arrays.sort(nums);
        // Track which indices have already been selected.
        boolean[] used = new boolean[nums.length];
        // Start generating unique permutations.
        backtrack(res, new ArrayList<>(), nums, used);
        return res;
    }
    private void backtrack(List<List<Integer>> res,List<Integer> temp,int[] nums,boolean[] used) {
        // A complete permutation has been generated.
        if (temp.size() == nums.length) {
            // Store a copy because temp will be modified later.
            res.add(new ArrayList<>(temp));
            return;
        }
        // Try every available element.
        for (int i = 0; i < nums.length; i++) {
            // Skip an already selected element.
            if (used[i]) {
                continue;
            }
            // Skip duplicates at the same recursion level.
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            // Choose the current element.
            used[i] = true;
            temp.add(nums[i]);
            // Explore the next position.
            backtrack(res, temp, nums, used);
            // Backtrack: undo the current choice.
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}

// Time Complexity :- O(n log n + n * U).
// Space Complexity :- O(N * U).

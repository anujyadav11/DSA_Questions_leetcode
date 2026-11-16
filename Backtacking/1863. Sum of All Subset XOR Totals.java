/*********************************************** JAVA **************************************************/

/*********************************************** JAVA **************************************************/

// Optimal Solution - Used recursive pick/not-pick branching to explore all subsets and aggregate their XOR values in O(2ⁿ) time and O(n) auxiliary space.
/* "I solve this problem using recursive pick-or-not-pick decisions. For every array element, I explore two possibilities: include it in the current subset and update the XOR, 
    or exclude it and retain the existing XOR. Once all elements have been processed, I return the XOR total of that subset. I sum the results from both recursive branches. Since each element has two choices." */

class Solution {
    public int subsetXORSum(int[] nums) {
        // Start recursion with index 0 and XOR value 0.
        return findXorTotal(nums, 0, 0);
    }
    private int findXorTotal(int[] nums, int index, int xor) {
        // Base case: all elements have been processed.
        // Return the XOR total of the current subset.
        if (index == nums.length) {
            return xor;
        }
        // Choice 1: Include the current element in the subset.
        int pick = findXorTotal(nums,index + 1,xor ^ nums[index]);
        // Choice 2: Exclude the current element from the subset.
        int notPick = findXorTotal(nums,index + 1,xor);
        // Sum the XOR totals from both choices.
        return pick + notPick;
    }
}

// Time Complexity :- O(2^n).
// Space Complexity :- O(n).

/******************************************************* JAVA *******************************************************/
//Approach-2 (Using simple backtracking to generate subsets)
//T.C : O(n * 2^n)
//S.C : O(n * 2^n)

class Solution {
    public int subsetXORSum(int[] nums) {
        // List to store all subsets
        List<List<Integer>> subsets = new ArrayList<>();
        // Current subset being built
        List<Integer> currentSet = new ArrayList<>();
        // Generate all subsets using backtracking
        solve(nums, 0, currentSet, subsets);
        int result = 0;
        // Calculate XOR of each subset
        for (List<Integer> set : subsets) {
            int xor = 0;
            for (int num : set) {
                xor ^= num;   // XOR each element of the subset
            }
            result += xor;    // Add XOR value to final sum
        }
        return result;
    }
    public void solve(int[] nums, int index,
                      List<Integer> currentSet,
                      List<List<Integer>> subsets) {
        // Base case: if all elements are processed
        if (index == nums.length) {
            // Add a copy of the current subset
            subsets.add(new ArrayList<>(currentSet));
            return;
        }
        // Include the current element
        currentSet.add(nums[index]);
        solve(nums, index + 1, currentSet, subsets);
        // Backtrack (remove last element)
        currentSet.remove(currentSet.size() - 1);
        // Exclude the current element
        solve(nums, index + 1, currentSet, subsets);
    }
}


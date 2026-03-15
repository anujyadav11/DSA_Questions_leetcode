/*********************************************** JAVA **************************************************/

// Optimal Solution - Use recursion to generate all subsets and accumulate the XOR of each subset.
/* "Each element can either be included or excluded, forming all possible subsets. I recursively compute the XOR for both choices and sum the results." */

class Solution {
    public int subsetXORSum(int[] nums) {
        // Start recursion from index 0 with XOR value 0
        return solve(0, nums, 0);
    }
    public int solve(int index, int[] nums, int currentXor) {
        // Base case: if all elements are processed
        if (index == nums.length)
            return currentXor;  // Return XOR of this subset
        // Case 1: include the current element in the subset
        int include = solve(index + 1, nums, nums[index] ^ currentXor);
        // Case 2: exclude the current element from the subset
        int exclude = solve(index + 1, nums, currentXor);
        // Total XOR sum of both choices
        return include + exclude;
    }
}

// Time Complexity :- O(2 ^ n).
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


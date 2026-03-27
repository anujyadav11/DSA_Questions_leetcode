/*********************************************** JAVA **************************************************/

// Optimal Solution - Greedily divides a sorted array into consecutive triplets, rejecting the division if any triplet's max-min spread exceeds k.
/* "Sorting is the core insight — it guarantees consecutive elements are closest in value, so greedy triplet grouping is optimal. Check only nums[i+2] - nums[i] per group since sorting makes that the worst-case spread. 
    Using a separate index counter is cleaner and safer than computing i/3." */

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        // sort so consecutive elements are closest — minimizes group spread
        Arrays.sort(nums);
        // result holds n/3 groups of exactly 3 elements each
        int[][] result = new int[n / 3][3];
        // tracks current row index in result
        int index = 0;
        // step by 3 to process consecutive triplets
        for (int i = 0; i <= n - 3; i += 3) {
            // max diff in sorted triplet is always last - first
            if (nums[i + 2] - nums[i] > k)
                // spread exceeds k — no valid division exists
                return new int[0][0];
            // assign triplet as a new int array to current row
            result[index++] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }
        // return all valid groups
        return result;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(n).

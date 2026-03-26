/*********************************************** JAVA **************************************************/

// Optimal Solution - Computes sum of absolute differences for each element in a sorted array using prefix sums and the sorted-order property to avoid O(n²) nested loops.
/* "The sorted property is the key — it eliminates the absolute value by guaranteeing sign direction. Left differences use nums[i]*i - leftSum, right differences use rightSum - nums[i]*(n-i-1). 
    Always verify element counts carefully — off-by-one in n-i-1 vs n-i is a common mistake here." */

class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int total = 0;
        // compute total sum of all elements
        for (int num : nums)
            total += num;
        int[] res = new int[n];
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            // sum of |nums[i] - nums[j]| for all j < i (nums[i] >= nums[j] since sorted)
            int valLeft = (nums[i] * i) - leftSum;
            // sum of |nums[i] - nums[j]| for all j > i (nums[j] >= nums[i] since sorted)
            // rightSum = total - leftSum - nums[i], elements to right = n - i - 1
            // FIXED: use (n - i - 1) not (n - i) — excludes current element
            int rightSum = total - leftSum - nums[i];
            int valRight = rightSum - (nums[i] * (n - i - 1));
            // accumulate leftSum after computing valLeft
            leftSum += nums[i];
            res[i] = valLeft + valRight;
        }
        return res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

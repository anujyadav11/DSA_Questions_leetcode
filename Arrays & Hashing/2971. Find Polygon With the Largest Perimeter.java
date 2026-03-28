/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds the largest polygon perimeter by greedily checking from the largest element whether the remaining prefix sum satisfies the polygon inequality.
/* "The polygon rule generalizes the triangle inequality — sum of all sides except the largest must exceed the largest. Sorting lets us greedily try the largest element first, 
    and maintaining a running prefix sum via subtraction avoids recomputation. First valid hit is guaranteed to be the answer." */

class Solution {
    public long largestPerimeter(int[] nums) {
        long sum = 0;
        // sort ascending so largest elements are at the end
        Arrays.sort(nums);
        // compute total sum of all elements
        for (int num : nums)
            sum += num;
        int n = nums.length;
        // try largest possible polygon first — greedily shrink from right
        for (int i = n - 1; i >= 2; i--) {
            // remove current element from sum to get sum of all smaller elements
            sum -= nums[i];
            // valid polygon: sum of all other sides must exceed the largest side
            if (sum > nums[i])
                // perimeter = sum of remaining + current largest side
                return sum + nums[i];
        }
        // no valid polygon found with 3 or more sides
        return -1;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(1).

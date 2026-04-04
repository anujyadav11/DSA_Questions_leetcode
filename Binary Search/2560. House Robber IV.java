/*********************************************** JAVA **************************************************/

// Optimal Solution - Minimizes robber capability using binary search on theft value, greedily verifying k non-adjacent houses can be robbed within the candidate limit.
/* "Binary search on answer works because feasibility is monotonic — if capability mid allows robbing k houses, any larger capability also works. The greedy check skips adjacent houses with i++ inside the loop, 
    which is the classic non-adjacent selection pattern. Always double-check variable name spelling — typos like hosue are silent killers in interviews." */

class Solution {
    public int minCapability(int[] nums, int k) {
        // binary search between min and max value in nums
        int left = Arrays.stream(nums).min().getAsInt();
        int right = Arrays.stream(nums).max().getAsInt();
        int res = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(nums, mid, k)) {
                // mid capability works — try smaller
                res = mid;
                right = mid - 1;
            } else {
                // mid too small — try larger
                left = mid + 1;
            }
        }
        // return minimum capability to rob at least k houses
        return res;
    }
    public boolean isPossible(int[] nums, int mid, int k) {
        int house = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid) {
                // FIXED: typo 'hosue' corrected to 'house'
                house++;
                // skip next house — no two adjacent houses can be robbed
                i++;
            }
        }
        // check if we can rob at least k houses
        return house >= k;
    }
}

// Time Complexity :- O(n log(maxVal - minVal)).
// Space Complexity :- O(1).

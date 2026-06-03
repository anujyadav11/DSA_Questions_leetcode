/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts subarrays with exactly k distinct integers using inclusion-exclusion of two sliding window atMost(k) computations.
/*  "Exactly-k problems are almost always solved as atMost(k) - atMost(k-1) since sliding window naturally counts ≤ not ==. 
    The two bugs here are classic: shrink condition must be > k (not <= k) and left pointer moves right (left++) to shrink the window — left-- would expand it, causing infinite loop." */

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // exactly k distinct = at most k distinct - at most (k-1) distinct
        return function(nums, k) - function(nums, k - 1);
    }
    public int function(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int cnt = 0;
        // frequency map of elements in current window
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < n; right++) {
            // expand window — add nums[right]
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            // shrink when distinct count exceeds k
            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0)
                    map.remove(nums[left]);
                left++;
            }
            // all subarrays ending at right with start in [left, right] are valid
            cnt += right - left + 1;
        }
        return cnt;
    }
}

// Time Complexity :- O(2N).
// Space Complexity :- O(N).

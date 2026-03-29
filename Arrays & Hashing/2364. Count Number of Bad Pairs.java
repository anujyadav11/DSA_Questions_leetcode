/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts bad pairs by subtracting good pairs from total, where good pairs share the same i−nums[i] value tracked via a HashMap frequency count.
/* "The key algebraic step is rearranging j - i == nums[j] - nums[i] into i - nums[i] == j - nums[j] — transforming a two-variable condition into a single hashable key. 
    This reduces an O(n²) brute force to O(n) by counting complement frequencies. Always derive the invariant first, then map it." */

class Solution {
    public long countBadPairs(int[] nums) {
        long n = nums.length;
        // total pairs (i,j) where i < j
        long totalPairs = n * (n - 1) / 2;
        long goodPairs = 0;
        // maps (i - nums[i]) value to its frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // good pair condition: j - nums[j] == i - nums[i]
            int val = i - nums[i];
            // count how many previous indices share the same val
            int prevCnt = map.getOrDefault(val, 0);
            // each previous match forms a good pair with current index
            goodPairs += prevCnt;
            // update frequency of this val in map
            map.put(val, prevCnt + 1);
        }
        // bad pairs = total pairs - good pairs
        return totalPairs - goodPairs;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

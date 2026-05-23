/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts tuples with equal products by finding pair combinations sharing the same product and multiplying by 8 for all valid tuple arrangements.
/*  "The × 8 multiplier comes from: 2 ways to swap (a,b) with (c,d), × 2 ways to reverse within first pair, × 2 ways to reverse within second pair = 8. 
    This is a classic 'count arrangements' pattern — compute combinations first then multiply by the fixed arrangement count. Using map.values() instead of entrySet() is cleaner when keys aren't needed." */

class Solution {
    public int tupleSameProduct(int[] nums) {
        // map product to count of pairs that produce it
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }
        int ans = 0;
        for (int count : map.values()) {
            if (count >= 2) {
                // C(count, 2) pairs of pairs share the same product
                int pairs = (count * (count - 1)) / 2;
                // each pair of pairs gives 8 valid tuples (a,b,c,d) arrangements
                ans += pairs * 8;
            }
        }
        return ans;
    }
}

// Time Complexity :- O(n^2).
// Space Complexity :- O(n^2).

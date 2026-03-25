/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds the minimum subarray to remove so the remaining sum is divisible by p, using prefix sum remainders and a HashMap for O(n) lookup.
/* "The key insight is (curr - prev) % p == target means subarray (prev, curr] has the exact remainder we need to remove. Always store the latest index per remainder — not the earliest — 
    since we want the shortest subarray, meaning the closest previous occurrence." */

class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int sum = 0;
        // compute total sum mod p to find how much we need to remove
        for (int num : nums)
            sum = (sum + num) % p;
        // remainder that a subarray must have to make total divisible by p
        int target = sum % p;
        // already divisible, no removal needed
        if (target == 0)
            return 0;
        // stores last seen index of each prefix sum remainder
        Map<Integer, Integer> map = new HashMap<>();
        // prefix sum of empty subarray has remainder 0 at index -1
        map.put(0, -1);
        int curr = 0;
        // worst case is removing entire array which is invalid
        int res = n;
        for (int j = 0; j < n; j++) {
            // running prefix sum mod p
            curr = (curr + nums[j]) % p;
            // remainder we need to have seen before to form a valid subarray
            int rem = (curr - target + p) % p;
            // if rem was seen before, subarray between that index and j has sum ≡ target (mod p)
            if (map.containsKey(rem))
                res = Math.min(res, j - map.get(rem));
            // store or overwrite current remainder with latest index
            map.put(curr, j);
        }
        // res == n means we'd remove entire array which is invalid
        return res == n ? -1 : res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

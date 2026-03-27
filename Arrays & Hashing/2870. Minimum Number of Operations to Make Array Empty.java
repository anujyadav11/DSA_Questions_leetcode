/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds minimum operations to delete all elements in groups of 2 or 3 using ceil(freq/3) per distinct value, returning -1 if any frequency equals 1.
/* "The key insight is ceil(freq/3) — always prefer groups of 3 to minimize operations, and handle the remainder with a group of 2. The only impossible case is frequency 1 since neither 2 nor 3 divides it cleanly to zero. 
    Always iterate map.values() not map.keySet() when working with frequencies." */

class Solution {
    public int minOperations(int[] nums) {
        // count frequency of each distinct number
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        int res = 0;
        // iterate over frequencies (values), NOT keys
        for (int freq : map.values()) {
            // frequency of 1 is impossible — can't reduce to 0 using groups of 2 or 3
            if (freq == 1) return -1;
            // minimum operations = ceil(freq / 3) — prefer groups of 3, 
            //use group of 2 for remainder
            res += Math.ceil((double) freq / 3);
        }
        // return total minimum operations across all distinct numbers
        return res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

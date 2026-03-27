/*********************************************** JAVA **************************************************/

// Optimal Solution - Constructs a matrix with no row duplicates by using each element's current frequency as its target row index, creating new rows on demand.
/*  "The key insight is that frequency directly maps to row index — if a number has appeared k times, it belongs in row k since rows 0 to k-1 already have it. 
    This avoids any searching or set membership checks, giving a clean O(n) greedy solution." */

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        // frequency tracker for each number (nums[i] <= nums.length by constraints)
        int[] map = new int[nums.length + 1];
        List<List<Integer>> res = new ArrayList<>();
        for (int num : nums) {
            // how many times num has already appeared = which row it belongs to
            int freq = map[num];
            // if freq == res.size(), all existing rows already have this num — need a new row
            if (freq == res.size())
                res.add(new ArrayList<>());
            // place num into the row at index freq
            res.get(freq).add(num);
            // increment frequency for next occurrence of num
            map[num]++;
        }
        // return the 2D matrix with no duplicates in any row
        return res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

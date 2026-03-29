/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds all duplicates in O(n) time and O(1) space by using array values as indices and negating visited positions to detect second occurrences.
/* "The constraint that values are in [1, n] is the key — it lets us use values as indices, turning the array into its own hash map. Negation is a reversible marking trick that doesn't destroy information since Math.abs recovers the original value. 
    This pattern appears in several array problems — cycle detection, missing number, first missing positive." */

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // use abs since value may already be negated from a previous visit
            int element = Math.abs(nums[i]);
            // map value to its index (1-indexed → 0-indexed)
            int seat = element - 1;
            if (nums[seat] < 0)
                // already negated — this element appears twice
                res.add(element);
            else
                // first visit — negate to mark as seen
                nums[seat] = -nums[seat];
        }
        // return all elements that appeared exactly twice
        return res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

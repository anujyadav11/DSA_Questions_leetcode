/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds the longest subarray with equal 0s and 1s by mapping 0→-1 and tracking the earliest index of each prefix sum using a HashMap.
/* "The key insight is the 0→-1 substitution — it transforms 'equal 0s and 1s' into 'subarray sum equals 0', making it a classic prefix sum problem. Same prefix sum at two indices means the subarray between them is perfectly balanced. 
    Always seed the map with (0, -1) to handle prefixes starting at index 0." */

class Solution {
    public int findMaxLength(int[] nums) {
        // maps prefix sum to its earliest index — init with 0 at -1 for subarrays starting at index 0
        HashMap<Integer, Integer> counts = new HashMap<>();
        counts.put(0, -1);
        int maxLength = 0;
        // running prefix sum: +1 for 1, -1 for 0
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            // treat 0 as -1 so equal 0s and 1s cancel to same prefix sum
            count += (nums[i] == 0) ? -1 : 1;
            if (counts.containsKey(count))
                // same prefix sum seen before — subarray between is balanced
                maxLength = Math.max(maxLength, i - counts.get(count));
            else
                // store earliest index for this prefix sum
                counts.put(count, i);
        }
        // return length of longest balanced subarray
        return maxLength;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Sorts numbers by their digit-mapped values using a custom comparator on (mappedValue, index) pairs, preserving relative order for equal mapped values.
/* "The key is separating the sort key from the actual value — store (mappedValue, originalIndex) so sorting by mapped value still lets you recover original numbers. Always handle 0 separately since the while loop would never execute for it. 
    Collections.sort is stable so equal mapped values maintain their original relative order automatically." */

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        // stores pairs of (mappedValue, originalIndex) for sorting
        List<int[]> storePairs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int originalValue = nums[i];
            int mappedValue = 0;
            int place = 1;
            // special case: 0 maps directly to mapping[0]
            if (originalValue == 0) {
                storePairs.add(new int[]{mapping[0], i});
                continue;
            }
            // extract digits right to left, apply mapping, rebuild mapped number
            while (originalValue != 0) {
                int digit = originalValue % 10;
                // map digit and place it at correct positional value
                mappedValue = place * mapping[digit] + mappedValue;
                place *= 10;
                originalValue /= 10;
            }
            // store mapped value alongside original index to reconstruct later
            storePairs.add(new int[]{mappedValue, i});
        }
        // sort pairs by mapped value (stable — equal mapped values preserve original order)
        Collections.sort(storePairs, (a, b) -> a[0] - b[0]);
        // reconstruct result using original indices from sorted pairs
        int[] sortedNums = new int[nums.length];
        for (int i = 0; i < storePairs.size(); i++)
            sortedNums[i] = nums[storePairs.get(i)[1]];
        // return the jumbled-mapping sorted array
        return sortedNums;
    }
}

// Time Complexity :- O(n log n + d). - n numbers sorted with comparator, each mapping takes O(d) where d = number of digits
// Space Complexity :- O(n).

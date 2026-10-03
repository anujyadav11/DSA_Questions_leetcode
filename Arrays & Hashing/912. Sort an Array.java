/*********************************************** JAVA **************************************************/

// Optimal Solution - Sort an integer array using frequency counting and range-based reconstruction in O(n + R) time.
/* “I use a frequency map to count each value, then iterate from the minimum to maximum value and reconstruct the array according to each value’s frequency. 
    This avoids comparison-based sorting, giving O(n + R) time where R is the value range.” */

class Solution {
    public int[] sortArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        // Store the frequency of each number
        // and find the minimum and maximum values.
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int i = 0;
        // Traverse from minimum to maximum value
        // and place each number according to its frequency.
        for (int num = min; num <= max; num++) {
            // Keep adding the current number while
            // it still has remaining occurrences.
            while (map.getOrDefault(num, 0) > 0) {
                nums[i] = num;
                i++;
                map.put(num, map.get(num) - 1);
            }
        }
        return nums;
    }
}

// Time Complexity :- O(n + R).
// Space Complexity :- O(n).

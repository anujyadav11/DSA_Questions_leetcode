/*********************************************** JAVA **************************************************/

// Optimal Solution - Use a min heap to repeatedly multiply the smallest element and update its position efficiently.
/* "Since we must repeatedly modify the smallest element, I use a min heap to extract it efficiently, update it, and push it back." */

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        // Min heap storing {value, index}
        // Smallest value has highest priority
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            // First compare values
            int valueComparison = Integer.compare(a[0], b[0]);
            // If values are equal, compare indices to keep order stable
            if (valueComparison == 0) {
                return Integer.compare(a[1], b[1]);
            }
            return valueComparison;
        });
        // Insert all elements with their indices into the heap
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[] { nums[i], i });
        }
        // Perform k operations
        while (k-- > 0) {
            // Extract the smallest element
            int[] current = pq.poll();
            int value = current[0];
            int index = current[1];
            // Multiply the smallest element
            nums[index] = value * multiplier;
            // Insert updated value back into heap
            pq.offer(new int[] { nums[index], index });
        }
        // Return modified array
        return nums;
    }
}

// Time Complexity :- O((n + k) log n) .
// Space Complexity :- O(n).

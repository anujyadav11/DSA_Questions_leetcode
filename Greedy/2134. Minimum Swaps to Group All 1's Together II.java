/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds minimum swaps to group all ones together in a circular array using a sliding window of size equal to total ones count, minimizing zeros within the window.
/* "Window size = count of ones — any valid grouping must fit exactly that many elements. Zeros inside the window are swapped with ones outside. 
    Circular array is handled by (start + winSize) % n — cleaner than maintaining two pointers. Always add edge cases for all-zeros or all-ones arrays upfront." */

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        // window size = total number of 1s in array
        int winSize = 0;
        for (int num : nums)
            winSize += num;
        // edge case: no 1s or all 1s — no swaps needed
        if (winSize == 0 || winSize == n)
            return 0;
        // count zeros in first window
        int curZero = 0;
        for (int i = 0; i < winSize; i++)
            if (nums[i] == 0)
                curZero++;
        int minZero = curZero;
        // slide window circularly — zeros in window = swaps needed
        for (int start = 0; start < n; start++) {
            // remove outgoing element from window
            if (nums[start] == 0)
                curZero--;
            // add incoming element to window
            if (nums[(start + winSize) % n] == 0)
                curZero++;
            minZero = Math.min(minZero, curZero);
        }
        return minZero;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

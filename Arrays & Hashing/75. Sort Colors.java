/*********************************************** JAVA **************************************************/

// Map Solution - Sort an array containing 0, 1, and 2 using the Dutch National Flag three-pointer partitioning algorithm in O(n) time and O(1) space.

class Solution {
    public void sortColors(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // Count the frequency of each color.
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int i = 0;
        // Reconstruct the array in sorted order: 0, 1, 2.
        for (int num = 0; num <= 2; num++) {
            int count = map.getOrDefault(num, 0);
            // Place the current color according to its frequency.
            while (count > 0) {
                nums[i++] = num;
                count--;
            }
        }
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

/*********************************************** JAVA **************************************************/

// Dutch flag Solution - Sort an array containing 0, 1, and 2 using the Dutch National Flag three-pointer partitioning algorithm in O(n) time and O(1) space.
/* “Since the array contains only three values, I can use three pointers to partition the array into regions of 0s, 1s, and 2s. 
    The Dutch National Flag algorithm sorts the array in one pass with O(1) extra space.” */

class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        // [0 ... low-1]   -> 0s
        // [low ... mid-1] -> 1s
        // [mid ... high]  -> unknown
        // [high+1 ... n-1] -> 2s
        while (mid <= high) {
            if (nums[mid] == 0) {
                // Put 0 at the beginning.
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // 1 is already in its correct region.
                mid++;
            } else {
                // Put 2 at the end.
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

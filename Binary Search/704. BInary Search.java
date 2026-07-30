/************************************************** JAVA ************************************************/

// Solution Approach - We are using a technique to find the target or search for an element, which is called binary search. In this approach, we define two pointers, one on the left of the input and one on the right. 
                    //of the input, then we loop through the input and find the midpoint, and then we search for desired element based on condition.


class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        // Left and right pointers
        int i = 0;
        int j = n - 1;
        // Standard binary search loop
        while (i <= j) {
            // Calculate mid to avoid integer overflow
            int mid = i + (j - i) / 2;
            // If target is found, return its index
            if (nums[mid] == target) {
                return mid;
            }
            // If target is greater, ignore left half
            else if (nums[mid] < target) {
                i = mid + 1;
            }
            // If target is smaller, ignore right half
            else {
                j = mid - 1;
            }
        }
        // Target not found
        return -1;
    }
}

// Time Complexity :- O(log n).
// Space Complexity :- O(1).

// Recursive Solution:- Implemented recursive Binary Search on a sorted array, reducing the search space by half in each recursive call to achieve O(log n) time complexity.

class Solution {
    public int search(int[] nums, int target) {
        // Start binary search on the entire array
        return binarySearch(nums, 0, nums.length - 1, target);
    }
    private int binarySearch(int[] nums, int left, int right, int target) {
        // Base case: target is not present
        if (left > right) {
            return -1;
        }
        // Calculate the middle index (overflow-safe)
        int mid = left + (right - left) / 2;
        // Target found
        if (nums[mid] == target) {
            return mid;
        }
        // Search in the right half
        if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, right, target);
        }
        // Search in the left half
        return binarySearch(nums, left, mid - 1, target);
    }
}

// Time Complexity :- O(log n). iterating in one half only 
// Space Complexity :- O(log n). recursive stack memory

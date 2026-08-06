/*********************************************** JAVA **************************************************/

// Optimal Solution - We treat the array as a linked list where each value points to the next index, use Floyd’s cycle detection to find the cycle, and the entry point of that cycle corresponds to the duplicate number.

class Solution {
    public int findDuplicate(int[] nums) {
        // Step 1: Detect the meeting point inside the cycle
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        // Step 2: Move one pointer to the start
        // Both pointers now move one step at a time
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        // The meeting point is the duplicate number
        return slow;
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(1).

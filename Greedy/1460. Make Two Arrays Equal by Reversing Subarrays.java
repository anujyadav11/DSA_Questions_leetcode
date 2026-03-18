/*********************************************** JAVA **************************************************/

// Optimal Solution - Use frequency counting to verify both arrays contain identical elements in linear time.
/* "Since reversing subarrays allows any permutation, I just check whether both arrays have identical element frequencies using a counting array." */

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        // Frequency array to count occurrences of each number (0 ≤ value ≤ 1000)
        int[] frequency = new int[1001];
        // Count elements in target array
        for (int value : target) {
            frequency[value]++;
        }
        // Subtract counts using elements from arr
        for (int value : arr) {
            frequency[value]--;
        }
        // If all frequencies return to zero → arrays contain same elements
        for (int count : frequency) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

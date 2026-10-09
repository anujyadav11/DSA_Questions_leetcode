/*********************************************** JAVA **************************************************/

// Optimal Solution - Reverse a character array in-place using two pointers in O(n) time and O(1) space.
/* “I use two pointers at opposite ends of the character array. I swap their elements and move both pointers inward until they meet, reversing the array in O(n) time and O(1) extra space.” */

class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        // Swap characters until the two pointers meet.
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

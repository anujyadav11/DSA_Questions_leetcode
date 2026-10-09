/*********************************************** JAVA **************************************************/

// Optimal Solution - Validate a palindrome after at most one deletion using two pointers and greedy mismatch handling in O(n) time and O(1) space.
/* “I use two pointers to compare characters from both ends. At the first mismatch, I try skipping either the left or right character and check whether the remaining substring is a palindrome. 
    If either option works, the string is valid. This takes O(n) time and O(1) extra space.” */

class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        // Find the first pair of mismatched characters.
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Try skipping either the left or right character.
                return valid(s, left + 1, right)
                    || valid(s, left, right - 1);
            }
            left++;
            right--;
        }
        // The string is already a palindrome.
        return true;
    }
    private boolean valid(String s, int left, int right) {
        // Check whether the substring is a palindrome.
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

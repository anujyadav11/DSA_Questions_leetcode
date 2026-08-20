/*********************************************** JAVA **************************************************/

//Optimal Solution - Count all palindromic substrings by expanding around every possible centre. Every palindrome has a centre, so I expand around each index for odd and even cases to count all palindromic substrings.
/* “Every palindrome can be identified by its centre. For each character, I consider it as the centre of an odd-length palindrome and also consider the gap after it as the centre of an even-length palindrome. 
    I expand outward while the characters match, counting every valid expansion.” */

class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        // Treat every index as an odd/even palindrome center
        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindromes: center = i
            count += countPalindrome(s, i, i);
            // Even-length palindromes: center between i and i+1
            count += countPalindrome(s, i, i + 1);
        }
        return count;
    }
    private int countPalindrome(String s, int left, int right) {
        int count = 0;
        // Expand while the substring remains a palindrome
        while (left >= 0
                && right < s.length()
                && s.charAt(left) == s.charAt(right)) {

            count++;
            left--;
            right++;
        }
        return count;
    }
}

// Time Complexity :- O(N^2).
// Space Complexity :- O(1).

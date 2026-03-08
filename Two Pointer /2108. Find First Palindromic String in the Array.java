/*********************************************** JAVA **************************************************/

// Optimal Solution - Traverse words and return the first string that passes a two-pointer palindrome check.
                    // “I iterate through the words and use a two-pointer technique to check if each word is a palindrome.”

class Solution {
    public String firstPalindrome(String[] words) {
        String res = "";  // Stores the first palindrome found
        // Traverse all words
        for (String word : words) { 
            // Check if word is palindrome
            if (isPalindrome(word)) {
                res = word;
                break;  // Stop at first palindrome
            }
        }
        return res;
    }
    // Helper method to check palindrome
    public boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
        // Two pointer palindrome check
        while (left <= right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            // Move pointers
            left++;
            right--;
        }
        return true;
    }
}

// Time Complexity :- O(n * m). n is the length of the string, m is the average word length.
// Space Complexity :- O(1).

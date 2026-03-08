/*********************************************** JAVA **************************************************/

// Optimal Solution - Reverse each word in a string in-place using a two-pointer approach while preserving word order.
                    // "I convert the string into a character array so I can modify it in-place. Then I scan the array using two pointers to detect word boundaries (spaces). 
                    // Whenever I find a space, I reverse the word before it. Finally, I reverse the last word. This gives an O(n) solution with constant auxiliary space."

class Solution {
    public String reverseWords(String s) {
        // Convert the string into a character array so we can modify it in-place
        char arr[] = s.toCharArray();
        // 'left' marks the start of a word
        // 'right' scans the array to find spaces (word boundaries)
        int left = 0, right = 0;
        // Traverse the character array
        while (right < arr.length) {
            // When we encounter a space, it means a word ended
            if (arr[right] == ' ') {
                // Reverse the word from 'left' to 'right - 1'
                reverse(arr, left, right - 1);
                // Move 'left' to the start of the next word
                left = right + 1;
            }
            // Continue scanning the string
            right++;
        }
        // Reverse the last word (since it won't end with a space)
        reverse(arr, left, right - 1);
        // Convert the modified char array back to a string
        return new String(arr);
    }
    public void reverse(char[] arr, int left, int right) {
        // Standard two-pointer reversal
        while (left < right) {
            // Swap characters at left and right
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

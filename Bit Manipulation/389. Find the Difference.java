/*********************************************** JAVA **************************************************/

// Optimal Solution - Use XOR to cancel matching characters and find the extra character in linear time.
/* "I use XOR because identical characters cancel out, leaving only the extra character in the second string." */

class Solution {
    public char findTheDifference(String s, String t) {
        int xor = 0; // Variable to store XOR of all characters
        // XOR all characters from string s
        for (char ch : s.toCharArray()) {
            xor ^= ch;
        }
        // XOR all characters from string t
        for (char ch : t.toCharArray()) {
            xor ^= ch;
        }
        // The remaining value is the extra character in t
        return (char) xor;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).

/*********************************************** JAVA **************************************************/

// Optimal Solution - Sliding window with frequency tracking to find the smallest substring containing all characters of t. Maintain a required character counter and shrink the window only when all characters are satisfied.
/* “I use a sliding window with two frequency arrays. mapT stores the frequency requirement for the target string, while mapS stores the frequencies inside the current window. 
    I expand the right pointer until the window contains all required characters. Once it becomes valid, I repeatedly move the left pointer forward to minimize the window while preserving validity. 
    Whenever I find a smaller valid window, I store its starting position and length. Finally, I return that substring.” */

class Solution {
    public String minWindow(String s, String t) {
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        for (char ch : t.toCharArray())
            mapT[ch]++;
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        for (; right < s.length(); right++) {
            mapS[s.charAt(right)]++;
            while (contains(mapS, mapT)) {
                // Update the minimum valid window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                // Remove the leftmost character
                mapS[s.charAt(left++)]--;
            }
        }
        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(minStart, minStart + minLen);
    }
    public boolean contains(int[] mapS, int[] mapT) {
        // Check every possible ASCII character
        for (int i = 0; i < 256; i++) {
            if (mapT[i] > mapS[i]) {
                return false;
            }
        }
        return true;
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(1). 
